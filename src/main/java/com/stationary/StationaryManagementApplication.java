package com.stationary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class StationaryManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StationaryManagementApplication.class, args);
	}

}
