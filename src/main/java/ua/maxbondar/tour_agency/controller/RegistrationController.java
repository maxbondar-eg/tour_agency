package ua.maxbondar.tour_agency.controller;

import ua.maxbondar.tour_agency.entity.User;
import ua.maxbondar.tour_agency.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;
    @GetMapping("/registry")
    public String registration(){
        return "registry";
    }

    @PostMapping("/registry")
    public String addUser(@Valid User user, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errors);
            return "registry";
        }
        if(!userService.addUser(user)){
            model.addAttribute("usernameError", "User Exists!");
            return "registry";
        }
        return "redirect:/login";
    }
}
