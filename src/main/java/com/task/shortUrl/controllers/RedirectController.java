package com.task.shortUrl.controllers;


import com.task.shortUrl.DAO.UrlDAO;
import com.task.shortUrl.models.UrlModel;
import com.task.shortUrl.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;

@RestController
@RequestMapping("/1")
public class RedirectController {

    @Autowired
    private UrlService urlService;


    @GetMapping("/{shorturl}")
    public RedirectView redirect(@PathVariable(required = true) String shorturl,
                                 Authentication authentication) {
        String longurl = urlService.updateStatistic(shorturl,authentication);
        return new RedirectView(longurl);
    }


}
