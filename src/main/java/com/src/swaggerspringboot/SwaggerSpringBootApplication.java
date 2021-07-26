package com.src.swaggerspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = {
"com.src.swaggerspringboot"
})
public class SwaggerSpringBootApplication {

	public static void main(String[] args) {

		SpringApplication.run(SwaggerSpringBootApplication.class, args);

	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	
	
	
	
	
	
}
