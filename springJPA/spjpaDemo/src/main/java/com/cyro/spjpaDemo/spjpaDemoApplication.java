package com.cyro.spjpaDemo;

import com.cyro.spjpaDemo.model.User;
import com.cyro.spjpaDemo.repo.UserRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class spjpaDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(spjpaDemoApplication.class, args);

	}

}
