package com.src.swaggerspringboot;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = {
"com.src.swaggerspringboot"
})
public class SwaggerSpringBootApplication {
	
	@Autowired
	MyApp myApp;
	@Autowired
	SlackApp slackApp;
	
	public static void main(String[] args) {
		SpringApplication.run(SwaggerSpringBootApplication.class, args);
	}
	
	//@PostConstruct
	public void initSlackServer() {
		myApp.initServer(slackApp.loadOAuthConfig());
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	
	
	
	
	
	
}
