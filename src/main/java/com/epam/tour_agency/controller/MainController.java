package com.epam.tour_agency.controller;


import com.epam.tour_agency.entity.Status;
import com.epam.tour_agency.entity.Tour;
import com.epam.tour_agency.entity.TourOrder;
import com.epam.tour_agency.entity.User;
import com.epam.tour_agency.repositories.UserRepository;
import com.epam.tour_agency.service.TourOrderService;
import com.epam.tour_agency.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {
    @Autowired
    private TourOrderService tourOrderService;
    @Autowired
    private TourService tourService;

    @GetMapping("/")
    public String greeting(Model model) {
        model.addAttribute("tours", tourService.findAll());
        return "main";
    }

    @GetMapping("/tour/{tour}")
    public String tourDetails(@PathVariable Tour tour, Model model){
        model.addAttribute("tour", tour);
        return "tourpage";
    }

    @PostMapping("/tour/buy")
    public String buyTour(@AuthenticationPrincipal User user,
                          @RequestParam("tourId") Tour tour,
                          @RequestParam("quantity") Integer quantity, Model model){
        TourOrder newOrder = TourOrder.builder().customer(user)
                .tour(tour).ticketsQuantity(quantity).status(Status.REGISTERED).build();
        tourOrderService.addOrder(newOrder);
        return "redirect:/cabinet";
    }
}