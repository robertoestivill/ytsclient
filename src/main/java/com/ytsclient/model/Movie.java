/*
 * Copyright (C) 2014 Roberto Estivill
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ytsclient.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Movie {

    @SerializedName("MovieID")
    public Integer id;

    @SerializedName("State")
    public MovieState state;

    @SerializedName("MovieUrl")
    public String url;

    @SerializedName("MovieTitle")
    public String title;

    @SerializedName("MovieTitleClean")
    public String titleClean;

    @SerializedName("MovieYear")
    public Integer year;

    @SerializedName("DateUploaded")
    public Date date;

    @SerializedName("DateUploadedEpoch")
    public Long dateEpoch;

    @SerializedName("Quality")
    public String quality;

    @SerializedName("CoverImage")
    public String coverUrl;

    @SerializedName("ImdbCode")
    public String imdbCode;

    @SerializedName("ImdbLink")
    public String imdbLink;

    @SerializedName("Size")
    public String size;

    @SerializedName("SizeByte")
    public Long sizeInBytes;

    @SerializedName("MovieRating")
    public Float rating;

    @SerializedName("Genre")
    public String genre;

    @SerializedName("Uploader")
    public String uploader;

    @SerializedName("UploaderUID")
    public Long uploaderUID;

    @SerializedName("Downloaded")
    public Long downloads;

    @SerializedName("TorrentSeeds")
    public Integer torrentSeeds;

    @SerializedName("TorrentPeers")
    public Integer torrentPeers;

    @SerializedName("TorrentUrl")
    public String torrentUrl;

    @SerializedName("TorrentHash")
    public String torrentHash;

    @SerializedName("TorrentMagnetUrl")
    public String torrentMagnetUrl;
}
