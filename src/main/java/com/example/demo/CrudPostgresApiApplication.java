package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CrudPostgresApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudPostgresApiApplication.class, args);
	}
	/*
	@Bean
	   public WebMvcConfigurer corsConfigurer() {
	      return new WebMvcConfigurer() {
	         @Override
	         public void addCorsMappings(CorsRegistry registry) {
	            registry.addMapping("/api").allowedOrigins("http://localhost:4200");
	         }
	      };
	   }
	   */

}
