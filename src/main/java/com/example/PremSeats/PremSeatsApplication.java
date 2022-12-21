package com.example.PremSeats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.*;


@SpringBootApplication
@EnableWebSecurity
public class PremSeatsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PremSeatsApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE","OPTIONS").allowedOrigins("*")
						.allowedHeaders("*");
			}
		};
	}

}


