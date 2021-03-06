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
import yts.model.MovieDetail;
import yts.model.MoviePage;
import yts.model.ParentalGuidePage;
import yts.model.ReviewPage;
import yts.model.SuggestionPage;
import yts.model.UpcomingMoviePage;
import yts.response.YtsResponse;

public interface MovieModule {

    /**
     * Sync list movies.
     *
     * @param options [Integer] "limit"           The limit of results per page that has been set. [1-50]
     *                [Integer] "page"            Used to see the next page of movies.
     *                [String]  "quality"         Used to filter by a given quality. [720p, 1080p, 3D]
     *                [Integer] "minimum_rating"  Used to filter movie by a given minimum IMDb rating
     *                [String]  "query_term"      Used for movie search, matching on: Movie Title/IMDb Code, Actor Name/IMDb Code, Director Name/IMDb Code
     *                [String]  "genre"           Used to filter by a given genre (See http://www.imdb.com/genre/ for full list)
     *                [String]  "sort_by"         Sorts the results by choosen value. [itle, year, rating, peers, seeds, download_count, like_count, date_added]
     *                [String]  "order_by"        Orders the results by either Ascending or Descending order. [desc,asc]
     *                [Boolean] "with_rt_ratings" Returns the list with the Rotten Tomatoes rating included
     * @return ytsResponse
     */
    @GET("/list_movies.json")
    public YtsResponse<MoviePage> list(
            @QueryMap Map<String, Object> options);

    /**
     * Async list movies.
     *
     * @param options  [Integer] "limit"           The limit of results per page that has been set. [1-50]
     *                 [Integer] "page"            Used to see the next page of movies.
     *                 [String]  "quality"         Used to filter by a given quality. [720p, 1080p, 3D]
     *                 [Integer] "minimum_rating"  Used to filter movie by a given minimum IMDb rating
     *                 [String]  "query_term"      Used for movie search, matching on: Movie Title/IMDb Code, Actor Name/IMDb Code, Director Name/IMDb Code
     *                 [String]  "genre"           Used to filter by a given genre (See http://www.imdb.com/genre/ for full list)
     *                 [String]  "sort_by"         Sorts the results by choosen value. [itle, year, rating, peers, seeds, download_count, like_count, date_added]
     *                 [String]  "order_by"        Orders the results by either Ascending or Descending order. [desc,asc]
     *                 [Boolean] "with_rt_ratings" Returns the list with the Rotten Tomatoes rating included
     * @param callback
     */
    @GET("/list_movies.json")
    public void list(
            @QueryMap Map<String, Object> options,
            Callback<YtsResponse<MoviePage>> callback);

    /**
     * Reactive list movies.
     *
     * @param options [Integer] "limit"           The limit of results per page that has been set. [1-50]
     *                [Integer] "page"            Used to see the next page of movies.
     *                [String]  "quality"         Used to filter by a given quality. [720p, 1080p, 3D]
     *                [Integer] "minimum_rating"  Used to filter movie by a given minimum IMDb rating
     *                [String]  "query_term"      Used for movie search, matching on: Movie Title/IMDb Code, Actor Name/IMDb Code, Director Name/IMDb Code
     *                [String]  "genre"           Used to filter by a given genre (See http://www.imdb.com/genre/ for full list)
     *                [String]  "sort_by"         Sorts the results by choosen value. [itle, year, rating, peers, seeds, download_count, like_count, date_added]
     *                [String]  "order_by"        Orders the results by either Ascending or Descending order. [desc,asc]
     *                [Boolean] "with_rt_ratings" Returns the list with the Rotten Tomatoes rating included
     * @return observable
     */
    @GET("/list_movies.json")
    public Observable<YtsResponse<MoviePage>> listRx(
            @QueryMap Map<String, Object> options);

    /**
     * Sync movie details.
     *
     * @param movieId
     * @param options [Boolean] "with_images" When set the data returned will include the added image URLs
     *                [Boolean] "with_cast"   When set the data returned will include the added information about the cast
     * @return ytsResponse
     */
    @GET("/movie_details.json")
    public YtsResponse<MovieDetail> details(
            @Query("movie_id") Integer movieId,
            @QueryMap Map<String, Object> options);

    /**
     * Aync movie details.
     *
     * @param movieId
     * @param options  [Boolean] "with_images" When set the data returned will include the added image URLs
     *                 [Boolean] "with_cast"   When set the data returned will include the added information about the cast
     * @param callback
     */
    @GET("/movie_details.json")
    public YtsResponse<MovieDetail> details(
            @Query("movie_id") Integer movieId,
            @QueryMap Map<String, Object> options,
            Callback<YtsResponse<MovieDetail>> callback);

