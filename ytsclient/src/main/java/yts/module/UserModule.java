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
import retrofit.http.GET;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.http.Query;
import retrofit.http.QueryMap;
import retrofit.mime.TypedFile;
import retrofit.mime.TypedString;
import rx.Observable;
import yts.model.Profile;
import yts.model.User;
import yts.model.UserKey;
import yts.response.YtsResponse;

public interface UserModule {

    /**
     * Sync get user details.
     *
     * @param userId
     * @param options [Boolean] "with_recently_downloaded" If set it will add the most recent downloads by the specified user
     * @return ytsResponse
     */
    @GET("/user_details.json")
    public YtsResponse<User> details(
            @Query("user_id") Integer userId,
            @QueryMap Map<String, Object> options);

    /**
     * Async get user details.
     *
     * @param userId
     * @param options  [Boolean] "with_recently_downloaded" If set it will add the most recent downloads by the specified user
     * @param callback
     */
    @GET("/user_details.json")
    public void details(
            @Query("user_id") Integer userId,
            @QueryMap Map<String, Object> options,
            Callback<YtsResponse<User>> callback);

    /**
     * Reactive get user details.
     *
     * @param userId
     * @param options [Boolean] "with_recently_downloaded" If set it will add the most recent downloads by the specified user
     * @return observable
     */
    @GET("/user_details.json")
    public Observable<YtsResponse<User>> detailsRx(
            @Query("user_id") Integer userId,
            @QueryMap Map<String, Object> options);

    /**
     * Sync get user key.
     *
     * @param applicationKey
     * @param username
     * @param password
     * @return ytsResponse
     */
    @FormUrlEncoded
    @POST("/user_get_key.json")
    public YtsResponse<UserKey> key(
            @Field("application_key") String applicationKey,
            @Field("username") String username,
            @Field("password") String password);

    /**
     * Async get user key.
     *
     * @param applicationKey
     * @param username
     * @param password
     * @param callback
     */
    @FormUrlEncoded
    @POST("/user_get_key.json")
    public void key(
            @Field("application_key") String applicationKey,
            @Field("username") String username,
            @Field("password") String password,
            Callback<YtsResponse<UserKey>> callback);

    /**
     * Reactive get user key.
     *
     * @param applicationKey
     * @param username
     * @param password
     * @return observable
     */
    @FormUrlEncoded
    @POST("/user_get_key.json")
    public Observable<YtsResponse<UserKey>> keyRx(
            @Field("application_key") String applicationKey,
            @Field("username") String username,
            @Field("password") String password);


    /**
     * Sync get user profile.
     *
     * @param userKey
     * @return ytsResponse
     */
    @GET("/user_profile.json")
    public YtsResponse<Profile> profile(
            @Query("user_key") String userKey);

    /**
     * Async get user profile.
     *
     * @param userKey
     * @param callback
     */
    @GET("/user_profile.json")
    public void profile(
            @Query("user_key") String userKey,
            Callback<YtsResponse<Profile>> callback);

    /**
     * Reactive get user profile.
     *
     * @param userKey
     * @return observable
     */
    @GET("/user_profile.json")
    public Observable<YtsResponse<Profile>> profileRx(
            @Query("user_key") String userKey);

    /**
     * Sync edit user settings.
     *
     * @param applicationKey
     * @param userKey
     * @param options        [String] "new_password" The new desired password
     *                       [String] "about_text"   Text describing the user in a short paragraph
     * @return ytsResponse
     */
    @FormUrlEncoded
    @POST("/user_edit_settings.json")
    public YtsResponse<Profile> edit(
            @Field("application_key") String applicationKey,
            @Field("user_key") String userKey,
            @FieldMap Map<String, Object> options);

    /**
     * Async edit user settings.
     *
     * @param applicationKey
     * @param userKey
     * @param options        [String] "new_password" The new desired password
     *                       [String] "about_text"   Text describing the user in a short paragraph
     * @param callback
     */
    @FormUrlEncoded
    @POST("/user_edit_settings.json")
    public void edit(
            @Field("application_key") String applicationKey,
            @Field("user_key") String userKey,
            @FieldMap Map<String, Object> options,
            Callback<YtsResponse<Profile>> callback);

    /**
     * Reactive edit user settings.
     *
     * @param applicationKey
     * @param userKey
     * @param options        [String] "new_password" The new desired password
     *                       [String] "about_text"   Text describing the user in a short paragraph
     * @return observable
     */
    @FormUrlEncoded
    @POST("/user_edit_settings.json")
    public Observable<YtsResponse<Profile>> editRx(
            @Field("application_key") String applicationKey,
            @Field("user_key") String userKey,
            @FieldMap Map<String, Object> options);

