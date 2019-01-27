module com.ylc.shopping.web.home {
    requires spring.web;
    requires spring.beans;
    requires spring.boot;
    requires spring.context;
    requires com.ylc.shopping.common.dal;
    requires druid.spring.boot.starter;
    requires spring.boot.autoconfigure;
    exports com.ylc.shopping.web.home.controller;
    opens com.ylc.shopping.web.home.controller;
}