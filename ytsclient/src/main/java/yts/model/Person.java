package yts.model;

import com.google.gson.annotations.SerializedName;

public class Person {

    @SerializedName("name")
    public String name;

    @SerializedName("small_image")
    public String smallImageUrl;

    @SerializedName("medium_image")
    public String mediumImageUrl;
}