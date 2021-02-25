package ua.maxbondar.tour_agency.controller;

import ua.maxbondar.tour_agency.entity.Status;
import ua.maxbondar.tour_agency.entity.TourOrder;
import ua.maxbondar.tour_agency.entity.User;
import ua.maxbondar.tour_agency.service.TourOrderService;
import ua.maxbondar.tour_agency.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@PreAuthorize("hasAuthority('ROLE_USER')")
public class TourOrdersController {
    @Autowired
    private UserService userService;
    @Autowired
    private TourOrderService tourOrderService;

    @GetMapping("/cabinet")
    public String userCabinet(@AuthenticationPrincipal User user, Model model){
        List<TourOrder> userTours = tourOrderService.findByCustomerId(user.getId());
        model.addAttribute("user", user);
        model.addAttribute("toursquantity", userTours.size());
        model.addAttribute("orderList", userTours);
        return "mycabinet";
    }

    @GetMapping("/orders")
    public String getRegisteredOrders(Model model){
        model.addAttribute("orderList", tourOrderService.findByStatus(Status.REGISTERED));
        return "orders";
    }

    @PostMapping("/orders/paid")
    public String orderPay(@RequestParam("orderId") TourOrder tourOrder, Model model){
        tourOrder.setStatus(Status.PAID);
        tourOrderService.save(tourOrder);
        return ("redirect:/orders");
    }

    @PostMapping("/orders/canceled")
    public String orderCancel(@RequestParam("orderId") TourOrder tourOrder, Model model){
        tourOrder.setStatus(Status.CANCELED);
        tourOrderService.save(tourOrder);
        return ("redirect:/orders");
    }

}
