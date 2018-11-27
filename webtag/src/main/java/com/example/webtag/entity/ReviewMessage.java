package com.example.webtag.entity;

import com.example.webtag.domain.JsonReview;
import entity.Review;

/**
 * create by Lee
 */

public class ReviewMessage {
    JsonReview jsonReview;
    Review review;

    public ReviewMessage(JsonReview jsonReview, Review review) {
        this.jsonReview = jsonReview;
        this.review = review;
    }

    public JsonReview getJsonReview() {
        return jsonReview;
    }

    public void setJsonReview(JsonReview jsonReview) {
        this.jsonReview = jsonReview;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }
}
