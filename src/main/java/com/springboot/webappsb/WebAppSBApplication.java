package com.springboot.webappsb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class WebAppSBApplication {

	public static void main(String[] args) {
		ApplicationContext ctx= SpringApplication.run(WebAppSBApplication.class, args);
		for(String s : ctx.getBeanDefinitionNames()){
			System.out.println(s);
		}
	}
}
