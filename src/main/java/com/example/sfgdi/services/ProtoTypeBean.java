package com.example.sfgdi.services;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProtoTypeBean {

    public ProtoTypeBean() {
        System.out.println("creating ProtoType bean.....");
    }

    public String getMyScope(){
        return "I am ProtoType....";
    }
}
