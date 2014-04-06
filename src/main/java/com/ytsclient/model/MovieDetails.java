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
import java.util.List;

public class MovieDetails {

    @SerializedName("MovieID")
    public Integer id;

    @SerializedName("MovieUrl")
    public String url;

    @SerializedName("DateUploaded")
    public Date dateUpload;

    @SerializedName("DateUploadedEpoch")
    public Long dateUploadEpoch;

    @SerializedName("Uploader")
    public String uploader;

    @SerializedName("UploaderUID")
    public Long uploaderUID;

    @SerializedName("Quality")
    public String quality;

    @SerializedName("Resolution")
    public String resolution;

    @SerializedName("FrameRate")
    public Float frameRate;

    @SerializedName("Language")
    public String language;

    @SerializedName("Subtitles")
    public String subtitles;

    @SerializedName("MediumCover")
    public String coverMedium;

    @SerializedName("LargeCover")
    public String coverLarge;

    @SerializedName("LargeScreenshot1")
    public String screenshot1Large;

    @SerializedName("LargeScreenshot2")
    public String screenshot2Large;

    @SerializedName("LargeScreenshot3")
    public String screenshot3Large;

    @SerializedName("MediumScreenshot1")
    public String screenshot1Medium;

    @SerializedName("MediumScreenshot2")
    public String screenshot2Medium;

    @SerializedName("MediumScreenshot3")
    public String screenshot3Medium;

    @SerializedName("ImdbCode")
    public String imdbCode;

    @SerializedName("ImdbLink")
    public String imdbLink;

    @SerializedName("MovieTitle")
    public String title;

    @SerializedName("MovieTitleClean")
    public String titleClean;

    @SerializedName("MovieYear")
    public Integer year;

    @SerializedName("MovieRating")
    public Float rating;

    @SerializedName("MovieRuntime")
    public Integer runtime;

    @SerializedName("YoutubeTrailerID")
    public String youtubeTrailerId;

    @SerializedName("YoutubeTrailerUrl")
    public String youtubeTrailerUrl;

    @SerializedName("AgeRating")
    public String ageRating;

    @SerializedName("Genre1")
    public String genre1;

    @SerializedName("Genre2")
    public String genre2;

    @SerializedName("ShortDescription")
    public String descriptionShort;

    @SerializedName("LongDescription")
    public String descriptionLong;

    @SerializedName("CastList")
    public List<MovieActor> cast;

    @SerializedName("DirectorList")
    public List<MovieDirector> directors;

    @SerializedName("Downloaded")
    public Long downloaded;

    @SerializedName("TorrentUrl")
    public String torrentUrl;

    @SerializedName("TorrentHash")
    public String torrentHash;

    @SerializedName("TorrentMagnetUrl")
    public String torrentMagnetUrl;

    @SerializedName("TorrentSeeds")
    public Integer torrentSeeds;

    @SerializedName("TorrentPeers")
    public Integer torrentPeers;

    @SerializedName("Size")
    public String size;

    @SerializedName("SizeByte")
    public Long sizeInBytes;
}
