package com.ytsclient.module;

import com.ytsclient.model.CommentConfirmation;
import com.ytsclient.model.CommentPage;
import com.ytsclient.response.YtsResponse;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;
import rx.Observable;

public interface CommentModule {

    /**
     * Sync list comments.
     * <br/>
     *
     * @param the movie id
     * @return a YtsResponse<CommentPage>
     */
    @FormUrlEncoded
    @GET("/movie_comments.json")
    public YtsResponse<CommentPage> list(
            @Query("movie_id") Integer movieId);

    /**
     * Async list comments.
     * <br/>
     *
     * @param the movie id
     * @param a   Callback<YtsResponse<CommentPage>>
     */
    @FormUrlEncoded
    @GET("/movie_comments.json")
    public YtsResponse<CommentPage> list(
            @Query("movie_id") Integer movieId,
            Callback<YtsResponse<CommentPage>> callback);

    /**
     * Reactive list comments.
     * <br/>
     *
     * @param the movie id
     * @return an Observable<<YtsResponse<CommentPage>>
     */
    @FormUrlEncoded
    @GET("/movie_comments.json")
    public Observable<YtsResponse<CommentPage>> listRx(
            @Query("movie_id") Integer movieId);

    /**
     * Sync create comment.
     * <br/>
     *
     * @param the application key
     * @param the user key
     * @param the movie id
     * @param the comment text
     * @return a YtsResponse<CommentConfirmation>
     */
    @FormUrlEncoded
    @POST("/make_comment.json")
    public YtsResponse<CommentConfirmation> create(
            @Field("application_key") String applicationKey,
            @Field("user_key") String userKey,
            @Field("movie_id") Integer movieId,
            @Field("comment_text") String commentText);

    /**
     * Async create comment.
     * <br/>
     *
     * @param the application key
     * @param the user key
     * @param the movie id
     * @param the comment text
     * @param a   Callback<YtsResponse<CommentConfirmation>>
     */
    @FormUrlEncoded
    @POST("/make_comment.json")
    public void create(
            @Field("application_key") String applicationKey,
            @Field("user_key") String userKey,
            @Field("movie_id") Integer movieId,
            @Field("comment_text") String commentText,
            Callback<YtsResponse<CommentConfirmation>> callback);

    /**
     * Reactive create comment.
     * <br/>
     *
     * @param the application key
     * @param the user key
     * @param the movie id
     * @param the comment text
     * @return a Observable<YtsResponse>
     */
    @FormUrlEncoded
    @POST("/make_comment.json")
    public Observable<YtsResponse<CommentConfirmation>> createRx(
            @Field("application_key") String applicationKey,
            @Field("user_key") String userKey,
            @Field("movie_id") Integer movieId,
            @Field("comment_text") String commentText);

    /**
     * Sync delete comment.
     * <br/>
     *
     * @param the application key
     * @param the user key
     * @param the comment id
     * @return a YtsResponse
     */
    @FormUrlEncoded
    @POST("/delete_comment.json")
    public YtsResponse delete(
            @Field("application_key") String applicationKey,
            @Field("user_key") String userKey,
            @Field("comment_id") Integer commentId);

    /**
     * Async delete comment.
     * <br/>
     *
     * @param the application key
     * @param the user key
     * @param the comment id
     * @param a   Callback<YtsResponse>
     */
    @FormUrlEncoded
    @POST("/delete_comment.json")
    public void delete(
            @Field("application_key") String applicationKey,
            @Field("user_key") String userKey,
            @Field("comment_id") Integer commentId,
            Callback<YtsResponse> callback);

    /**
     * Reactive delete comment.
     * <br/>
     *
     * @param the application key
     * @param the user key
     * @param the comment id
     * @return an Observable<YtsResponse>
     */
    @FormUrlEncoded
    @POST("/delete_comment.json")
    public Observable<YtsResponse> deleteRx(
            @Field("application_key") String applicationKey,
            @Field("user_key") String userKey,
            @Field("comment_id") Integer commentId);

    /**
     * Sync like comment.
     * <br/>
     *
     * @param the application key
     * @param the user key
     * @param the comment id
     * @return a YtsResponse
     */
    @FormUrlEncoded
    @POST("/like_comment.json")
    public YtsResponse like(
            @Field("application_key") String applicationKey,
            @Field("user_key") String userKey,
            @Field("comment_id") Integer commentId);

    /**
     * Async like comment.
     * <br/>
     *
     * @param the application key
     * @param the user key
     * @param the comment id
     * @param a   Callback<YtsResponse>
     */
    @FormUrlEncoded
    @POST("/like_comment.json")
    public void like(
            @Field("application_key") String applicationKey,
            @Field("user_key") String userKey,
            @Field("comment_id") Integer commentId,
            Callback<YtsResponse> callback);

    /**
     * Reactive like comment.
     * <br/>
     *
     * @param the application key
     * @param the user key
     * @param the comment id
     * @return an Observable<YtsResponse>
     */
    @FormUrlEncoded
    @POST("/like_comment.json")
    public Observable<YtsResponse> likeRx(
            @Field("application_key") String applicationKey,
            @Field("user_key") String userKey,
            @Field("comment_id") Integer commentId);

    /**
     * Sync report comment.
     * <br/>
     *
     * @param the application key
     * @param the user key
     * @param the comment id
     * @return a YtsResponse
     */
    @FormUrlEncoded
    @POST("/report_comment.json")
    public YtsResponse report(
            @Field("application_key") String applicationKey,
            @Field("user_key") String userKey,
            @Field("comment_id") Integer commentId);

    /**
     * Async report comment.
     * <br/>
     *
     * @param the application key
     * @param the user key
     * @param the comment id
     * @param a   Callback<YtsResponse>
     */
    @FormUrlEncoded
    @POST("/report_comment.json")
    public void report(
            @Field("application_key") String applicationKey,
            @Field("user_key") String userKey,
            @Field("comment_id") Integer commentId,
            Callback<YtsResponse> callback);

    /**
     * Reactive report comment.
     * <br/>
     *
     * @param the application key
     * @param the user key
     * @param the comment id
     * @return an Observable<YtsResponse>
     */
    @FormUrlEncoded
    @POST("/report_comment.json")
    public Observable<YtsResponse> reportRx(
            @Field("application_key") String applicationKey,
            @Field("user_key") String userKey,
            @Field("comment_id") Integer commentId);
}