package com.epam.tour_agency.controller;


import com.epam.tour_agency.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String greeting(Model model) {
        return "main";
    }

//    @GetMapping("/main")
//    public String main(Model model) {
//        model.addAttribute("some", "Wellcome to new Tourist Agency");
//        Iterable<Message> list = messageRepo.findAll();
//        model.addAttribute("messages", list);
//        return "main";
//    }
//
//    @PostMapping("add")
//    public String add(@AuthenticationPrincipal User user, @RequestParam String text, @RequestParam String tag, Model model){
//        Message message = new Message(text,tag, user);
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