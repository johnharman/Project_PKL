package com.kapanlaginetwork.johnharman.Main;

import java.io.Serializable;

public class rFeedItem implements Serializable {
    private String idnews;
    private String title;
    private String synopsis;
    private String schedule;
    private String image_headline;
    private String url;
    private String AttachmentUrl;
    private String content;
    private String date;


    public void setIdnews(String idnews) {
        this.idnews = idnews;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public void setImage_headline(String imageheadline) {
        this.image_headline = imageheadline;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setAttachmentUrl(String AttachmentUrl) {
        this.AttachmentUrl = AttachmentUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getAttachmentUrl() {
        return AttachmentUrl;
    }

    public String getContent() {
        return content;
    }

    public String getUrl() {
        return url;
    }

    public String getDate() {
        return date;
    }
    @Override
        public String toString() {
            return "[ title=" + title + ", synopsis=" + synopsis + "]";
        }

    public String getSchedule() {
        return schedule;
    }
}