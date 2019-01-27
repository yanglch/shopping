/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.ylc.shopping.bootstrap.listeners;

import com.ylc.shopping.bootstrap.stage.ModuleProcessStage;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ylc
 * @version $Id: MyModuleContextRefreshedListener.java, v 0.1 2019年01月26日 14:53 ylc Exp $
 */
@Configuration
public class ModuleContextRefreshedListener implements PriorityOrdered,
        ApplicationListener<ContextRefreshedEvent>,
        ApplicationContextAware {

    private ApplicationContext rootApplicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.rootApplicationContext = applicationContext;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (rootApplicationContext == event.getApplicationContext()) {
            List<ModuleProcessStage> moduleProcessStage = getModuleProcessStage(rootApplicationContext);
            moduleProcessStage.forEach(stage -> {
                try {
                    stage.process();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }

    private List<ModuleProcessStage> getModuleProcessStage(ApplicationContext applicationContext) {
        Map<String, ModuleProcessStage> allStage = applicationContext.getBeansOfType(ModuleProcessStage.class);
        List<ModuleProcessStage> orderStage = new ArrayList<>();
        if (CollectionUtils.isEmpty(allStage)) {
            throw new RuntimeException();
        }
        allStage.forEach((k, v) -> orderStage.add(v));
        //TODO mock排序
        return orderStage;
    }
}