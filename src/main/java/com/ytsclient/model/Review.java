package com.ytsclient.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Review {

    @SerializedName("username")
    public String username;

    @SerializedName("user_rating")
    public Float userRating;

    @SerializedName("user_location")
    public String userLocation;

    @SerializedName("review_summary")
    public String summary;

    @SerializedName("review_text")
    public String text;

    @SerializedName("date_written")
    public Date dateWritten;

    @SerializedName("date_written_unix")
    public Long dateWrittenUnix;
}