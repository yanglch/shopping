/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.ylc.shopping.test.config;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.util.IntrospectorCleanupListener;

import javax.servlet.ServletContextEvent;
import java.io.FileNotFoundException;
import java.nio.file.Path;

/**
 *
 * @author ylc
 * @version $Id: MyCommandLineRunner.java, v 0.1 2018年08月12日 18:33 ylc Exp $
 */
@Component
public class MyCommandLineRunner extends IntrospectorCleanupListener {

    private final String SPRING_XML_PATH = "src/main/resources/META-INF/spring/*.xml";

    private final String COMMON_DAL_PATH = String.format("app/common/dal/%s", SPRING_XML_PATH);

    private final String BIZ_SHARED_PATH = String.format("app/biz/shared/%s", SPRING_XML_PATH);

    private final String BIZ_SERVICE_INPM_PATH = String.format("app/biz/service-impl/%s", SPRING_XML_PATH);

    @Override
    public void contextInitialized(ServletContextEvent event) {
        try {
            String path = ResourceUtils.getURL("").getPath();
            new Thread(()->{
                new ClassPathXmlApplicationContext("file:" + path + COMMON_DAL_PATH);
                new ClassPathXmlApplicationContext(path + BIZ_SHARED_PATH);
                new ClassPathXmlApplicationContext(path + BIZ_SERVICE_INPM_PATH);
            }).start();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        super.contextInitialized(event);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        super.contextDestroyed(event);
    }
}