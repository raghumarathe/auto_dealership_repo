package com.rm.auto.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.rm.auto.controller","com.rm.auto.service","com.rm.auto.entity","com.rm.auto.repository"})
@SpringBootApplication
public class AutoMakesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoMakesServiceApplication.class, args);
	}

}
