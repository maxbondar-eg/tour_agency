package com.epam.tour_agency.controller;

import com.epam.tour_agency.entity.Role;
import com.epam.tour_agency.entity.User;
import com.epam.tour_agency.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;
    @GetMapping("/registry")
    public String registration(){
        return "registry";
    }

    @PostMapping("/registry")
    public String addUser(User user, Model model){
        //TODO validation
        User userFromDb = userRepository.findByUsername(user.getUsername());
        if(userFromDb!=null){
            model.addAttribute("message", "User Exists!");
            return "registration";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.ROLE_USER));
        userRepository.save(user);
        return "redirect:/login";
    }
}
