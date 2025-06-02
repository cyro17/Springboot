package com.cyro.demo_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;


@EnableAsync
@SpringBootApplication
public class demoApplication {

	public static void main(String[] args) {
		SpringApplication.run(demoApplication.class, args);
	}

}
