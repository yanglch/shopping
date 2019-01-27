/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.ylc.shopping.bootstrap.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ylc
 * @version $Id: MyModuleBeanFactoryPostProcessor.java, v 0.1 2019年01月27日 3:38 ylc Exp $
 */
@Configuration
public class ModuleBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    private final String[] whiteNameList = new String[] {
            ConfigurationClassPostProcessor.class.getName() + ".importAwareProcessor",
            ConfigurationClassPostProcessor.class.getName() + ".importRegistry",
            ConfigurationClassPostProcessor.class.getName() + ".enhancedConfigurationProcessor" };

    public final static String PROCESSORS_OF_ROOT_APPLICATION_CONTEXT = "PROCESSORS_OF_ROOT_APPLICATION_CONTEXT";

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
            throws BeansException {
        Map<String, BeanDefinition> postProcessorDefinitions = getBeanDefinitionsForType(
                beanFactory, BeanPostProcessor.class, BeanFactoryPostProcessor.class);
        beanFactory.registerSingleton(PROCESSORS_OF_ROOT_APPLICATION_CONTEXT, postProcessorDefinitions);
    }

    private Map<String, BeanDefinition> getBeanDefinitionsForType(ConfigurableListableBeanFactory beanFactory,
                                                                  Class... types) {
        Map<String, BeanDefinition> map = new HashMap<>();
        for (Class type : types) {
            String[] beanNamesForType = beanFactory.getBeanNamesForType(type);
            List<String> beanDefinitionNames = Arrays.asList(beanFactory.getBeanDefinitionNames());
            for (String beanName : beanNamesForType) {
                if (notInWhiteNameList(beanName) && beanDefinitionNames.contains(beanName)) {
                    map.put(beanName, beanFactory.getBeanDefinition(beanName));
                }
            }
        }

        return map;
    }

    private boolean notInWhiteNameList(String beanName) {
        for (String whiteName : whiteNameList) {
            if (whiteName.equals(beanName)) {
                return false;
            }
        }
        return true;
    }
}