package com.weatherexpress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = "com.weatherexpress")
@SpringBootApplication
public class ExpressProApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpressProApplication.class, args);
	}

}
