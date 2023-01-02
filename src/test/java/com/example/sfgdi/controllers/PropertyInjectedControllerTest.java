package com.example.sfgdi.controllers;

import com.example.sfgdi.services.ConstructorInjectedGreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyInjectedControllerTest {

    PropertyInjectedController propertyInjectedController;

    @BeforeEach
    void setUp(){
       propertyInjectedController=new PropertyInjectedController();

       propertyInjectedController.greetingService=new ConstructorInjectedGreetingService();
    }

    @Test
    void getGreeting() {

        System.out.println(propertyInjectedController.getGreeting());
    }
}