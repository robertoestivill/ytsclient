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