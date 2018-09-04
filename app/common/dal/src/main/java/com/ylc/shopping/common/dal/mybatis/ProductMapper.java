package com.ylc.shopping.common.dal.mybatis;

import com.ylc.shopping.common.dal.dataobject.ProductDO;

import java.util.List;

/**
*  @author ylc
*/
public interface ProductMapper{

    int insertproduct(ProductDO object);

    int updateproduct(ProductDO object);

    int update(ProductDO.UpdateBuilder object);

    List<ProductDO> queryproduct(ProductDO object);

    ProductDO queryproductLimit1(ProductDO object);
}