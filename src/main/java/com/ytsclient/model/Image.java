package com.ytsclient.model;

import com.google.gson.annotations.SerializedName;

public class Image {

    @SerializedName("background_image")
    public String background;

    @SerializedName("small_cover_image")
    public String smallCover;

    @SerializedName("medium_cover_image")
    public String mediumCover;

    @SerializedName("large_cover_image")
    public String largeCover;

    @SerializedName("medium_screenshot_image1")
    public String mediumScreenshot1;

    @SerializedName("medium_screenshot_image2")
    public String mediumScreenshot2;

    @SerializedName("medium_screenshot_image3")
    public String mediumScreenshot3;

    @SerializedName("large_screenshot_image1")
    public String largeScreenshot1;

    @SerializedName("large_screenshot_image2")
    public String largeScreenshot2;

    @SerializedName("large_screenshot_image3")
    public String largeScreenshot3;
}