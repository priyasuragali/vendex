package com.vendex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.vendex")
public class VendexApplication {

	public static void main(String[] args) {
		SpringApplication.run(VendexApplication.class, args);
	}

}
