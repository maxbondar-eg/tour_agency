package ua.maxbondar.tour_agency.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.maxbondar.tour_agency.entity.Tour;
import ua.maxbondar.tour_agency.repositories.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class TourService {
    @Autowired
    private TourRepository tourRepository;

    public Page<Tour> findAll(Pageable pageable) {
        return (Page<Tour>) tourRepository.findAll(pageable);
    }

    public Tour findByName(String name) {
       return tourRepository.findByName(name);
    }

    public void saveTour(Tour tour) {
        Tour result = tourRepository.save(tour);
        if(result.getName() == null){
            log.error(" Error, Tour not added! {}", tour.getName());
            throw new RuntimeException("Tour not added");
        }
    }

    public void deleteTour(Tour tour) {
        tourRepository.deleteById(tour.getId());
    }
}
