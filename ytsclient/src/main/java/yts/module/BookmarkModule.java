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

import java.util.Map;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;
import retrofit.http.QueryMap;
import rx.Observable;
import yts.model.BookmarkPage;
import yts.response.YtsResponse;

public interface BookmarkModule {

    /**
     * Sync list bookmarks.
     * <br/>
     *
     * @param the user key
     * @param the optional parameters
     *            [Boolean] "with_rt_ratings" Returns the list with the Rotten Tomatoes rating included
     * @return a YtsResponse<BookmarkPage>
     */
    @GET("/get_movie_bookmarks.json")
    public YtsResponse<BookmarkPage> list(
            @Query("user_key") String userKey,
            @QueryMap Map<String, Object> options);

    /**
     * Async list bookmarks.
     * <br/>
     *
     * @param the user key
     * @param the optional parameters
     *            [Boolean] "with_rt_ratings" Returns the list with the Rotten Tomatoes rating included
     * @param a   Callback<YtsResponse<BookmarkPage>>
     */
    @GET("/get_movie_bookmarks.json")
    public void list(
            @Query("user_key") String userKey,
            @QueryMap Map<String, Object> options,
            Callback<YtsResponse<BookmarkPage>> callback);

    /**
     * Reactive list bookmarks.
     * <br/>
     *
     * @param the user key
     * @param the optional parameters
     *            [Boolean] "with_rt_ratings" Returns the list with the Rotten Tomatoes rating included
     * @return an Observable<YtsResponse<BookmarkPage>>
     */
    @GET("/get_movie_bookmarks.json")
    public Observable<YtsResponse<BookmarkPage>> listRx(
            @Query("user_key") String userKey,
            @QueryMap Map<String, Object> options);

    /**
     * Sync create bookmark.
     * <br/>
     *
     * @param the application key
     * @param the user key
     * @param the movie id
     * @return a YtsResponse
     */
    @FormUrlEncoded
    @POST("/add_movie_bookmark.json")
    public YtsResponse create(
            @Field("application_key") String applicationKey,
            @Field("user_key") String userKey,
            @Field("movie_id") Integer movieId);

    /**
     * Async create bookmark.
     * <br/>
     *
     * @param the application key
     * @param the user key
     * @param the movie id
     * @param a   Callback<YtsResponse>
     */
    @FormUrlEncoded
    @POST("/add_movie_bookmark.json")
    public void create(
            @Field("application_key") String applicationKey,
            @Field("user_key") String userKey,
            @Field("movie_id") Integer movieId,
            Callback<YtsResponse> callback);

    /**
     * Reactive create bookmark.
     * <br/>
     *
     * @param the application key
     * @param the user key
     * @param the movie id
     * @return an Observable<YtsResponse>
     */
    @FormUrlEncoded
    @POST("/add_movie_bookmark.json")
    public Observable<YtsResponse> createRx(
            @Field("application_key") String applicationKey,
            @Field("user_key") String userKey,
            @Field("movie_id") Integer movieId);

    /**
     * Sync delete bookmark.
     * <br/>
     *
     * @param the application key
     * @param the user key
     * @param the movie id
     * @return a YtsResponse
     */
    @FormUrlEncoded
    @POST("/delete_movie_bookmark.json")
    public YtsResponse delete(
            @Field("application_key") String applicationKey,
            @Field("user_key") String userKey,
            @Field("movie_id") Integer movieId);

    /**
     * Async delete bookmark.
     * <br/>
     *
     * @param the application key
     * @param the user key
     * @param the movie id
     * @param a   Callback<YtsResponse>
     */
    @FormUrlEncoded
    @POST("/delete_movie_bookmark.json")
    public void delete(
            @Field("application_key") String applicationKey,
            @Field("user_key") String userKey,
            @Field("movie_id") Integer movieId,
            Callback<YtsResponse> callback);

    /**
     * Reactive delete bookmark.
     * <br/>
     *
     * @param the application key
     * @param the user key
     * @param the movie id
     * @return an Observable<YtsResponse>
     */
    @FormUrlEncoded
    @POST("/delete_movie_bookmark.json")
    public Observable<YtsResponse> deleteRx(
            @Field("application_key") String applicationKey,
            @Field("user_key") String userKey,
            @Field("movie_id") Integer movieId);
}