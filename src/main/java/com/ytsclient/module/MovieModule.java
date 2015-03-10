package com.ytsclient.module;

import com.ytsclient.model.MovieDetail;
import com.ytsclient.model.MoviePage;
import com.ytsclient.model.ParentalGuidePage;
import com.ytsclient.model.ReviewPage;
import com.ytsclient.model.SuggestionPage;
import com.ytsclient.model.UpcomingMoviePage;
import com.ytsclient.response.YtsResponse;

import java.util.Map;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;
import retrofit.http.QueryMap;
import rx.Observable;

public interface MovieModule {

    /**
     * Sync list movies.
     * <br/>
     *
     * @param the optional parameters
     *            [Integer] "limit"           The limit of results per page that has been set. [1-50]
     *            [Integer] "page"            Used to see the next page of movies.
     *            [String]  "quality"         Used to filter by a given quality. [720p, 1080p, 3D]
     *            [Integer] "minimum_rating"  Used to filter movie by a given minimum IMDb rating
     *            [String]  "query_term"      Used for movie search, matching on: Movie Title/IMDb Code, Actor Name/IMDb Code, Director Name/IMDb Code
     *            [String]  "genre"           Used to filter by a given genre (See http://www.imdb.com/genre/ for full list)
     *            [String]  "sort_by"         Sorts the results by choosen value. [itle, year, rating, peers, seeds, download_count, like_count, date_added]
     *            [String]  "order_by"        Orders the results by either Ascending or Descending order. [desc,asc]
     *            [Boolean] "with_rt_ratings" Returns the list with the Rotten Tomatoes rating included
     * @return a YtsResponse<MoviePage>
     */
    @GET("/list_movies.json")
    public YtsResponse<MoviePage> list(
            @QueryMap Map<String, Object> options);

    /**
     * Async list movies.
     * <br/>
     *
     * @param the optional parameters
     *            [Integer] "limit"           The limit of results per page that has been set. [1-50]
     *            [Integer] "page"            Used to see the next page of movies.
     *            [String]  "quality"         Used to filter by a given quality. [720p, 1080p, 3D]
     *            [Integer] "minimum_rating"  Used to filter movie by a given minimum IMDb rating
     *            [String]  "query_term"      Used for movie search, matching on: Movie Title/IMDb Code, Actor Name/IMDb Code, Director Name/IMDb Code
     *            [String]  "genre"           Used to filter by a given genre (See http://www.imdb.com/genre/ for full list)
     *            [String]  "sort_by"         Sorts the results by choosen value. [itle, year, rating, peers, seeds, download_count, like_count, date_added]
     *            [String]  "order_by"        Orders the results by either Ascending or Descending order. [desc,asc]
     *            [Boolean] "with_rt_ratings" Returns the list with the Rotten Tomatoes rating included
     * @param a   Callback<YtsResponse<MoviePage>>
     */
    @GET("/list_movies.json")
    public void list(
            @QueryMap Map<String, Object> options,
            Callback<YtsResponse<MoviePage>> callback);

    /**
     * Reactive list movies.
     * <br/>
     *
     * @param the optional parameters
     *            [Integer] "limit"           The limit of results per page that has been set. [1-50]
     *            [Integer] "page"            Used to see the next page of movies.
     *            [String]  "quality"         Used to filter by a given quality. [720p, 1080p, 3D]
     *            [Integer] "minimum_rating"  Used to filter movie by a given minimum IMDb rating
     *            [String]  "query_term"      Used for movie search, matching on: Movie Title/IMDb Code, Actor Name/IMDb Code, Director Name/IMDb Code
     *            [String]  "genre"           Used to filter by a given genre (See http://www.imdb.com/genre/ for full list)
     *            [String]  "sort_by"         Sorts the results by choosen value. [itle, year, rating, peers, seeds, download_count, like_count, date_added]
     *            [String]  "order_by"        Orders the results by either Ascending or Descending order. [desc,asc]
     *            [Boolean] "with_rt_ratings" Returns the list with the Rotten Tomatoes rating included
     * @return an Observable<YtsResponse<MoviePage>>
     */
    @GET("/list_movies.json")
    public Observable<YtsResponse<MoviePage>> listRx(
            @QueryMap Map<String, Object> options);

    /**
     * Sync movie details.
     * <br/>
     *
     * @param the movie id
     * @param the optional parameters
     *            [Boolean] "with_images" When set the data returned will include the added image URLs
     *            [Boolean] "with_cast"   When set the data returned will include the added information about the cast
     * @return a YtsResponse<MovieDetail>
     */
    @GET("/movie_details.json")
    public YtsResponse<MovieDetail> details(
            @Query("movie_id") Integer movieId,
            @QueryMap Map<String, Object> options);

    /**
     * Aync movie details.
     * <br/>
     *
     * @param the movie id
     * @param the optional parameters
     *            [Boolean] "with_images" When set the data returned will include the added image URLs
     *            [Boolean] "with_cast"   When set the data returned will include the added information about the cast
     * @param a   Callback<YtsResponse<MovieDetail>>
     */
    @GET("/movie_details.json")
    public YtsResponse<MovieDetail> details(
            @Query("movie_id") Integer movieId,
            @QueryMap Map<String, Object> options,
            Callback<YtsResponse<MovieDetail>> callback);

