package yts.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ParentalGuidePage {

    @SerializedName("parental_guide_count")
    public Integer count;

    @SerializedName("parental_guides")
    public List<ParentalGuide> guides;
}