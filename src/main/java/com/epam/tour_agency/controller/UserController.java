package com.epam.tour_agency.controller;


import com.epam.tour_agency.entity.Role;
import com.epam.tour_agency.entity.User;
import com.epam.tour_agency.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/usercontrol")
//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public String userList(Model model){
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model){
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String,String> form,
            @RequestParam("userId") User user){
        userService.saveUser(user,username,form);
        return "redirect:/usercontrol";
    }
}
