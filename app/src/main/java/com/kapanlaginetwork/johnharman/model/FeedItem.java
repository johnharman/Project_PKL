package com.kapanlaginetwork.johnharman.model;

import java.io.Serializable;

public class FeedItem implements Serializable {
    private String title;
    private String date;
    private String attachmentUrl;
    private String id;
    private String content;
    private String url;

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getAttachmentUrl() {
        return attachmentUrl;
    }

    public String getContent() {
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAttachmentUrl(String attachmentUrl) {
        this.attachmentUrl = attachmentUrl;
    }

    public String getUrl() {
        return url;
    }
}