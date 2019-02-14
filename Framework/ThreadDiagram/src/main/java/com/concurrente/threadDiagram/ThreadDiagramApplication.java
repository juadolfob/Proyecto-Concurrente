package com.concurrente.threadDiagram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class ThreadDiagramApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThreadDiagramApplication.class, args);
	}

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/data").allowedOrigins("http://localhost:3000");
                registry.addMapping("/selection").allowedOrigins("http://localhost:3000");
            }
        };
    }
}

