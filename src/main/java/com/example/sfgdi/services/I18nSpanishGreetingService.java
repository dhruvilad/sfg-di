package com.example.sfgdi.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

//@Profile("SP")
//@Service("I18n")
public class I18nSpanishGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {

        return "Hola mundo-------SPanish";
    }
}
