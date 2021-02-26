package ua.maxbondar.tour_agency;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class TourAgencyApplication {

	public static void main(String[] args) {
		SpringApplication.run(TourAgencyApplication.class, args);
		log.info("Application started");
	}

}
