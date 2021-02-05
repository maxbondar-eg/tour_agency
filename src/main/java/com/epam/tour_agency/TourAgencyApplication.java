package com.epam.tour_agency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class TourAgencyApplication {

	public static void main(String[] args) {
		SpringApplication.run(TourAgencyApplication.class, args);
	}

}
