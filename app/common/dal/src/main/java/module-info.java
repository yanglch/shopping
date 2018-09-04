module com.ylc.shopping.common.dal {
    requires spring.beans;
    requires spring.core;
    requires spring.context;
    requires spring.tx;
    requires java.sql;
    exports com.ylc.shopping.common.dal.mybatis to com.ylc.shopping.biz.shared;
    exports com.ylc.shopping.common.dal.dataobject to com.ylc.shopping.biz.shared;
}
