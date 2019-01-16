module com.ylc.shopping.common.dal {
    requires spring.beans;
    requires spring.core;
    requires spring.context;
    requires spring.tx;
    requires java.sql;
    requires java.management;
    requires mybatis.spring;
    requires mybatis.generator.core;
    requires druid;
    requires java.naming;
    exports com.ylc.shopping.common.dal.mybatis;
    exports com.ylc.shopping.common.dal.dataobject;
}
