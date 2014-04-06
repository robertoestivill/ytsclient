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

public class MovieRequest {

    @SerializedName("RequestID")
    public Long id;

    @SerializedName("MovieTitle")
    public String movieTitle;

    @SerializedName("MovieTitleClean")
    public String movieTitleClean;

    @SerializedName("MovieYear")
    public Integer movieYear;

    @SerializedName("ImdbCode")
    public String imdbCode;

    @SerializedName("ImdbLink")
    public String imdbLink;

    @SerializedName("CoverImage")
    public String coverImage;

    @SerializedName("ShortDescription")
    public String shortDescription;

    @SerializedName("Genre")
    public String genre;

    @SerializedName("MovieRating")
    public Float movieRating;

    @SerializedName("DateAdded")
    public Date added;

    @SerializedName("DateAddedEpoch")
    public Long addedEpoch;

    @SerializedName("Votes")
    public Integer votes;

    @SerializedName("UserID")
    public Long userId;

    @SerializedName("Username")
    public String username;
}
