module com.ylc.shopping.biz.shared {
    requires com.ylc.shopping.common.dal;
    requires spring.context;

    provides com.ylc.shoppingmanage.biz.shared.manage.ProductManage with com.ylc.shoppingmanage.biz.shared.manage.impl.ProductManageImpl;

    exports com.ylc.shoppingmanage.biz.shared.manage;
    exports com.ylc.shoppingmanage.biz.shared.vo;
}
