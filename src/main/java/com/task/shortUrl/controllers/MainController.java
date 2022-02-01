package com.task.shortUrl.controllers;


import com.google.common.hash.Hashing;
import com.task.shortUrl.DAO.UrlDAO;
import com.task.shortUrl.models.UrlModel;
import com.task.shortUrl.service.UrlService;
import org.apache.commons.validator.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private UrlService urlService;



    @RequestMapping("/")
    public String generate(@RequestParam(value = "url", required = false) String url,
                           @RequestParam(value = "time", required = false) Long time,
                            Model model){
        UrlValidator urlValidator = new UrlValidator();
        if (url != null) {
            if (!urlValidator.isValid(url)) {
                model.addAttribute("shorturl", "Введена не действительная ссылка");
                return "firstpage";
            }
            model.addAttribute("shorturl",  urlService.saveAndGenerate(url, time));
            return "firstpage";
        }
        return "firstpage";

    }

    @RequestMapping("/allurl")
    public String listOfUrls(Model model, Authentication authentication){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        model.addAttribute("urlmodels", urlService.findAll());
        System.out.println(userDetails.getAuthorities().toString());
        if (userDetails.getAuthorities().toString().equals("[ROLE_USER]")) {
            return "listforusers";
        }
        return "listforadmin";
    }

    @RequestMapping("/del/{id}")
    public String del(@PathVariable int id){
        urlService.deleteUrl(id);
        return "redirect:/allurl";
    }

    @RequestMapping("/statistics/{id}")
    public String stat(@PathVariable int id, Model model){
        model.addAttribute("url", urlService.findById(id));
        model.addAttribute("statics", urlService.findStatisticById(id));
        return "stat";
    }



}
