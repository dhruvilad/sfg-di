package com.example.sfgdi.services;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean {

    public SingletonBean() {
        System.out.println("creating singleton bean.....");
    }

    public String getMyScope(){
        return "I am singleton....";
    }
}
