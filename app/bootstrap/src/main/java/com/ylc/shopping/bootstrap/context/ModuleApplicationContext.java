/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.ylc.shopping.bootstrap.context;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.util.Assert;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Set;

/**
 *
 * @author ylc
 * @version $Id: MyModuleApplicationContext.java, v 0.1 2019年01月27日 4:32 ylc Exp $
 */
@Configuration
public class ModuleApplicationContext extends GenericApplicationContext {
    private static final Method getApplicationEventMulticasterMethod;
    private static final Field  earlyApplicationEventsField;

    static {
        try {
            getApplicationEventMulticasterMethod = AbstractApplicationContext.class
                    .getDeclaredMethod("getApplicationEventMulticaster");
            getApplicationEventMulticasterMethod.setAccessible(true);
            earlyApplicationEventsField = AbstractApplicationContext.class
                    .getDeclaredField("earlyApplicationEvents");
            earlyApplicationEventsField.setAccessible(true);
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    /**
     * Create a new SofaModuleApplicationContext with the given DefaultListableBeanFactory.
     * @param beanFactory the DefaultListableBeanFactory instance to use for this context
     * @see #registerBeanDefinition
     * @see #refresh
     */
    public ModuleApplicationContext(DefaultListableBeanFactory beanFactory) {
        super(beanFactory);
    }

    /**
     * Publish the given event to all listeners.
     * @param event the event to publish (may be an {@link ApplicationEvent}
     * or a payload object to be turned into a {@link PayloadApplicationEvent})
     * @param eventType the resolved event type, if known
     * @since 4.2
     */
    protected void publishEvent(Object event, ResolvableType eventType) {
        Assert.notNull(event, "Event must not be null");
        if (logger.isTraceEnabled()) {
            logger.trace("Publishing event in " + getDisplayName() + ": " + event);
        }

        // Decorate event as an ApplicationEvent if necessary
        ApplicationEvent applicationEvent;
        if (event instanceof ApplicationEvent) {
            applicationEvent = (ApplicationEvent) event;
        } else {
            applicationEvent = new PayloadApplicationEvent<>(this, event);
            if (eventType == null) {
                eventType = ((PayloadApplicationEvent) applicationEvent).getResolvableType();
            }
        }

        Set<ApplicationEvent> earlyApplicationEvents = getFieldValueByReflect(
                earlyApplicationEventsField, this);
        if (earlyApplicationEvents != null) {
            earlyApplicationEvents.add(applicationEvent);
        } else {
            ApplicationEventMulticaster applicationEventMulticaster = getMethodValueByReflect(
                    getApplicationEventMulticasterMethod, this);
            applicationEventMulticaster.multicastEvent(applicationEvent, eventType);
        }
    }

    @SuppressWarnings("unchecked")
    private <T> T getFieldValueByReflect(Field field, Object obj) {
        try {
            return (T) field.get(obj);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    private <T> T getMethodValueByReflect(Method method, Object obj, Object... args) {
        try {
            return (T) method.invoke(obj, args);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}