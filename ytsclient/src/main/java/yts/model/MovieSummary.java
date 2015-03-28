/*
 * Copyright (C) 2015 Roberto Estivill
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

package yts.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class MovieSummary {

    @SerializedName("id")
    public Integer id;

    @SerializedName("url")
    public String url;

    @SerializedName("imdb_code")
    public String imdbCode;

    @SerializedName("title")
    public String title;

    @SerializedName("title_long")
    public String longTitle;

    @SerializedName("year")
    public Integer year;

    @SerializedName("rating")
    public Float rating;

    @SerializedName("runtime")
    public Integer runtime;

    @SerializedName("genres")
    public List<String> genres;

    @SerializedName("language")
    public String language;

    @SerializedName("mpa_rating")
    public String mpaRating;

    @SerializedName("small_cover_image")
    public String smallCoverUrl;

    @SerializedName("medium_cover_image")
    public String mediumCoverUrl;

    @SerializedName("state")
    public String state;

    @SerializedName("torrents")
    public List<Torrent> torrents;

    @SerializedName("date_uploaded")
    public Date dateUploaded;

    @SerializedName("date_uploaded_unix")
    public Long dateUploadedUnix;
}