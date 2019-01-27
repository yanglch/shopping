package com.ylc.shopping.web.home.controller;
//
//import com.alibaba.fastjson.JSONObject;
//import com.baomidou.mybatisplus.plugins.Page;
//import com.ylc.shoppingManage.entity.Product;
//import com.ylc.shoppingManage.entity.ProductType;
//import com.ylc.shoppingManage.entity.ProductTypeJoin;
//import com.ylc.shoppingManage.service.ProductService;
//import com.ylc.shoppingManage.service.ProductTypeJoinService;
//import com.ylc.shoppingManage.service.ProductTypeService;
//import com.ylc.shoppingManage.web.form.ProductForm;
//import com.ylc.shoppingmanage.web.home.transfer.ProductTransfer;
//import ProductTypeTransfer;
//import JsonResult;
//import Pagination;
//import com.ylc.shoppingmanage.web.home.vo.ProductTypeVo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.util.CollectionUtils;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * <p>
// *  前端控制器
// * </p>
// *
// * @author ylc
// * @since 2018-08-06
// */
//@RestController
//@RequestMapping("/productType")
public class ProductTypeController {
//
//    @Autowired
//    private ProductTypeService      productTypeService;
//
//    @Autowired
//    private ProductTypeJoinService  productTypeJoinService;
//
//    @Autowired
//    private ProductService          productService;
//
//    @GetMapping("/queryPageList")
//    public JsonResult queryPageList(int pageSize, int pageNum){
//        if(pageSize <= 0){
//            pageSize = 20;
//        }
//        if(pageNum <= 0){
//            pageNum = 1;
//        }
//        Page<ProductType> page = new Page<>(pageNum, pageSize, "gmt_create", false);
//        productTypeService.selectPage(page);
//
//        Pagination pagination = new Pagination();
//        pagination.setCurrent(pageNum);
//        pagination.setPageSize(pageSize);
//        pagination.setTotal(page.getTotal());
//
//        JSONObject data = new JSONObject();
//        data.put("pagination", pagination);
//        data.put("list", page.getRecords());
//        return JsonResult.newJsonResultSuccess(data);
//    }
//
//    @GetMapping("/queryOne")
//    public JsonResult queryOne(long id){
//        JsonResult result = new JsonResult(false);
//        ProductTypeVo productTypeVo = ProductTypeTransfer.toBo(productTypeService.selectById(id));
//        if(productTypeVo == null){
//            result.setMsg("找不到对应id的类型信息");
//            return result;
//        }
//        Map<String, Object> map = new HashMap<>(1);
//        map.put("type_id", productTypeVo.getId());
//        List<ProductTypeJoin> productTypeJoinList = productTypeJoinService.selectByMap(map);
//        List<ProductForm> productFormList = new ArrayList<>(16);
//        if(!CollectionUtils.isEmpty(productTypeJoinList)){
//            productTypeJoinList.forEach(join->{
//                Product product = productService.selectById(join.getProductId());
//                productFormList.add(ProductTransfer.toForm(product));
//            });
//        }
//        productTypeVo.setProductForm(productFormList);
//        return JsonResult.jsonResultSuccess(result,productTypeVo, true);
//    }
//
//    @PostMapping("/add")
//    public JsonResult add(ProductType productType){
//        JsonResult result = new JsonResult(false);
//        if (!verify(productType, result)) {
//            return result;
//        }
//        productType.setGmtCreate(new Date());
//        productType.setGmtUpdate(new Date());
//        productType.setParent(0L);
//        productTypeService.insert(productType);
//        return JsonResult.jsonResultSuccess(result, null, true);
//    }
//
//    @PostMapping("/update")
//    public JsonResult update(ProductType productType){
//        JsonResult result = new JsonResult(false);
//        if (!verify(productType, result)) {
//            return result;
//        }
//        productType.setGmtCreate(null);
//        productType.setGmtUpdate(new Date());
//        productType.setParent(0L);
//        productTypeService.updateById(productType);
//        return JsonResult.jsonResultSuccess(result, null, true);
//    }
//
//    private boolean verify(ProductType productType, JsonResult result) {
//        if(productType == null){
//            result.setMsg("参数不能为空!");
//            return false;
//        }
//        if(!StringUtils.hasText(productType.getName())){
//            result.setMsg("类型名称不能为空!");
//            return false;
//        }
//        return true;
//    }
//
}
//
