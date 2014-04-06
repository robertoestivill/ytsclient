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

public class MovieComment {

    @SerializedName("CommentID")
    public Long id;

    @SerializedName("CommentText")
    public String text;

    @SerializedName("ParentCommentID")
    public Long parentId;

    @SerializedName("DateAdded")
    public Date date;

    @SerializedName("DateAddedEpoch")
    public Long dateEpoch;

    @SerializedName("UserID")
    public Long userId;

    @SerializedName("UserName")
    public String userName;

    @SerializedName("UserAvatar")
    public String userAvatar;

    @SerializedName("UserGroup")
    public String userGroup;
}
