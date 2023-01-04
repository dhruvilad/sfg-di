package com.example.sfgdi.config;

import com.example.pet.services.PetService;
import com.example.pet.services.PetServiceFactory;
import com.example.sfgdi.datasource.FakeDatasource;
import com.example.sfgdi.repositories.EnglishGreetingRepository;
import com.example.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import com.example.sfgdi.services.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

//@PropertySource("classpath:datasource.properties")
@ImportResource("classpath:sfgdi-config.xml")
@Configuration
public class GreetingServiceConfig {

    @Bean
    FakeDatasource fakeDatasource(@Value("${guru.username}") String username,
                                  @Value("${guru.password}") String passowrd,
                                  @Value("${guru.jdbcurl}") String jdbcurl){
        FakeDatasource fakeDatasource=new FakeDatasource();
        fakeDatasource.setJdbcurl(jdbcurl);
        fakeDatasource.setUsername(username);
        fakeDatasource.setPassowrd(passowrd);

        return fakeDatasource;
    }




    @Bean
    PetServiceFactory petServiceFactory(){
        return  new PetServiceFactory();
    }

    @Bean("pet")
    @Profile({"dog", "default"})
    PetService dogPetService(PetServiceFactory petServiceFactory){
       return petServiceFactory.getPetService("dog");
    }
    @Bean("pet")
    @Profile("cat")
    PetService catPetService(PetServiceFactory petServiceFactory){
       return petServiceFactory.getPetService("cat");
    }


    @Profile({"SP","default"})
    @Bean("I18n")
    I18nSpanishGreetingService i18nSpanishGreetingService(){
        return new I18nSpanishGreetingService();
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl();
    }

    @Bean
    @Profile("EN")
    I18nEnglishGreetingService I18n(EnglishGreetingRepository englishGreetingRepository){
        return  new I18nEnglishGreetingService(englishGreetingRepository);
    }

    @Bean
    @Primary
    PrimaryGreetingService primaryGreetingService(){
        return new PrimaryGreetingService();
    }

   // @Bean
    ConstructorInjectedGreetingService constructorInjectedGreetingService(){
        return new ConstructorInjectedGreetingService();
    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){
        return new PropertyInjectedGreetingService();
    }
}
