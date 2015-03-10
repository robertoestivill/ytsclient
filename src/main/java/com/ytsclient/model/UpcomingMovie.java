package com.ytsclient.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class UpcomingMovie {

    @SerializedName("imdb_code")
    public String imdbCode;

    @SerializedName("title")
    public String title;

    @SerializedName("year")
    public Integer year;

    @SerializedName("medium_cover_image")
    public String mediumCoverUrl;

    @SerializedName("date_added")
    public Date dateAdded;

    @SerializedName("date_added_unix")
    public Long dateAddedUnix;
}