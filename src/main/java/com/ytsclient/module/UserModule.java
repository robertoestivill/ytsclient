package com.ytsclient.module;

import com.ytsclient.model.Profile;
import com.ytsclient.model.User;
import com.ytsclient.model.UserKey;
import com.ytsclient.response.YtsResponse;

import java.util.Map;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Query;
import retrofit.http.QueryMap;
import rx.Observable;

public interface UserModule {

    /**
     * Sync get user details.
     * <br/>
     *
     * @param the user id
     * @param the optional parameters
     *            [Boolean] "with_recently_downloaded" If set it will add the most recent downloads by the specified user
     * @return a YtsResponse<User>
     */
    @GET("/user_details.json")
    public YtsResponse<User> details(
            @Query("user_id") Integer id,
            @QueryMap Map<String, Object> options);

    /**
     * Async get user details.
     * <br/>
     *
     * @param the user id
     * @param the optional parameters
     *            [Boolean] "with_recently_downloaded" If set it will add the most recent downloads by the specified user
     * @param a   Callback<YtsResponse<User>>
     */
    @GET("/user_details.json")
    public void details(
            @Query("user_id") Integer id,
            @QueryMap Map<String, Object> options,
            Callback<YtsResponse<User>> callback);

    /**
     * Reactive get user details.
     * <br/>
     *
     * @param the user id
     * @param the optional parameters
     *            [Boolean] "with_recently_downloaded" If set it will add the most recent downloads by the specified user
     * @return an Observable<YtsResponse<User>>
     */
    @GET("/user_details.json")
    public Observable<YtsResponse<User>> detailsRx(
            @Query("user_id") Integer id,
            @QueryMap Map<String, Object> options);


    /**
     * Sync get user key.
     * <br/>
     *
     * @param the application key
     * @param the user name
     * @param the user password
     * @return a YtsResponse<UserKey>
     */
    @FormUrlEncoded
    @POST("/user_get_key.json")
    public YtsResponse<UserKey> key(
            @Field("application_key") String applicationKey,
            @Field("username") String username,
            @Field("password") String password);

    /**
     * Async get user key.
     * <br/>
     *
     * @param the application key
     * @param the user name
     * @param the user password
     * @param a   Callback<YtsResponse<UserKey>>
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
     * <br/>
     *
     * @param the application key
     * @param the user name
     * @param the user password
     * @return an Observable<YtsResponse<UserKey>>
     */
    @FormUrlEncoded
    @POST("/user_get_key.json")
    public Observable<YtsResponse<UserKey>> keyRx(
            @Field("application_key") String applicationKey,
            @Field("username") String username,
            @Field("password") String password);


    /**
     * Sync get user profile.
     * <br/>
     *
     * @param the user key
     * @return a YtsResponse<Profile>
     */
    @GET("/user_profile.json")
    public YtsResponse<Profile> profile(
            @Query("user_key") String userKey);

    /**
     * Async get user profile.
     * <br/>
     *
     * @param the user key
     * @param a   Callback<YtsResponse<Profile>>
     */
    @GET("/user_profile.json")
    public void profile(
            @Query("user_key") String userKey,
            Callback<YtsResponse<Profile>> callback);

    /**
     * Reactive get user profile.
     * <br/>
     *
     * @param the user key
     * @return an Observable<YtsResponse<Profile>>
     */
    @GET("/user_profile.json")
    public Observable<YtsResponse<Profile>> profileRx(
            @Query("user_key") String userKey);

    /**
     * Sync edit user settings.
     * <br/>
     *
     * @param the application key
     * @param the user key
     * @param the optional parameters
     *            [String] "new_password" The new desired password
     *            [String] "about_text"   Text describing the user in a short paragraph
     *            [Image]  "avatar_image" Upload (using multi-part) a new avatar image
     * @return a YtsResponse<Profile>
     */
    @FormUrlEncoded
    @Multipart
    @POST("/user_edit_settings.json")
    public YtsResponse<Profile> edit(
            @Field("application_key") String applicationKey,
            @Field("user_key") String userKey,
            @FieldMap Map<String, Object> options);

