package com.ytsclient.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class User {

    @SerializedName("id")
    public Long id;

    @SerializedName("username")
    public String username;

    @SerializedName("group")
    public String group;

    @SerializedName("url")
    public String url;

    @SerializedName("about_text")
    public String about;

    @SerializedName("small_avatar_image")
    public String smallImageUrl;

    @SerializedName("medium_avatar_image")
    public String mediumImageUrl;

    @SerializedName("date_joined")
    public Date joined;

    @SerializedName("date_joined_unix")
    public Long joinedUnix;

    @SerializedName("date_last_seen")
    public Date lastSeen;

    @SerializedName("date_last_seen_unix")
    public Long lastSeenUnix;
}