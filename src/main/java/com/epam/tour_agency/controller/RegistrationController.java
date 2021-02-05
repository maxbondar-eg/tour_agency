package com.epam.tour_agency.controller;

import com.epam.tour_agency.entity.User;
import com.epam.tour_agency.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;
    @GetMapping("/registry")
    public String registration(){
        return "registry";
    }

    @PostMapping("/registry")
    public String addUser(User user, Model model){
        //TODO validation
        if(!userService.addUser(user)){
            model.addAttribute("message", "User Exists!");
            return "registration";
        }
        return "redirect:/login";
    }
}
