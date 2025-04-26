package com.example.demo.model;

import org.springframework.web.bind.annotation.PathVariable;

public class Follow {
    private String feedSlug;
    private String userId;
    private String followerId;

    public Follow() {
    }

    public String getFeedSlug() {
        return feedSlug;
    }
    public void setFeedSlug(String feedSlug) {
        this.feedSlug = feedSlug;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getFollowerId() {
        return followerId;
    }
    public void setFollowerId(String followerId) {
        this.followerId = followerId;
    }
}
