package com.vickiboykis.caffeine;

public class HTMLElement {
    private String url;
    private String title;
    private String date;

    public void setUrl(String url) {
        this.url = url;
    }

    public HTMLElement(String title, String url, String date) {
        this.title = title;
        this.url  = url;
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



}
