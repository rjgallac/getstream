package com.example.demo.model;

public class Message {

    private String message;


    private String userId;
    private String feedSlug;


    public Message() {
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFeedSlug() {
        return feedSlug;
    }

    public void setFeedSlug(String feedSlug) {
        this.feedSlug = feedSlug;
    }

}
