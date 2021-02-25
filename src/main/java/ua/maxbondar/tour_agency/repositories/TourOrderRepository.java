package ua.maxbondar.tour_agency.repositories;

import ua.maxbondar.tour_agency.entity.Status;
import ua.maxbondar.tour_agency.entity.TourOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TourOrderRepository extends CrudRepository<TourOrder, Integer> {
    List<TourOrder> findByStatus(Status registered);

    List<TourOrder> findByCustomerId(Integer id);
}
