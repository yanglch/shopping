package com.ylc.shoppingManage.service.impl;

import com.ylc.shoppingManage.entity.Product;
import com.ylc.shoppingManage.mapper.ProductDao;
import com.ylc.shoppingManage.service.ProductService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ylc
 * @since 2018-08-06
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductDao, Product> implements ProductService {

}
