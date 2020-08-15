package com.shayanmalinda.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class UserManagementServer extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(UserManagementServer.class, args);
	}

	public SpringApplicationBuilder configure(SpringApplicationBuilder builder){
		return builder.sources(UserManagementServer.class);
	}


	@RequestMapping(value="/")
	public  String demo() {
		return "helloo....";
	}

}
