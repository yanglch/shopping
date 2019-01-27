module com.ylc.shopping.common.dal {
    requires mybatis.plus.support;
    requires static lombok;
    requires spring.context;
    requires mybatis.spring;
    requires druid;
    requires mysql.connector.java;
    requires java.naming;
    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires java.sql;
    exports com.ylc.shopping.common.dal.mybatis;
    exports com.ylc.shopping.common.dal.dataobject;
}
