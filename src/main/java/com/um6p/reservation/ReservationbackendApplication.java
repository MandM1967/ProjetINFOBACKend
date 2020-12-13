package com.um6p.reservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableAutoConfiguration
@EnableWebSecurity
public class ReservationbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservationbackendApplication.class, args);
	}

}
