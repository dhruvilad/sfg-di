package com.example.sfgdi.controllers;

import com.example.sfgdi.services.ConstructorInjectedGreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SetterInjectionControllerTest {

    SetterInjectionController setterInjectionController;

    @BeforeEach
    void setUp() {
        setterInjectionController =new SetterInjectionController();
        setterInjectionController.setGreetingService(new ConstructorInjectedGreetingService());
    }

    @Test
    void getGreeting() {
        System.out.println(setterInjectionController.getGreeting());
    }
}