package com.example.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class RegistrationEurekaApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(RegistrationEurekaApplication.class).web(true).run(args);
	}
}
