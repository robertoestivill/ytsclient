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

package com.ytsclient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ytsclient.model.MovieComment;
import com.ytsclient.model.MovieDetails;
import com.ytsclient.model.MovieRequestPage;
import com.ytsclient.model.MovieRequests;
import com.ytsclient.model.MovieUpcoming;
import com.ytsclient.model.Movies;
import com.ytsclient.model.User;
import com.ytsclient.model.YtsLogin;
import com.ytsclient.model.YtsResponse;

import java.util.List;
import java.util.Map;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;
import retrofit.http.Field;
import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;
import retrofit.http.QueryMap;

/**
 * Interface definition of the Yts API.
 * <p/>
 * This interface defines each of the endpoints available on the Yts API.
 *
 * @author robertoestivill@gmail.com
 */
public interface YtsClient {

    @GET("/api/upcoming.json")
    public List<MovieUpcoming> getUpcomingMovies();

    @GET("/api/upcoming.json")
    public void getUpcomingMovies(
            Callback<List<MovieUpcoming>> cb);

    @GET("/api/list.json")
    public Movies getMovies(
            @QueryMap Map<String, Object> options);

    @GET("/api/list.json")
    public void getMovies(
            @QueryMap Map<String, Object> options,
            Callback<Movies> cb);

    @GET("/api/movie.json")
    public MovieDetails getMovieDetails(
            @Query("id") Integer movieId);

    @GET("/api/movie.json")
    public void getMovieDetails(
            @Query("id") Integer movieId,
            Callback<MovieDetails> cb);

    @GET("/api/comments.json")
    public List<MovieComment> getMovieComments(
            @Query("movieid") Integer movieId);

    @GET("/api/comments.json")
    public void getMovieComments(
            @Query("movieid") Integer movieId,
            Callback<List<MovieComment>> cb);

    @GET("/api/user.json")
    public User getUserDetails(
            @Query("id") Integer id);

    @GET("/api/user.json")
    public void getUserDetails(
            @Query("id") Integer id,
            Callback<User> cb);

    @FormUrlEncoded
    @POST("/api/register.json")
    public YtsResponse register(
            @Field("username") String username,
            @Field("password") String password,
            @Field("email") String email);

    @FormUrlEncoded
    @POST("/api/register.json")
    public void register(
            @Field("username") String username,
            @Field("password") String password,
            @Field("email") String email,
            Callback<YtsResponse> cb);

    @FormUrlEncoded
    @POST("/api/registerconfirm.json")
    public YtsResponse registerConfirmation(
            @Field("code") String code);

    @FormUrlEncoded
    @POST("/api/registerconfirm.json")
    public void registerConfirmation(
            @Field("code") String code,
            Callback<YtsResponse> cb);

    @FormUrlEncoded
    @POST("/api/login.json")
    public YtsLogin login(
            @Field("username") String username,
            @Field("password") String password);

    @FormUrlEncoded
    @POST("/api/login.json")
    public void login(
            @Field("username") String username,
            @Field("password") String password,
            Callback<YtsLogin> cb);

    @FormUrlEncoded
    @POST("/api/sendresetpass.json")
    public YtsResponse forgotPassword(
            @Field("email") String email);

    @FormUrlEncoded
    @POST("/api/sendresetpass.json")
    public void forgotPassword(
            @Field("email") String email,
            Callback<YtsResponse> cb);

    @GET("/api/profile.json")
    public User getUserProfile(
            @Query("hash") String hash);

    @GET("/api/profile.json")
    public void getUserProfile(
            @Query("hash") String hash,
            Callback<User> cb);

    @FormUrlEncoded
    @POST("/api/resetpassconfirm")
    public YtsResponse resetPassword(
            @Field("code") String code,
            @Field("newpassword") String newPassword);

    @FormUrlEncoded
    @POST("/api/resetpassconfirm")
    public void resetPassword(
            @Field("code") String code,
            @Field("newpassword") String newPassword,
            Callback<YtsResponse> cb);

    @FormUrlEncoded
    @POST("/api/commentpost.json")
    public YtsResponse postComment(
            @Field("hash") String hash,
            @Field("text") String comment,
            @Field("movieid") Integer movieId,
            @FieldMap Map<String, Object> optionals);

    @FormUrlEncoded
    @POST("/api/commentpost.json")
    public void postComment(
            @Field("hash") String hash,
            @Field("text") String comment,
            @Field("movieid") Integer movieId,
            @FieldMap Map<String, Object> optionals,
            Callback<YtsResponse> cb);

    @GET("/api/requests.json")
    public MovieRequests getMovieRequests(
            @Query("page") MovieRequestPage page,
            @QueryMap Map<String, Object> optionals);

    @GET("/api/requests.json")
    public void getMovieRequests(
            @Query("page") MovieRequestPage page,
            @QueryMap Map<String, Object> optionals,
            Callback<MovieRequests> cb);

    @FormUrlEncoded
    @POST("/api/makerequest.json")
    public YtsResponse requestMovie(
            @Field("hash") String hash,
            @Field("request") String request);

    @FormUrlEncoded
    @POST("/api/makerequest.json")
    public void requestMovie(
            @Field("hash") String hash,
            @Field("request") String request,
            Callback<YtsResponse> cb);

    @FormUrlEncoded
    @POST("/api/vote.json")
    public YtsResponse voteRequest(
            @Field("hash") String hash,
            @Field("requestid") Integer requestId);

    @FormUrlEncoded
    @POST("/api/vote.json")
    public void voteRequest(
            @Field("hash") String hash,
            @Field("requestid") Integer requestId,
            Callback<YtsResponse> cb);

    @FormUrlEncoded
    @POST("/api/editprofile.json")
    public YtsResponse editProfile(
            @Field("hash") String hash,
            @FieldMap Map<String, Object> optionals);

    @FormUrlEncoded
    @POST("/api/editprofile.json")
    public void editProfile(
            @Field("hash") String hash,
            @FieldMap Map<String, Object> optionals,
            Callback<YtsResponse> cb);

    /**
     * Builder class. <br/>
     */
    public static class Builder {
        private RestAdapter.LogLevel logLevel = RestAdapter.LogLevel.NONE;
        private String apiUrl = "http://yts.re";


        public Builder log(RestAdapter.LogLevel log) {
            if (logLevel == null) {
                throw new IllegalStateException("LogLevel can not be null");
            }
            logLevel = log;
            return this;
        }

        public Builder url(String url) {
            if (url == null) {
                throw new IllegalStateException("Url can not be null");
            }
            apiUrl = url;
            return this;
        }

        public YtsClient build() {
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd HH:mm:ss")
                    .create();

            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(apiUrl)
                    .setLogLevel(logLevel)
                    .setConverter(new GsonConverter(gson))
                    .build();

            return restAdapter.create(YtsClient.class);
        }
    }
}
