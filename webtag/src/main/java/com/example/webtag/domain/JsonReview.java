package com.example.webtag.domain;

public class JsonReview {
    private Long reviewid;

    private String shopid;

    private String username;

    private String reviewmessage;

    private String text;

    public Long getReviewid() {
        return reviewid;
    }

    public void setReviewid(Long reviewid) {
        this.reviewid = reviewid;
    }

    public String getShopid() {
        return shopid;
    }

    public void setShopid(String shopid) {
        this.shopid = shopid == null ? null : shopid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getReviewmessage() {
        return reviewmessage;
    }

    public void setReviewmessage(String reviewmessage) {
        this.reviewmessage = reviewmessage == null ? null : reviewmessage.trim();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }
}