    /**
     * Reactive movie details.
     *
     * @param movieId
     * @param options [Boolean] "with_images" When set the data returned will include the added image URLs
     *                [Boolean] "with_cast"   When set the data returned will include the added information about the cast
     * @return observable
     */
    @GET("/movie_details.json")
    public Observable<YtsResponse<MovieDetail>> detailsRx(
            @Query("movie_id") Integer movieId,
            @QueryMap Map<String, Object> options);

    /**
     * Sync get suggestions.
     *
     * @param movieId
     * @return ytsResponse
     */
    @GET("/movie_suggestions.json")
    public YtsResponse<SuggestionPage> suggestions(
            @Query("movie_id") Integer movieId);

    /**
     * Aync get suggestions.
     *
     * @param movieId
     * @param callback
     */
    @GET("/movie_suggestions.json")
    public YtsResponse<SuggestionPage> suggestions(
            @Query("movie_id") Integer movieId,
            Callback<YtsResponse<SuggestionPage>> callback);

    /**
     * Reactive get suggestions.
     *
     * @param movieId
     * @return observable
     */
    @GET("/movie_suggestions.json")
    public Observable<YtsResponse<SuggestionPage>> suggestionsRx(
            @Query("movie_id") Integer movieId);

    /**
     * Sync get reviews.
     *
     * @param movieId
     * @return ytsResponse
     */
    @GET("/movie_reviews.json")
    public YtsResponse<ReviewPage> reviews(
            @Query("movie_id") Integer movieId);

    /**
     * Async get reviews.
     *
     * @param movieId
     * @param callback
     */
    @GET("/movie_reviews.json")
    public YtsResponse<ReviewPage> reviews(
            @Query("movie_id") Integer movieId,
            Callback<YtsResponse<ReviewPage>> callback);

    /**
     * Reactive get reviews.
     *
     * @param movieId
     * @return observable
     */
    @GET("/movie_reviews.json")
    public Observable<YtsResponse<ReviewPage>> reviewsRx(
            @Query("movie_id") Integer movieId);

    /**
     * Sync get parental guides.
     *
     * @param movieId
     * @return ytsResponse
     */
    @GET("/movie_parental_guides.json")
    public YtsResponse<ParentalGuidePage> parentalGuides(
            @Query("movie_id") Integer movieId);

    /**
     * Async get parental guides.
     *
     * @param movieId
     * @param callback
     */
    @GET("/movie_parental_guides.json")
    public YtsResponse<ParentalGuidePage> parentalGuides(
            @Query("movie_id") Integer movieId,
            Callback<YtsResponse<ParentalGuidePage>> callback);

    /**
     * Reactive get parental guides.
     *
     * @param movieId
     * @return observable
     */
    @GET("/movie_parental_guides.json")
    public Observable<YtsResponse<ParentalGuidePage>> parentalGuidesRx(
            @Query("movie_id") Integer movieId);

    /**
     * Sync get upcoming movies.
     *
     * @return ytsResponse
     */
    @GET("/list_upcoming.json")
    public YtsResponse<UpcomingMoviePage> upcoming();

    /**
     * Async get upcoming movies.
     *
     * @param callback
     */
    @GET("/list_upcoming.json")
    public YtsResponse<UpcomingMoviePage> upcoming(
            Callback<YtsResponse<UpcomingMoviePage>> callback);

    /**
     * Reactive get upcoming movies.
     *
     * @return observable
     */
    @GET("/list_upcoming.json")
    public Observable<YtsResponse<UpcomingMoviePage>> upcomingRx();

    /**
     * Sync like movie.
     *
     * @param applicationKey
     * @param userKey
     * @param movieId
     * @return ytsResponse
     */
    @FormUrlEncoded
    @POST("/like_movie.json")
    public YtsResponse like(
            @Field("application_key") String applicationKey,
            @Field("user_key") String userKey,
            @Field("movie_id") Integer movieId);

    /**
     * Async like movie.
     *
     * @param applicationKey
     * @param userKey
     * @param movieId
     * @param callback
     */
    @FormUrlEncoded
    @POST("/like_movie.json")
    public YtsResponse like(
            @Field("application_key") String applicationKey,
            @Field("user_key") String userKey,
            @Field("movie_id") Integer movieId,
            Callback<YtsResponse> callback);

    /**
     * Reactive like movie.
     *
     * @param applicationKey
     * @param userKey
     * @param movieId
     * @return observable
     */
    @FormUrlEncoded
    @POST("/like_movie.json")
    public Observable<YtsResponse> likeRx(
            @Field("application_key") String applicationKey,
            @Field("user_key") String userKey,
            @Field("movie_id") Integer movieId);
}