    /**
     * Async edit user settings.
     * <br/>
     *
     * @param the application key
     * @param the user key
     * @param the optional parameters
     *            [String] "new_password" The new desired password
     *            [String] "about_text"   Text describing the user in a short paragraph
     *            [Image]  "avatar_image" Upload (using multi-part) a new avatar image
     * @param a   Callback<YtsResponse<Profile>>
     */
    @FormUrlEncoded
    @Multipart
    @POST("/user_edit_settings.json")
    public void edit(
            @Field("application_key") String applicationKey,
            @Field("user_key") String userKey,
            @FieldMap Map<String, Object> options,
            Callback<YtsResponse<Profile>> callback);

    /**
     * Reactive edit user settings.
     * <br/>
     *
     * @param the application key
     * @param the user key
     * @param the optional parameters
     *            [String] "new_password" The new desired password
     *            [String] "about_text"   Text describing the user in a short paragraph
     *            [Image]  "avatar_image" Upload (using multi-part) a new avatar image
     * @return an Observable<YtsResponse<Profile>>
     */
    @FormUrlEncoded
    @Multipart
    @POST("/user_edit_settings.json")
    public Observable<YtsResponse<Profile>> editRx(
            @Field("application_key") String applicationKey,
            @Field("user_key") String userKey,
            @FieldMap Map<String, Object> options);

    /**
     * Sync register user.
     * <br/>
     *
     * @param the application key
     * @param the user name
     * @param the user password
     * @param the user email
     * @return a YtsResponse<UserKey>
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
     * <br/>
     *
     * @param the application key
     * @param the user name
     * @param the user password
     * @param the user email
     * @param a   Callback<YtsResponse<UserKey>>
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
     * <br/>
     *
     * @param the application key
     * @param the user name
     * @param the user password
     * @param the user email
     * @return an Observable<YtsResponse<UserKey>>
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
     * <br/>
     *
     * @param the application key
     * @param the user email
     * @return a YtsResponse
     */
    @FormUrlEncoded
    @POST("/user_forgot_password.json")
    public YtsResponse forgotPassword(
            @Field("application_key") String applicationKey,
            @Field("email") String email);

    /**
     * Async forgot password.
     * <br/>
     *
     * @param the application key
     * @param the user email
     * @param a   Callback<YtsResponse>
     */
    @FormUrlEncoded
    @POST("/user_forgot_password.json")
    public void forgotPassword(
            @Field("application_key") String applicationKey,
            @Field("email") String email,
            Callback<YtsResponse> callback);

    /**
     * Reactive forgot password.
     * <br/>
     *
     * @param the application key
     * @param the user email
     * @return an Observable<YtsResponse>
     */
    @FormUrlEncoded
    @POST("/user_forgot_password.json")
    public Observable<YtsResponse> forgotPasswordRx(
            @Field("application_key") String applicationKey,
            @Field("email") String email);

    /**
     * Sync reset password.
     * <br/>
     *
     * @param the application key
     * @param the reset code
     * @param the user new password
     * @return a YtsResponse<UserKey>
     */
    @FormUrlEncoded
    @POST("/user_reset_password.json")
    public YtsResponse<UserKey> resetPassword(
            @Field("application_key") String applicationKey,
            @Field("reset_code") String resetCode,
            @Field("new_password") String newPassword);

    /**
     * Async reset password.
     * <br/>
     *
     * @param the application key
     * @param the reset code
     * @param the user new password
     * @param a   Callback<YtsResponse<UserKey>>
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
     * <br/>
     *
     * @param the application key
     * @param the reset code
     * @param the user new password
     * @return an Observable<YtsResponse<UserKey>>
     */
    @FormUrlEncoded
    @POST("/user_reset_password.json")
    public Observable<YtsResponse<UserKey>> resetPasswordRx(
            @Field("application_key") String applicationKey,
            @Field("reset_code") String resetCode,
            @Field("new_password") String newPassword);
}