package com.ytsclient.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BookmarkPage {

    @SerializedName("bookmark_count")
    public Integer count;

    @SerializedName("movies")
    public List<MovieSummary> bookmarks;
}