package com.task.shortUrl.service;

import com.google.common.hash.Hashing;
import com.task.shortUrl.DAO.StatisticDAO;
import com.task.shortUrl.DAO.UrlDAO;
import com.task.shortUrl.UrlTimer.UrlTimer;
import com.task.shortUrl.models.StatisticsEntity;
import com.task.shortUrl.models.UrlModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;

@Service
public class UrlService {

    @Autowired
    private UrlDAO urlDAO;

    @Autowired
    private StatisticDAO statisticDAO;

    @Autowired
    private Timer timer;

    public String saveAndGenerate(String url, Long time){
        UrlModel urlModel = urlDAO.findByLongtUrl(url);
        String shorturl;
        if (urlModel == null) {
            shorturl = Hashing.murmur3_32().hashString(url, StandardCharsets.UTF_8).toString();
            urlModel = new UrlModel( url, shorturl);
            urlDAO.save(urlModel);
        }
        if (time != null){
            timer.schedule(new UrlTimer(urlDAO,urlModel.getShorUrl(), statisticDAO),time * 60000);
        }
        return urlModel.getShorUrl();
    }


    public UrlModel findById(int id){
        return urlDAO.findById(id);
    }

    public List<StatisticsEntity> findStatisticById(int id){
        return statisticDAO.findByUrlId(id);
    }



    public String updateStatistic(String shortUrl, Authentication authentication){
        UrlModel urlModel = urlDAO.findByShortUrl(shortUrl);
        if (urlModel != null) {
            urlModel.incrementCounter();
            urlDAO.updateCounter(urlModel);
            StatisticsEntity statisticsEntity = null;
            if (authentication != null) {
                statisticsEntity = new StatisticsEntity(authentication.getName(), new Date(), urlModel.getId());
            }
            else {
                statisticsEntity = new StatisticsEntity("ANONYMOUS", new Date(), urlModel.getId());
            }
            statisticDAO.save(statisticsEntity);
            return urlModel.getLonUrl();
        }
        return null;
    }

    public List<UrlModel> findAll(){
        return urlDAO.findAll();
    }


    public void deleteUrl(int id){
        statisticDAO.deleteStatisticUrl(id);
        urlDAO.deleteUrl(id);
    }


}
