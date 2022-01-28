package com.task.shortUrl.service;

import com.google.common.hash.Hashing;
import com.task.shortUrl.DAO.UrlDAO;
import com.task.shortUrl.models.UrlModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class UrlService {

    @Autowired
    private UrlDAO urlDAO;


    public String saveAndGenerate(String url){
        UrlModel urlModel = urlDAO.findByLongtUrl(url);
        if (urlModel == null) {
            String shorturl = Hashing.murmur3_32().hashString(url, StandardCharsets.UTF_8).toString();
            urlModel = new UrlModel(null, url, shorturl);
            urlDAO.save(urlModel);
            return shorturl;
        }

        return urlModel.getShorUrl();
    }

//    public Visits fullStatisticsOfVisits(String idOfUrl){
//
//    }




}
