package com.ytsclient.module;

import com.ytsclient.response.YtsResponse;

import java.util.Map;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;
import rx.Observable;

public interface RequestModule {

    /**
     * Sync create request method.
     * <br/>
     *
     * @param the application key
     * @param the user key
     * @param the movie title
     * @param the optional parameters
     *            [String] "request_message" optional information about the request
     * @return a YtsResponse
     */
    @FormUrlEncoded
    @POST("/make_request.json")
    public YtsResponse create(
            @Field("application_key") String applicationKey,
            @Field("user_key") String userKey,
            @Field("movie_title") String movieTitle,
            @FieldMap Map<String, Object> options);

    /**
     * Async create request method.
     * <br/>
     *
     * @param the application key
     * @param the user key
     * @param the movie title
     * @param the optional parameters
     *            [String] "request_message" optional information about the request
     * @param a   Callback<YtsResponse>
     */
    @FormUrlEncoded
    @POST("/make_request.json")
    public void create(
            @Field("application_key") String applicationKey,
            @Field("user_key") String userKey,
            @Field("movie_title") String movieTitle,
            @FieldMap Map<String, Object> options,
            Callback<YtsResponse> callback);

    /**
     * Rx create request method.
     * <br/>
     *
     * @param the application key
     * @param the user key
     * @param the movie title
     * @param the optional parameters
     *            [String] "request_message" optional information about the request
     * @return a Observable<YtsResponse<RequestConfirmation>>
     */
    @FormUrlEncoded
    @POST("/make_request.json")
    public Observable<YtsResponse> createRx(
            @Field("application_key") String applicationKey,
            @Field("user_key") String userKey,
            @Field("movie_title") String movieTitle,
            @FieldMap Map<String, Object> options);
}