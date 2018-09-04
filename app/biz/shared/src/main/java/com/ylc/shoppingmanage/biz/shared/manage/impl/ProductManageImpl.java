package com.ylc.shoppingmanage.biz.shared.manage.impl;

import com.ylc.shopping.common.dal.mybatis.ProductMapper;
import com.ylc.shoppingmanage.biz.shared.manage.ProductManage;
import com.ylc.shoppingmanage.biz.shared.vo.ProductVo;
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
public class ProductManageImpl implements ProductManage {

    @Override
    public String getName() {
        return "ylc";
    }

    @Override
    public ProductVo a() {
        return new ProductVo();
    }
}
