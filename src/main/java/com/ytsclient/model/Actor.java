package com.ytsclient.model;

import com.google.gson.annotations.SerializedName;

public class Actor extends Person {

    @SerializedName("character_name")
    public String characterName;
}