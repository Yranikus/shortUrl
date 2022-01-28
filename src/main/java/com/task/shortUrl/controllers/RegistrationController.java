package com.task.shortUrl.controllers;


import com.task.shortUrl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class RegistrationController {

    @Autowired
    private UserService userService;


    @RequestMapping("/registration")
    public String registration(@RequestParam(name = "login") String login,
                               @RequestParam(name = "password") String password,
                               Model model){
        if(userService.registerUser(login,password)){
            System.out.println(login + password);
            return "redirect:/";
        }
        model.addAttribute("error2", "такой пользователь уже имеется в системе");
        return "firstpage";
    }

}
