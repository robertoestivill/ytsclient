package com.ytsclient.response;

import com.google.gson.annotations.SerializedName;

public class YtsMetadata {

    @SerializedName("server_time")
    public Long serverTime;

    @SerializedName("server_timezone")
    public String serverTimeZone;

    @SerializedName("api_version")
    public Integer apiVersion;

    @SerializedName("execution_time")
    public String executionTime;
}
