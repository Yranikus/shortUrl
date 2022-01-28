package com.task.shortUrl.models;

public class UrlModel {

    private int id;
    private Long time;
    private int counter;
    private String lonUrl;
    private String shorUrl;


    public UrlModel( Long time, String lonUrl, String shorUrl) {
        this.time = time;
        this.counter = 0;
        this.lonUrl = lonUrl;
        this.shorUrl = shorUrl;
    }


    public void incrementCounter(){
        counter++;
    }

    public UrlModel() {
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getLonUrl() {
        return lonUrl;
    }

    public void setLonUrl(String lonUrl) {
        this.lonUrl = lonUrl;
    }

    public String getShorUrl() {
        return shorUrl;
    }

    public void setShorUrl(String shorUrl) {
        this.shorUrl = shorUrl;
    }
}
