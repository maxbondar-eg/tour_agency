package com.epam.tour_agency.controller;

import com.epam.tour_agency.entity.Tour;
import com.epam.tour_agency.entity.TourType;
import com.epam.tour_agency.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/tourcontrol")
public class TourController {
    @Autowired
    private TourService tourService;

    @GetMapping
    public String tourPanel(Model model){
        model.addAttribute("tours",tourService.findAll());
        return "tours";
    }

    @GetMapping("/add")
    public String addTourForm(Model model){
        return "addTour";
    }

    @PostMapping("/add")
    public String addTour(@Valid Tour tour, Model model){
        Tour tourFromDB =tourService.findByName(tour.getName());
        if(tourFromDB!=null){
            model.addAttribute("message", "Error");
            return "addTour";
        }
        tourService.saveTour(tour);
        return "redirect:/tourcontrol";
    }

    @GetMapping("delete")
    public String deleteTour(@RequestParam("tourId") Tour tour, Model model){
        tourService.deleteTour(tour);
        return "redirect:/tourcontrol";
    }


    @GetMapping("{tour}")
    public String tourEdit(@PathVariable Tour tour, Model model){
        model.addAttribute("tour", tour);
        return "editTour";
    }

    @PostMapping("{tour}")
    public String tourEditSave(
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam Integer price,
            @RequestParam TourType tourType,
            @RequestParam Integer peopleAmount,
            @RequestParam Integer stars,
            @RequestParam boolean isHot,
            @RequestParam String img,
            @PathVariable Tour tour, Model model){
        tour.setName(name);
        tour.setDescription(description);
        tour.setPrice(price);
        tour.setTourType(tourType);
        tour.setPeopleAmount(peopleAmount);
        tour.setStars(stars);
        tour.setHot(isHot);
        tour.setImg(img);
        tourService.saveTour(tour);
        return "redirect:/tourcontrol";
    }
}