    /**
     * Reactive movie details.
     * <br/>
     *
     * @param the movie id
     * @param the optional parameters
     *            [Boolean] "with_images" When set the data returned will include the added image URLs
     *            [Boolean] "with_cast"   When set the data returned will include the added information about the cast
     * @return an Observable<YtsResponse<MovieDetail>>
     */
    @GET("/movie_details.json")
    public Observable<YtsResponse<MovieDetail>> detailsRx(
            @Query("movie_id") Integer movieId,
            @QueryMap Map<String, Object> options);

    /**
     * Sync get suggestions.
     * <br/>
     *
     * @param the movie id
     * @return a YtsResponse<SuggestionPage>
     */
    @GET("/movie_suggestions.json")
    public YtsResponse<SuggestionPage> suggestions(
            @Query("movie_id") Integer movieId);

    /**
     * Aync get suggestions.
     * <br/>
     *
     * @param the movie id
     * @param a   Callback<YtsResponse<SuggestionPage>>
     */
    @GET("/movie_suggestions.json")
    public YtsResponse<SuggestionPage> suggestions(
            @Query("movie_id") Integer movieId,
            Callback<YtsResponse<SuggestionPage>> callback);

    /**
     * Reactive get suggestions.
     * <br/>
     *
     * @param the movie id
     * @return an Observable<YtsResponse<SuggestionPage>>
     */
    @GET("/movie_suggestions.json")
    public Observable<YtsResponse<SuggestionPage>> suggestionsRx(
            @Query("movie_id") Integer movieId);

    /**
     * Sync get reviews.
     * <br/>
     *
     * @param the movie id
     * @return a YtsResponse<ReviewPage>
     */
    @GET("/movie_reviews.json")
    public YtsResponse<ReviewPage> reviews(
            @Query("movie_id") Integer movieId);

    /**
     * Async get reviews.
     * <br/>
     *
     * @param the movie id
     * @param a   Callback<YtsResponse<ReviewPage>>
     */
    @GET("/movie_reviews.json")
    public YtsResponse<ReviewPage> reviews(
            @Query("movie_id") Integer movieId,
            Callback<YtsResponse<ReviewPage>> callback);

    /**
     * Reactive get reviews.
     * <br/>
     *
     * @param the movie id
     * @return an Observable<YtsResponse<ReviewPage>>
     */
    @GET("/movie_reviews.json")
    public Observable<YtsResponse<ReviewPage>> reviewsRx(
            @Query("movie_id") Integer movieId);

    /**
     * Sync get parental guides.
     * <br/>
     *
     * @param the movie id
     * @return a YtsResponse<ParentalGuidePage>
     */
    @GET("/movie_comments.json")
    public YtsResponse<ParentalGuidePage> parentalGuides(
            @Query("movie_id") Integer movieId);

    /**
     * Async get parental guides.
     * <br/>
     *
     * @param the movie id
     * @param a   Callback<YtsResponse<ParentalGuidePage>>
     */
    @GET("/movie_comments.json")
    public YtsResponse<ParentalGuidePage> parentalGuides(
            @Query("movie_id") Integer movieId,
            Callback<YtsResponse<ParentalGuidePage>> callback);

    /**
     * Reactive get parental guides.
     * <br/>
     *
     * @param the movie id
     * @return an Observable<YtsResponse<ParentalGuidePage>>
     */
    @GET("/movie_comments.json")
    public Observable<YtsResponse<ParentalGuidePage>> parentalGuidesRx(
            @Query("movie_id") Integer movieId);

    /**
     * Sync get upcoming movies.
     * <br/>
     *
     * @return a YtsResponse<UpcomingMoviePage>
     */
    @GET("/list_upcoming.json")
    public YtsResponse<UpcomingMoviePage> upcoming();

    /**
     * Async get upcoming movies.
     * <br/>
     *
     * @param a Callback<YtsResponse<UpcomingMoviePage>>
     */
    @GET("/list_upcoming.json")
    public YtsResponse<UpcomingMoviePage> upcoming(
            Callback<YtsResponse<UpcomingMoviePage>> callback);

    /**
     * Reactive get upcoming movies.
     * <br/>
     *
     * @return an Observable<YtsResponse<UpcomingMoviePage>>
     */
    @GET("/list_upcoming.json")
    public Observable<YtsResponse<UpcomingMoviePage>> upcomingRx();

    /**
     * Sync like movie.
     * <br/>
     *
     * @param the application key
     * @param the user key
     * @param the movie id
     * @return a YtsResponse
     */
    @FormUrlEncoded
    @POST("/like_movie.json")
    public YtsResponse like(
            @Field("application_key") String applicationKey,
            @Field("user_key") String userKey,
            @Field("movie_id") Integer movieId);

    /**
     * Async like movie.
     * <br/>
     *
     * @param the application key
     * @param the user key
     * @param the movie id
     * @param a   Callback<YtsResponse>
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
     * <br/>
     *
     * @param the application key
     * @param the user key
     * @param the movie id
     * @return an Observable<YtsResponse>
     */
    @FormUrlEncoded
    @POST("/like_movie.json")
    public Observable<YtsResponse> likeRx(
            @Field("application_key") String applicationKey,
            @Field("user_key") String userKey,
            @Field("movie_id") Integer movieId);
}