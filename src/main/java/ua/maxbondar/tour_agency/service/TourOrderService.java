package ua.maxbondar.tour_agency.service;

import lombok.extern.slf4j.Slf4j;
import ua.maxbondar.tour_agency.entity.Status;
import ua.maxbondar.tour_agency.entity.TourOrder;
import ua.maxbondar.tour_agency.repositories.TourOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TourOrderService {
    @Autowired
    private TourOrderRepository tourOrderRepository;

    public void addOrder(TourOrder newOrder) {
        tourOrderRepository.save(newOrder);
    }


    public List<TourOrder> findByStatus(Status registered){
        List<TourOrder> result = tourOrderRepository.findByStatus(registered);
        if(result.size() == 0){
            log.info("No one registered tours was found!");
        }
        return result;
    }

    public void save(TourOrder tourOrder) {
        tourOrderRepository.save(tourOrder);
    }

    public List<TourOrder> findByCustomerId(Integer id) {
        return tourOrderRepository.findByCustomerId(id);
    }
}
