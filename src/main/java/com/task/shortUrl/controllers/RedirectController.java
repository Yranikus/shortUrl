package com.task.shortUrl.controllers;


import com.task.shortUrl.DAO.UrlDAO;
import com.task.shortUrl.models.UrlModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;

@RestController
@RequestMapping("/1")
public class RedirectController {

    @Autowired
    private UrlDAO urlDAO;

    @Autowired
    private AnnotationConfigApplicationContext context;

    @GetMapping("/{shorturl}")
    public RedirectView redirect(@PathVariable(required = true) String shorturl,
                                 HttpEntity httpEntity) {
        System.out.println(httpEntity.getHeaders().get("User-Agent").get(0));
        UrlModel urlModel = urlDAO.findByShortUrl(shorturl);
        urlModel.incrementCounter();
        urlDAO.updateCounter(urlModel);
        context.getBean("fgdgf").l
        return new RedirectView(urlModel.getLonUrl());
    }

}
