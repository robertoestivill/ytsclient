package yts.model;

import com.google.gson.annotations.SerializedName;

public class ParentalGuide {

    @SerializedName("type")
    public String type;

    @SerializedName("parental_guide_text")
    public String text;
}