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

public class User {

    @SerializedName("id")
    public Integer id;

    @SerializedName("username")
    public String username;

    @SerializedName("group")
    public String group;

    @SerializedName("url")
    public String url;

    @SerializedName("about_text")
    public String about;

    @SerializedName("small_avatar_image")
    public String smallImageUrl;

    @SerializedName("medium_avatar_image")
    public String mediumImageUrl;

    @SerializedName("date_joined")
    public Date joined;

    @SerializedName("date_joined_unix")
    public Long joinedUnix;

    @SerializedName("date_last_seen")
    public Date lastSeen;

    @SerializedName("date_last_seen_unix")
    public Long lastSeenUnix;
}