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
import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;
import rx.Observable;
import yts.response.YtsResponse;

public interface RequestModule {

    /**
     * Sync create request method.
     *
     * @param applicationKey
     * @param userKey
     * @param movieTitle
     * @param options        [String] "request_message" optional information about the request
     * @return ytsResponse
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
     *
     * @param applicationKey
     * @param userKey
     * @param movieTitle
     * @param options        [String] "request_message" optional information about the request
     * @param callback
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
     *
     * @param applicationKey
     * @param userKey
     * @param movieTitle
     * @param options        [String] "request_message" optional information about the request
     * @return observable
     */
    @FormUrlEncoded
    @POST("/make_request.json")
    public Observable<YtsResponse> createRx(
            @Field("application_key") String applicationKey,
            @Field("user_key") String userKey,
            @Field("movie_title") String movieTitle,
            @FieldMap Map<String, Object> options);
}