    /**
     * Sync upload user picture.
     *
     * @param applicationKey
     * @param userKey
     * @param picture
     * @return ytsResponse
     */
    @Multipart
    @POST("/user_edit_settings.json")
    public YtsResponse<Profile> picture(
            @Part("application_key") TypedString applicationKey,
            @Part("user_key") TypedString userKey,
            @Part("avatar_image") TypedFile picture);

    /**
     * Async upload user picture.
     *
     * @param applicationKey
     * @param userKey
     * @param picture
     * @param callback
     */
    @Multipart
    @POST("/user_edit_settings.json")
    public void picture(
            @Part("application_key") TypedString applicationKey,
            @Part("user_key") TypedString userKey,
            @Part("avatar_image") TypedFile picture,
            Callback<YtsResponse<Profile>> callback);

    /**
     * Reactive upload user picture.
     *
     * @param applicationKey
     * @param userKey
     * @param picture
     * @return observable
     */
    @Multipart
    @POST("/user_edit_settings.json")
    public Observable<YtsResponse<Profile>> pictureRx(
            @Part("application_key") TypedString applicationKey,
            @Part("user_key") TypedString userKey,
            @Part("avatar_image") TypedFile picture);

    /**
     * Sync register user.
     *
     * @param applicationKey
     * @param username
     * @param password
     * @param email
     * @return ytsResponse
     */
    @FormUrlEncoded
    @POST("/user_register.json")
    public YtsResponse<UserKey> register(
            @Field("application_key") String applicationKey,
            @Field("username") String username,
            @Field("password") String password,
            @Field("email") String email);

    /**
     * Async register user.
     *
     * @param applicationKey
     * @param username
     * @param password
     * @param email
     * @param callback
     */
    @FormUrlEncoded
    @POST("/user_register.json")
    public void register(
            @Field("application_key") String applicationKey,
            @Field("username") String username,
            @Field("password") String password,
            @Field("email") String email,
            Callback<YtsResponse<UserKey>> callback);

    /**
     * Reactive register user.
     *
     * @param applicationKey
     * @param username
     * @param password
     * @param email
     * @return observable
     */
    @FormUrlEncoded
    @POST("/user_register.json")
    public Observable<YtsResponse<UserKey>> registerRx(
            @Field("application_key") String applicationKey,
            @Field("username") String username,
            @Field("password") String password,
            @Field("email") String email);

    /**
     * Sync forgot password.
     *
     * @param applicationKey
     * @param email
     * @return ytsResponse
     */
    @FormUrlEncoded
    @POST("/user_forgot_password.json")
    public YtsResponse forgotPassword(
            @Field("application_key") String applicationKey,
            @Field("email") String email);

    /**
     * Async forgot password.
     *
     * @param applicationKey
     * @param email
     * @param callback
     */
    @FormUrlEncoded
    @POST("/user_forgot_password.json")
    public void forgotPassword(
            @Field("application_key") String applicationKey,
            @Field("email") String email,
            Callback<YtsResponse> callback);

    /**
     * Reactive forgot password.
     *
     * @param applicationKey
     * @param email
     * @return observable
     */
    @FormUrlEncoded
    @POST("/user_forgot_password.json")
    public Observable<YtsResponse> forgotPasswordRx(
            @Field("application_key") String applicationKey,
            @Field("email") String email);

    /**
     * Sync reset password.
     *
     * @param applicationKey
     * @param resetCode
     * @param newPassword
     * @return ytsResponse
     */
    @FormUrlEncoded
    @POST("/user_reset_password.json")
    public YtsResponse<UserKey> resetPassword(
            @Field("application_key") String applicationKey,
            @Field("reset_code") String resetCode,
            @Field("new_password") String newPassword);

    /**
     * Async reset password.
     *
     * @param applicationKey
     * @param resetCode
     * @param newPassword
     * @param callback
     */
    @FormUrlEncoded
    @POST("/user_reset_password.json")
    public void resetPassword(
            @Field("application_key") String applicationKey,
            @Field("reset_code") String resetCode,
            @Field("new_password") String newPassword,
            Callback<YtsResponse<UserKey>> callback);

    /**
     * Reactive reset password.
     *
     * @param applicationKey
     * @param resetCode
     * @param newPassword
     * @return observable
     */
    @FormUrlEncoded
    @POST("/user_reset_password.json")
    public Observable<YtsResponse<UserKey>> resetPasswordRx(
            @Field("application_key") String applicationKey,
            @Field("reset_code") String resetCode,
            @Field("new_password") String newPassword);
}