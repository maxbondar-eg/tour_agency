package ua.maxbondar.tour_agency.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.maxbondar.tour_agency.entity.Tour;
import org.springframework.data.repository.CrudRepository;

public interface TourRepository extends CrudRepository<Tour, Integer> {

    Page<Tour> findAll(Pageable pageable);

    Tour findByName(String name);
}
