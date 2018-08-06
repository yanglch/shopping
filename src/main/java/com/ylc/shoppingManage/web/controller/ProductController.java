package com.ylc.shoppingManage.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.ylc.shoppingManage.entity.Product;
import com.ylc.shoppingManage.entity.ProductTypeJoin;
import com.ylc.shoppingManage.enums.ProductStatusEnum;
import com.ylc.shoppingManage.service.ProductService;
import com.ylc.shoppingManage.service.ProductTypeJoinService;
import com.ylc.shoppingManage.web.form.ProductForm;
import com.ylc.shoppingManage.web.transfer.ProductTransfer;
import com.ylc.shoppingManage.web.vo.JsonResult;
import com.ylc.shoppingManage.web.vo.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  商品前端控制器
 * </p>
 *
 * @author ylc
 * @since 2018-08-06
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService          productService;

    @Autowired
    private ProductTypeJoinService  productTypeJoinService;

    @Autowired
    private TransactionTemplate     transactionTemplate;

    @GetMapping("/queryPageList")
    public JsonResult queryPageList(int pageSize, int pageNum){
        if(pageSize <= 0){
            pageSize = 20;
        }
        if(pageNum <= 0){
            pageNum = 1;
        }
        Page<Product> page = new Page<>(pageNum, pageSize, "gmt_create", false);
        productService.selectPage(page);
        List<ProductForm> list = new ArrayList<>(20);
        if(!CollectionUtils.isEmpty(page.getRecords())){
            page.getRecords().forEach(product->{
                ProductForm form = ProductTransfer.toForm(product);
                form.setTypeIdList(new ArrayList<>(5));
                Map<String, Object> map = new HashMap<>(5);
                map.put("product_id", product.getId());
                List<ProductTypeJoin> productTypeJoinList = productTypeJoinService.selectByMap(map);
                if(!CollectionUtils.isEmpty(productTypeJoinList)){
                    productTypeJoinList.forEach(join->{
                        form.getTypeIdList().add(join.getTypeId());
                    });
                }
                list.add(form);
            });
        }

        Pagination pagination = new Pagination();
        pagination.setCurrent(pageNum);
        pagination.setPageSize(pageSize);
        pagination.setTotal(page.getTotal());

        JSONObject data = new JSONObject();
        data.put("pagination", pagination);
        data.put("list", list);
        return JsonResult.newJsonResultSuccess(data);
    }

    @GetMapping("/queryOne")
    public JsonResult queryOne(long id){
        Product product = productService.selectById(id);
        return JsonResult.newJsonResultSuccess(product);
    }

    @PostMapping("/add")
    public JsonResult add(@RequestBody ProductForm product){
        JsonResult result = new JsonResult(false);
        if (!verify(product, result)) {
            return result;
        }

        transactionTemplate.execute(new TransactionCallbackWithoutResult(){
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                Product productDo = ProductTransfer.toDo(product);
                productDo.setStatus(ProductStatusEnum.ON_DOWN.getCode());
                productDo.setGmtCreate(new Date());
                productService.insert(productDo);
                List<ProductTypeJoin> productTypeJoinList = getProductTypeJoins(product);
                productTypeJoinService.insertBatch(productTypeJoinList);
            }
        });

        return JsonResult.jsonResultSuccess(result, null, true);
    }

    @PostMapping("/update")
    public JsonResult update(@RequestBody ProductForm product){
        JsonResult result = new JsonResult(false);
        if (!verify(product, result)) {
            return result;
        }
        if(product.getId() == null){
            result.setMsg("商品id不能为空!");
            return result;
        }
        Product productData = productService.selectById(product.getId());
        if(productData == null){
            result.setMsg("找不到相应的商品无法修改!");
            return result;
        }
        if(productData.getStatus().equals(ProductStatusEnum.ON_UP.getCode())){
            result.setMsg("上架中的商品无法修改！需先下架！");
            return result;
        }
        product.setStatus(null);
        transactionTemplate.execute(new TransactionCallbackWithoutResult(){
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                productService.updateById(ProductTransfer.toDo(product));
                List<ProductTypeJoin> productTypeJoinList = getProductTypeJoins(product);
                Map<String, Object> map = new HashMap<>(5);
                map.put("product_id", product.getId());
                productTypeJoinService.deleteByMap(map);
                productTypeJoinService.insertBatch(productTypeJoinList);
            }
        });

        return JsonResult.jsonResultSuccess(result, null, true);
    }

    @PostMapping("/updateStatus")
    public JsonResult updateStatus(long id, String status){
        ProductStatusEnum statusEnum = ProductStatusEnum.getByCode(status);
        if(statusEnum == null){
            return new JsonResult("系统不支持的状态类型!", null, false);
        }
        Product product = new Product();
        product.setStatus(statusEnum.getCode());
        product.setId(id);
        productService.updateById(product);
        return new JsonResult(true);
    }

    @GetMapping("/delete")
    public JsonResult delete(long id){
        productService.deleteById(id);
        return JsonResult.newJsonResultSuccess();
    }

    private boolean verify(ProductForm product, JsonResult result) {
        if(product == null){
            result.setMsg("参数不能为空!");
            return false;
        }
        if(!StringUtils.hasText(product.getName())){
            result.setMsg("商品名称不能为空!");
            return false;
        }
        if(product.getCount() == null || product.getCount() <= 0){
            result.setMsg("商品数量不能为空!");
            return false;
        }
        if(product.getPrice() == null || product.getPrice().compareTo(BigDecimal.ZERO) < 1){
            result.setMsg("商品价格不能为空或不能小于等于0!");
            return false;
        }
        if(CollectionUtils.isEmpty(product.getTypeIdList())){
            result.setMsg("商品类型不能为空!");
            return false;
        }
        return true;
    }

    private List<ProductTypeJoin> getProductTypeJoins(@RequestBody ProductForm product) {
        List<ProductTypeJoin> productTypeJoinList = new ArrayList<>(5);
        product.getTypeIdList().forEach(x->{
            ProductTypeJoin productTypeJoin = new ProductTypeJoin();
            productTypeJoin.setProductId(product.getId());
            productTypeJoin.setTypeId(x);
            productTypeJoinList.add(productTypeJoin);
        });
        return productTypeJoinList;
    }
}

