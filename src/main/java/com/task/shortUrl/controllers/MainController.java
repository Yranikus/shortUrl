package com.task.shortUrl.controllers;


import com.google.common.hash.Hashing;
import com.task.shortUrl.DAO.UrlDAO;
import com.task.shortUrl.models.UrlModel;
import com.task.shortUrl.service.UrlService;
import org.apache.commons.validator.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.nio.charset.StandardCharsets;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private UrlDAO urlDAO;

    @Autowired
    private UrlService urlService;



    @RequestMapping("/")
    public String generate(@RequestParam(value = "url", required = false) String url,
                           @RequestParam(value = "time", required = false) String time,
                            Model model){
        UrlValidator urlValidator = new UrlValidator();
        if (url != null) {
            if (!urlValidator.isValid(url)) {
                model.addAttribute("shorturl", "Введена не действительная ссылка");
                return "firstpage";
            }
            model.addAttribute("shorturl", "http://localhost:8081/1/" + urlService.saveAndGenerate(url));
            return "firstpage";
        }
        return "firstpage";

    }






}
