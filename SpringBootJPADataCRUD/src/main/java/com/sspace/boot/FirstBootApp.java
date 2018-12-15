package com.sspace.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages={"com.sspace.service","com.sspace.controller"})
@ComponentScan(basePackages="com.sspace.repository")
@EnableWebMvc
@EnableJpaRepositories
@EntityScan(basePackages="com.sspace.beans")
public class FirstBootApp {
	public static void main(String[] args) {
		SpringApplication.run(FirstBootApp.class, args);
	}
}
