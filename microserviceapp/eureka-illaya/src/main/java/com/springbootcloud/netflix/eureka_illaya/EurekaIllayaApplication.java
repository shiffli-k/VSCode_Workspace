package com.springbootcloud.netflix.eureka_illaya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaIllayaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaIllayaApplication.class, args);
	}

}
