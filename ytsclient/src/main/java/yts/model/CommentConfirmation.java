package yts.model;

import com.google.gson.annotations.SerializedName;

public class CommentConfirmation {

    @SerializedName("comment_id")
    public Integer commentId;

    @SerializedName("user_id")
    public Integer userId;

    @SerializedName("movie_id")
    public Integer movieId;

    @SerializedName("comment_text")
    public String commentText;
}