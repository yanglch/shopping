/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.ylc.shopping.bootstrap.loader;

import com.ylc.shopping.bootstrap.context.ModuleWebApplicationContext;
import com.ylc.shopping.bootstrap.processor.ModuleBeanFactoryPostProcessor;
import com.ylc.shopping.bootstrap.module.SpringModuleDescriptor;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.factory.annotation.QualifierAnnotationAutowireCandidateResolver;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.propertyeditors.ClassArrayEditor;
import org.springframework.beans.propertyeditors.ClassEditor;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;

import java.util.Map;

/**
 *
 * @author ylc
 * @version $Id: DefaultSpringModuleLoader.java, v 0.1 2019年01月28日 0:36 ylc Exp $
 */
public class DefaultSpringModuleLoader implements SpringModuleLoader {

    private SpringModuleDescriptor springModuleDescriptor;

    public DefaultSpringModuleLoader(SpringModuleDescriptor springModuleDescriptor) {
        this.springModuleDescriptor = springModuleDescriptor;
    }

    @Override
    public void loadSpringModule() {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        beanFactory.setParameterNameDiscoverer(new LocalVariableTableParameterNameDiscoverer());
        beanFactory.setAutowireCandidateResolver(new QualifierAnnotationAutowireCandidateResolver());
        GenericApplicationContext ctx = new ModuleWebApplicationContext(beanFactory);
        ctx.setParent(springModuleDescriptor.getRootApplicationContext());
        ctx.setAllowBeanDefinitionOverriding(false);
        ctx.getBeanFactory().addPropertyEditorRegistrar(new PropertyEditorRegistrar() {
            public void registerCustomEditors(PropertyEditorRegistry registry) {
                registry.registerCustomEditor(Class.class, new ClassEditor(this.getClass().getClassLoader()));
                registry.registerCustomEditor(Class[].class, new ClassArrayEditor(this.getClass().getClassLoader()));
            }
        });
        XmlBeanDefinitionReader beanDefinitionReader = createXmlBeanDefinitionReader(ctx);
        springModuleDescriptor.getSpringResources().forEach((k, v) -> beanDefinitionReader.loadBeanDefinitions(v));
        addPostProcessors(beanFactory);
        ctx.setId(springModuleDescriptor.getModuleReference().descriptor().name());
        ctx.refresh();
    }

    @SuppressWarnings("unchecked")
    protected void addPostProcessors(DefaultListableBeanFactory beanFactory) {
        Map<String, BeanDefinition> processors = (Map<String, BeanDefinition>) springModuleDescriptor
                .getRootApplicationContext()
                .getBean(ModuleBeanFactoryPostProcessor.PROCESSORS_OF_ROOT_APPLICATION_CONTEXT);
        for (Map.Entry<String, BeanDefinition> entry : processors.entrySet()) {
            if (!beanFactory.containsBeanDefinition(entry.getKey())) {
                beanFactory.registerBeanDefinition(entry.getKey(), entry.getValue());
            }
        }
    }

    protected XmlBeanDefinitionReader createXmlBeanDefinitionReader(GenericApplicationContext ctx) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(ctx);
        beanDefinitionReader.setValidating(true);
        beanDefinitionReader.setNamespaceAware(true);
        beanDefinitionReader.setResourceLoader(ctx);
        return beanDefinitionReader;
    }

    protected DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }
}