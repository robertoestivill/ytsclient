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

package yts.module;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;
import rx.Observable;
import yts.model.CommentConfirmation;
import yts.model.CommentPage;
import yts.response.YtsResponse;

public interface CommentModule {

    /**
     * Sync list comments.
     *
     * @param movieId
     * @return ytsResponse
     */
    @FormUrlEncoded
    @GET("/movie_comments.json")
    public YtsResponse<CommentPage> list(
            @Query("movie_id") Integer movieId);

    /**
     * Async list comments.
     *
     * @param movieId
     * @param callback
     */
    @FormUrlEncoded
    @GET("/movie_comments.json")
    public YtsResponse<CommentPage> list(
            @Query("movie_id") Integer movieId,
            Callback<YtsResponse<CommentPage>> callback);

    /**
     * Reactive list comments.
     *
     * @param movieId
     * @return observable
     */
    @FormUrlEncoded
    @GET("/movie_comments.json")
    public Observable<YtsResponse<CommentPage>> listRx(
            @Query("movie_id") Integer movieId);

    /**
     * Sync create comment.
     *
     * @param applicationKey
     * @param userKey
     * @param movieId
     * @param commentText
     * @return ytsResponse
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
     *
     * @param applicationKey
     * @param userKey
     * @param movieId
     * @param commentText
     * @param callback
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
     *
     * @param applicationKey
     * @param userKey
     * @param movieId
     * @param commentText
     * @return observable
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
     *
     * @param applicationKey
     * @param userKey
     * @param commentId
     * @return ytsResponse
     */
    @FormUrlEncoded
    @POST("/delete_comment.json")
    public YtsResponse delete(
            @Field("application_key") String applicationKey,
            @Field("user_key") String userKey,
            @Field("comment_id") Integer commentId);

    /**
     * Async delete comment.
     *
     * @param applicationKey
     * @param userKey
     * @param commentId
     * @param callback
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
     *
     * @param applicationKey
     * @param userKey
     * @param commentId
     * @return observable
     */
    @FormUrlEncoded
    @POST("/delete_comment.json")
    public Observable<YtsResponse> deleteRx(
            @Field("application_key") String applicationKey,
            @Field("user_key") String userKey,
            @Field("comment_id") Integer commentId);

    /**
     * Sync like comment.
     *
     * @param applicationKey
     * @param userKey
     * @param commentId
     * @return ytsResponse
     */
    @FormUrlEncoded
    @POST("/like_comment.json")
    public YtsResponse like(
            @Field("application_key") String applicationKey,
            @Field("user_key") String userKey,
            @Field("comment_id") Integer commentId);

    /**
     * Async like comment.
     *
     * @param applicationKey
     * @param userKey
     * @param commentId
     * @param callback
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
     *
     * @param applicationKey
     * @param userKey
     * @param commentId
     * @return observable
     */
    @FormUrlEncoded
    @POST("/like_comment.json")
    public Observable<YtsResponse> likeRx(
            @Field("application_key") String applicationKey,
            @Field("user_key") String userKey,
            @Field("comment_id") Integer commentId);

    /**
     * Sync report comment.
     *
     * @param applicationKey
     * @param userKey
     * @param commentId
     * @return ytsResponse
     */
    @FormUrlEncoded
    @POST("/report_comment.json")
    public YtsResponse report(
            @Field("application_key") String applicationKey,
            @Field("user_key") String userKey,
            @Field("comment_id") Integer commentId);

    /**
     * Async report comment.
     *
     * @param applicationKey
     * @param userKey
     * @param commentId
     * @param callback
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
     *
     * @param applicationKey
     * @param userKey
     * @param commentId
     * @return observable
     */
    @FormUrlEncoded
    @POST("/report_comment.json")
    public Observable<YtsResponse> reportRx(
            @Field("application_key") String applicationKey,
            @Field("user_key") String userKey,
            @Field("comment_id") Integer commentId);
}