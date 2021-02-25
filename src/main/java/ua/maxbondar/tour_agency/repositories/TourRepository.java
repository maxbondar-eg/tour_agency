package ua.maxbondar.tour_agency.repositories;

import ua.maxbondar.tour_agency.entity.Tour;
import org.springframework.data.repository.CrudRepository;

public interface TourRepository extends CrudRepository<Tour, Integer> {
    Tour findByName(String name);
}
