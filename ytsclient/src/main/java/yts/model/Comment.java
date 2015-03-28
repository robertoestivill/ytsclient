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

public class Comment {

    @SerializedName("comment_id")
    public Long commentId;

    @SerializedName("user_id")
    public Integer userId;

    @SerializedName("username")
    public String username;

    @SerializedName("user_profile_url")
    public String userProfileUrl;

    @SerializedName("small_user_avatar_image")
    public String smallUserAvatarUrl;

    @SerializedName("medium_user_avatar_image")
    public String mediumUserAvatarUrl;

    @SerializedName("user_group")
    public String userGroup;

    @SerializedName("like_count")
    public Integer likes;

    @SerializedName("comment_text")
    public String commentText;

    @SerializedName("date_added")
    public Date dateAdded;

    @SerializedName("date_added_unix")
    public Long dateAddedUnix;
}