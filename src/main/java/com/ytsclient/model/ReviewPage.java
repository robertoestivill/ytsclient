package com.ytsclient.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ReviewPage {

    @SerializedName("review_count")
    public Integer count;

    @SerializedName("reviews")
    public List<Review> reviews;
}