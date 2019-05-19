package com.exp.expresspro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = "com.exp")
@SpringBootApplication
public class ExpressProApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpressProApplication.class, args);
	}

}
