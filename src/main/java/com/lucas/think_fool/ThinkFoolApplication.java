package com.lucas.think_fool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
 
@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan
@PropertySource("file:${user.dir}/.env")
public class ThinkFoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThinkFoolApplication.class, args);
	}

}
