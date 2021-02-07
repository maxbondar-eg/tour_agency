package com.epam.tour_agency.repositories;

import com.epam.tour_agency.entity.Status;
import com.epam.tour_agency.entity.TourOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TourOrderRepository extends CrudRepository<TourOrder, Integer> {
    List<TourOrder> findByStatus(Status registered);

    List<TourOrder> findByCustomerId(Integer id);
}
