package com.example.sfgdi.services;

import com.example.sfgdi.repositories.EnglishGreetingRepository;

//@Profile({"EN","default"})
//@Service("I18n")
public class I18nEnglishGreetingService implements GreetingService {

    private final EnglishGreetingRepository englishGreetingRepository;

    public I18nEnglishGreetingService(EnglishGreetingRepository englishGreetingRepository) {
        this.englishGreetingRepository = englishGreetingRepository;
    }

    @Override
    public String sayGreeting() {
       return englishGreetingRepository.getGreeting();
    }
}
