package yts.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CommentPage {

    @SerializedName("comment_count")
    public Integer count;

    @SerializedName("comments")
    public List<Comment> comments;
}