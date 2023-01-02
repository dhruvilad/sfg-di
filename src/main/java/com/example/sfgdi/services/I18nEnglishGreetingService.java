package com.example.sfgdi.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"EN","default"})
@Service("I18n")
public class I18nEnglishGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {

        return "Heloo world!!! -- EN";
    }
}
