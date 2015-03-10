package com.ytsclient.model;

import com.google.gson.annotations.SerializedName;

public class UserKey {

    @SerializedName("username")
    public String username;

    @SerializedName("email")
    public String email;

    @SerializedName("user_key")
    public String userKey;
}