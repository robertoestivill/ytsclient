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

public class User {

    @SerializedName("UserID")
    public Long id;

    @SerializedName("UserName")
    public String name;

    @SerializedName("JoinDated")
    public Date joined;

    @SerializedName("JoinDatedEpoch")
    public Long joinedEpoch;

    @SerializedName("LastSeenDate")
    public Date lastSeen;

    @SerializedName("LastSeenDateEpoch")
    public Long lastSeenEpoch;

    @SerializedName("TorrentsDownloadedCount")
    public Integer torrentsDownloadedCount;

    @SerializedName("MoviesRequestedCount")
    public Integer moviesRequestedCount;

    @SerializedName("CommentCount")
    public Integer commentsCount;

    @SerializedName("ChatTimeSeconds")
    public Long chatTimeInSeconds;

    @SerializedName("Avatar")
    public String avatar;

    @SerializedName("UserRole")
    public String role;

    @SerializedName("About")
    public String about;
}
