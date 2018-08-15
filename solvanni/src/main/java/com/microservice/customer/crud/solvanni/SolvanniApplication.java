package com.microservice.customer.crud.solvanni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.microservice.customer.crud.solvanni.util.ProjectInterceptor;

@EntityScan("com.microservice.customer.crud.solvanni.entity")
@SpringBootApplication(scanBasePackages = { "com.microservice.customer.crud.solvanni" })
public class SolvanniApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(SolvanniApplication.class, args);
	}

	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new ProjectInterceptor()).addPathPatterns("/**");
	}

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
