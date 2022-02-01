package com.task.shortUrl.UrlTimer;

import com.task.shortUrl.DAO.StatisticDAO;
import com.task.shortUrl.DAO.UrlDAO;
import com.task.shortUrl.models.UrlModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.TimerTask;

public class UrlTimer extends TimerTask {

    private UrlDAO urlDAO;
    private String shortur;
    private StatisticDAO statisticDAO;


    public UrlTimer(UrlDAO urlDAO, String shorturl, StatisticDAO statisticDAO) {
        this.urlDAO = urlDAO;
        this.shortur = shorturl;
        this.statisticDAO = statisticDAO;
    }

    @Override
    public void run() {
        UrlModel urlModel = urlDAO.findByShortUrl(shortur);
        urlDAO.deleteUrl(urlModel.getId());
        statisticDAO.deleteStatisticUrl(urlModel.getId());
    }
}
