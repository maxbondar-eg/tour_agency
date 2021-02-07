package com.epam.tour_agency.service;

import com.epam.tour_agency.entity.Status;
import com.epam.tour_agency.entity.TourOrder;
import com.epam.tour_agency.repositories.TourOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourOrderService {
    @Autowired
    private TourOrderRepository tourOrderRepository;

    public void addOrder(TourOrder newOrder) {
        tourOrderRepository.save(newOrder);
    }


    public List<TourOrder> findByStatus(Status registered){
        return tourOrderRepository.findByStatus(registered);
    }

    public void save(TourOrder tourOrder) {
        tourOrderRepository.save(tourOrder);
    }

    public List<TourOrder> findByCustomerId(Integer id) {
        return tourOrderRepository.findByCustomerId(id);
    }
}
