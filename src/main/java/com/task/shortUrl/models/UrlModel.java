package com.task.shortUrl.models;

public class UrlModel {

    private int id;
    private int counter;
    private String lonUrl;
    private String shorUrl;


    public UrlModel( String lonUrl, String shorUrl) {
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
