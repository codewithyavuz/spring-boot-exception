package com.ozmenyavuz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.ozmenyavuz"})
@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.ozmenyavuz"})
public class ExceptionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExceptionApplication.class, args);
	}

}
