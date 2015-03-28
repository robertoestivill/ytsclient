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

import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import retrofit.mime.TypedFile;
import retrofit.mime.TypedString;
import yts.model.Profile;
import yts.model.User;
import yts.model.UserKey;
import yts.response.YtsResponse;
import yts.response.YtsStatus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UserModuleTest extends ModuleTest {

    @Ignore
    @Test
    public void testProfileAndDetails() {
        // Retrieve user key
        String userKey = getUserKey();

        // Retrieve user profile
        YtsResponse<Profile> responseProfile = CLIENT
                .user()
                .profile(userKey);

        assertNotNull(responseProfile);
        assertEquals(YtsStatus.OK, responseProfile.status);
        assertNotNull(responseProfile.data);
        assertNotNull(responseProfile.data.id);

        // Retrieve user details
        Integer userId = responseProfile.data.id;
        YtsResponse<User> responseUser = CLIENT
                .user()
                .details(userId, null);

        assertNotNull(responseUser);
        assertEquals(YtsStatus.OK, responseUser.status);
        assertNotNull(responseUser.data);
        assertEquals(userId, responseUser.data.id);
    }

    @Ignore
    @Test
    public void testRegistration_fail() {
        YtsResponse<UserKey> response = CLIENT
                .user()
                .register(APPLICATION_KEY, USERNAME, PASSWORD, EMAIL);

        assertNotNull(response);
        assertEquals(YtsStatus.ERROR, response.status);
    }

    @Ignore
    @Test
    public void testRegistration_success() {
        long now = System.currentTimeMillis();
        YtsResponse<UserKey> response = CLIENT
                .user()
                .register(APPLICATION_KEY, USERNAME + now, PASSWORD, newEmail(now));

        assertNotNull(response);
        assertEquals(YtsStatus.OK, response.status);
        assertNotNull(response.data);
        assertNotNull(response.data.userKey);
    }

    @Ignore
    @Test
    public void testForgotPassword() {
        YtsResponse response = CLIENT
                .user()
                .forgotPassword(APPLICATION_KEY, EMAIL);

        assertNotNull(response);
        assertEquals(YtsStatus.OK, response.status);
    }

    @Ignore
    @Test
    public void testResetPassword() {
        // Get the reset code from the forgot password email 
        // triggered by testForgotPassword
        String resetCode = "";

        YtsResponse<UserKey> response = CLIENT
                .user()
                .resetPassword(APPLICATION_KEY, resetCode, PASSWORD);

        assertNotNull(response);
        assertEquals(YtsStatus.OK, response.status);
        assertNotNull(response.data);
        assertNotNull(response.data.userKey);
    }

    @Ignore
    @Test
    public void testEdit() {
        String userKey = getUserKey();

        Map<String, Object> options = new HashMap<String, Object>();
        options.put("about_text", "this is a test update");

        YtsResponse<Profile> response = CLIENT
                .user()
                .edit(APPLICATION_KEY, userKey, options);

        assertNotNull(response);
        assertEquals(YtsStatus.OK, response.status);
        assertNotNull(response.data);
        assertEquals("this is a test update", response.data.about);
    }

    @Ignore
    @Test
    public void testAvatar() {
        File pictureFile = new File("ytsclient/src/integration/resources/logo.png");
        TypedFile picture = new TypedFile("application/octet-stream", pictureFile);
        TypedString appKey = new TypedString(APPLICATION_KEY);
        TypedString userKey = new TypedString(getUserKey());

        YtsResponse<Profile> response = CLIENT
                .user()
                .picture(appKey, userKey, picture);

        assertNotNull(response);
        assertEquals(YtsStatus.OK, response.status);
        assertNotNull(response.data);
        assertNotNull(response.data.smallImageUrl);
    }

    private String getUserKey() {
        // Retrieve user key
        YtsResponse<UserKey> responseKey = CLIENT
                .user()
                .key(APPLICATION_KEY, USERNAME, PASSWORD);

        assertNotNull(responseKey);
        assertEquals(YtsStatus.OK, responseKey.status);
        assertNotNull(responseKey.data);
        assertNotNull(responseKey.data.userKey);
        return responseKey.data.userKey;
    }

    private String newEmail(long now) {
        String[] emailParts = EMAIL.split("@");
        String newEmail = emailParts[0] + "+" + now + "@" + emailParts[1];
        System.out.print(">>>>>>>>>>>USING EMAIL " + newEmail);
        return newEmail;
    }
}
