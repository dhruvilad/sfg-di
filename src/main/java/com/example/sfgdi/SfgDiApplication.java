package com.example.sfgdi;

import com.example.pet.controllers.PetController;
import com.example.sfgdi.controllers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.sfgdi","com.example.pet"})
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SfgDiApplication.class, args);

		PetController petController = ctx.getBean("petController", PetController.class);
		System.out.println("--- The Best Pet is ---");
		System.out.println(petController.whichPetIsTheBest());



		I18nController i18nController=(I18nController) ctx.getBean("i18nController");
		System.out.println("-------------- i18nController");
		System.out.println(i18nController.sayHello());

		MyController myController=(MyController) ctx.getBean("myController");

		System.out.println("-------------- my cotroller");
		System.out.println(myController.sayHello());

		System.out.println("------------------ Poperty");

		PropertyInjectedController propertyInjectedController= (PropertyInjectedController) ctx.getBean("propertyInjectedController");

		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("------------------ Setter");

		SetterInjectionController setterInjectionController= (SetterInjectionController) ctx.getBean("setterInjectionController");

		System.out.println(setterInjectionController.getGreeting());

		System.out.println("------------------ Constructor");

		ConstructorInjectedController constructorInjectedController= (ConstructorInjectedController) ctx.getBean("constructorInjectedController");

		System.out.println(constructorInjectedController.getGreeting());
	}

}
