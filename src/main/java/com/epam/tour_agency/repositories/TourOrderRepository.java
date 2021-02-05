package com.epam.tour_agency.repositories;

import com.epam.tour_agency.entity.TourOrder;
import org.springframework.data.repository.CrudRepository;

public interface TourOrderRepository extends CrudRepository<TourOrder, Integer> {
}
