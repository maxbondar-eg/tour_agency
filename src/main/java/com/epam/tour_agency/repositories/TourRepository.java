package com.epam.tour_agency.repositories;

import com.epam.tour_agency.entity.Tour;
import org.springframework.data.repository.CrudRepository;

public interface TourRepository extends CrudRepository<Tour, Integer> {
}
