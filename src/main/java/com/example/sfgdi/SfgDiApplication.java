package com.example.sfgdi;

import com.example.pet.controllers.PetController;
import com.example.sfgdi.config.SfgConfiguration;
import com.example.sfgdi.config.SfgConstructorConfiguration;
import com.example.sfgdi.controllers.*;
import com.example.sfgdi.datasource.FakeDatasource;
import com.example.sfgdi.services.ProtoTypeBean;
import com.example.sfgdi.services.SingletonBean;
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

		System.out.println("------------ bean scope demo--------------------------");
		SingletonBean singletonBean1=ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean1.getMyScope());
		SingletonBean singletonBean2=ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean2.getMyScope());

		ProtoTypeBean protoTypeBean1=ctx.getBean(ProtoTypeBean.class);
		System.out.println(protoTypeBean1.getMyScope());
		ProtoTypeBean protoTypeBean2=ctx.getBean(ProtoTypeBean.class);
		System.out.println(protoTypeBean2.getMyScope());

		System.out.println("------------- property file demo ------------------");
		FakeDatasource fakeDatasource=ctx.getBean(FakeDatasource.class);
		System.out.println(fakeDatasource.getUsername());
		System.out.println(fakeDatasource.getPassowrd());
		System.out.println(fakeDatasource.getJdbcurl());


		System.out.println("------------config property bean------------------");
		SfgConfiguration sfgConfiguration=ctx.getBean(SfgConfiguration.class);
		System.out.println(sfgConfiguration.getUsername());
		System.out.println(sfgConfiguration.getPassword());
		System.out.println(sfgConfiguration.getJdbcurl());

		System.out.println("--------------------- Constructor Binding ------------------");

		SfgConstructorConfiguration sfgConstructorConfiguration=ctx.getBean(SfgConstructorConfiguration.class);
		System.out.println(sfgConstructorConfiguration.getUsername());
		System.out.println(sfgConstructorConfiguration.getPassword());
		System.out.println(sfgConstructorConfiguration.getJdbcurl());


	}

}
