package com.ytsclient.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rober on 3/2/15.
 */
public class MoviePage {

    @SerializedName("movie_count")
    public Integer count;

    @SerializedName("limit")
    public Integer limit;

    @SerializedName("page_number")
    public Integer pageNumber;

    @SerializedName("movies")
    public List<MovieSummary> data;
}