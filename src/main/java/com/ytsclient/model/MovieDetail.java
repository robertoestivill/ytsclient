package com.ytsclient.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieDetail extends MovieSummary {

    @SerializedName("download_count")
    public Long downloadCount;

    @SerializedName("like_ount")
    public Integer likeCount;

    @SerializedName("rt_critics_score")
    public Integer criticsScore;

    @SerializedName("rt_critics_rating")
    public String criticsRating;

    @SerializedName("rt_audience_score")
    public Integer audienceScore;

    @SerializedName("rt_audience_rating")
    public String audienceRating;

    @SerializedName("description_intro")
    public String descriptionIntro;

    @SerializedName("description_full")
    public String description;

    @SerializedName("images")
    public Image images;

    @SerializedName("directors")
    public List<Person> directors;

    @SerializedName("actors")
    public List<Actor> actors;
}