package com.task.shortUrl.models;

import java.util.Date;

public class StatisticsEntity {

    private int id;
    private String username;
    private Date date;
    private int linkId;

    public StatisticsEntity( String username, Date date, int linkId) {
        this.username = username;
        this.date = date;
        this.linkId = linkId;
    }

    public StatisticsEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
