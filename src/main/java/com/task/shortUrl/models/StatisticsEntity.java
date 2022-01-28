package com.task.shortUrl.models;

import java.util.Date;

public class StatisticsEntity {

    private int id;
    private String browser;
    private Date date;
    private int linkId;


    public StatisticsEntity(String browser, Date date, int linkId) {
        this.browser = browser;
        this.date = date;
        this.linkId = linkId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getLinkId() {
        return linkId;
    }

    public void setLinkId(int linkId) {
        this.linkId = linkId;
    }
}
