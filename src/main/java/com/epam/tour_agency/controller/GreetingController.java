package com.epam.tour_agency.controller;


import com.epam.tour_agency.dto.UserDTO;
import com.epam.tour_agency.entity.User;
import com.epam.tour_agency.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String greeting( Model model) {
        model.addAttribute("some", "Wellcome To Tour Agency");
        return "start";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new UserDTO());
        return "login";
    }

    @PostMapping("/login")
    public String userEnter(UserDTO user, Model model) {
        user.setLogin("CocoJambo");
        model.addAttribute("user", user);
        return "login";
    }

    @GetMapping("/registry")
    public String registry(Model model) {
        model.addAttribute("user", new User());
        return "registry";
    }

    @PostMapping("/registry")
    public String registryUser(User user,Model model) {
        userRepository.save(user);
        return "redirect:/";
    }


//    @PostMapping("/main")
//    public String add(@RequestParam String text, @RequestParam String tag, Model model){
//        Message message = new Message(text,tag);
//        messageRepo.save(message);
//        Iterable<Message> list = messageRepo.findAll();
//        model.addAttribute("messages", list);
//        return "main";
//    }
//
//    @PostMapping("filter")
//    public String filter(@RequestParam String filter, Model model){
//        Iterable<Message> messages;
//        if(filter!=null && !filter.isEmpty()){
//            messages = messageRepo.findByTag(filter);
//        }else{
//            messages = messageRepo.findAll();
//        }
//        model.addAttribute("messages", messages);
//        return "main";
//    }

}