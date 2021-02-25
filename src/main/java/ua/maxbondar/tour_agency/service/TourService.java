package ua.maxbondar.tour_agency.service;

import ua.maxbondar.tour_agency.entity.Tour;
import ua.maxbondar.tour_agency.repositories.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourService {
    @Autowired
    private TourRepository tourRepository;

    public List<Tour> findAll() {
        return (List<Tour>) tourRepository.findAll();
    }

    public Tour findByName(String name) {
       return tourRepository.findByName(name);
    }

    public void saveTour(Tour tour) {
        tourRepository.save(tour);
    }

    public void deleteTour(Tour tour) {
        tourRepository.deleteById(tour.getId());
    }
}
