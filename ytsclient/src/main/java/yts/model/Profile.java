package yts.model;

import com.google.gson.annotations.SerializedName;

public class Profile extends User {

    @SerializedName("ip_address")
    public String ipAddress;

    @SerializedName("user_key")
    public String userKey;

    @SerializedName("profile_hidden")
    public Boolean isHidden;
}