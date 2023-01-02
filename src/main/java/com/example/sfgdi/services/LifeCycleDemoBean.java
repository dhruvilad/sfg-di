package com.example.sfgdi.services;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class LifeCycleDemoBean implements InitializingBean, DisposableBean, BeanNameAware,
        BeanFactoryAware, ApplicationContextAware {

    public LifeCycleDemoBean() {
        System.out.println("## Inside lifecyclebean constructor");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("## the lifecycle bean has its property set");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("## lifecycle bean has been terminated");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("## my bean name is :: "+s);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("## bean factory name is set");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("## application context has been set");
    }

    @PostConstruct
    public void postContruct(){
        System.out.println("## the post construct method has been called.......");
    }

    @PreDestroy
    public  void  preDestroy(){
        System.out.println("## the pre destroy method ahs been called....");
    }

    public void beforeInit(){
        System.out.println("## before init -- called by bean post processor");
    }

    public void afterInit(){
        System.out.println("## after init called by bean post processor");
    }
}
