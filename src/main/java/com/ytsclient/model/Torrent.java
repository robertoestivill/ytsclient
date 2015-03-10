package com.ytsclient.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Torrent {

    @SerializedName("url")
    public String url;

    @SerializedName("hash")
    public String hash;

    @SerializedName("quality")
    public String quality;

    @SerializedName("seeds")
    public Integer seeds;

    @SerializedName("peers")
    public Integer peers;

    @SerializedName("size")
    public String size;

    @SerializedName("size_bytes")
    public Long sizeInBytes;

    @SerializedName("date_uploaded")
    public Date dateUploaded;

    @SerializedName("date_uploaded_unix")
    public Long dateUploadedUnix;
}