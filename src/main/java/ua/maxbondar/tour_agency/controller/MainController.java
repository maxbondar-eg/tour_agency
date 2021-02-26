package ua.maxbondar.tour_agency.controller;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import ua.maxbondar.tour_agency.entity.Status;
import ua.maxbondar.tour_agency.entity.Tour;
import ua.maxbondar.tour_agency.entity.TourOrder;
import ua.maxbondar.tour_agency.entity.User;
import ua.maxbondar.tour_agency.service.TourOrderService;
import ua.maxbondar.tour_agency.service.TourService;
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
    public String greeting(Model model, @PageableDefault(size = 3, sort = {"isHot"}, direction = Sort.Direction.DESC)Pageable pageable) {
        Page<Tour> tours = tourService.findAll(pageable);
        model.addAttribute("page", tours);
        if(pageable.getSort().getOrderFor("price") != null){
            model.addAttribute("priceDir", pageable.getSort().getOrderFor("price").getDirection());
        }
        model.addAttribute("pagesNumber", tours.getTotalPages());
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