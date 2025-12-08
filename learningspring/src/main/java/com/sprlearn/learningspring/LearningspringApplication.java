package com.sprlearn.learningspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class LearningspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningspringApplication.class, args);
	}

}
