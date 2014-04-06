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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.ytsclient.model.MovieComment;
import com.ytsclient.model.MovieDetails;
import com.ytsclient.model.Movies;
import com.ytsclient.model.MovieRequests;
import com.ytsclient.model.MovieRequestPage;
import com.ytsclient.model.MovieUpcoming;
import com.ytsclient.model.User;
import com.ytsclient.model.YtsLogin;
import com.ytsclient.model.YtsResponse;
import com.ytsclient.model.YtsStatus;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YtsClientTest {

    private YtsClient service;

    @Before
    public void setUpAdapter() {
        service = YtsClientFactory.create();
    }

    @Ignore
    @Test
    public void testUpcomingMovies() {
        List<MovieUpcoming> movies = service.getUpcomingMovies();
        assertNotNull(movies);
        assertFalse(movies.isEmpty());
    }

    @Ignore
    @Test
    public void testMovieList() {
        Movies list = service.getMovies(null);
        assertNotNull(list);
        assertNotNull(list.count);
        assertTrue(list.count > 0);
        assertNotNull(list.movies);
        assertFalse(list.movies.isEmpty());
    }

    @Ignore
    @Test
    public void testMovieDetails() {
        MovieDetails details = service.getMovieDetails(1234);
        assertNotNull(details);
    }

    @Ignore
    @Test
    public void testMovieComments() {
        List<MovieComment> comments = service.getMovieComments(1234);
        assertNotNull(comments);
        assertFalse(comments.isEmpty());
    }

    @Ignore
    @Test
    public void testUserDetails() {
        User details = service.getUserDetails(1234);
        assertNotNull(details);
    }

    @Ignore
    @Test
    public void testRegister() {
        YtsResponse response = service.register("USERNAME", "PASSWORD", "EMAIL");
        assertYtsResponse(response);
    }

    @Ignore
    @Test
    public void testRegisterConfirmation() {
        YtsResponse response = service.registerConfirmation("CONFIRMATION CODE");
        assertYtsResponse(response);
    }

    @Ignore
    @Test
    public void testLogin() {
        YtsLogin login = service.login("USER NAME", "PASSWORD");
        assertNotNull(login);
        assertNotNull(login.hash);
        System.out.println(login.hash);
    }

    @Ignore
    @Test
    public void testForgotPassword() {
        YtsResponse response = service.forgotPassword("EMAIL ADDRESS");
        assertYtsResponse(response);
    }

    @Ignore
    @Test
    public void testUserProfile() {
        User user = service.getUserProfile("");
        assertNotNull(user);
    }

    @Ignore
    @Test
    public void testResetPassword() {
        YtsResponse response = service.resetPassword("THE EMAIL CODE", "NEW PASSWORD");
        assertYtsResponse(response);
    }

    @Ignore
    @Test
    public void testPostComment() {
        YtsResponse response = service.postComment("USER HASH", "COMMENT TEXT", 1234, null);
        assertYtsResponse(response);
    }

    @Ignore
    @Test
    public void testMovieRequestList() {
        MovieRequests list = service.getMovieRequests(MovieRequestPage.ACCEPTED, null);
        assertNotNull(list);
        assertNotNull(list.count);
        assertTrue(list.count > 0);
        assertNotNull(list.requests);
        assertFalse(list.requests.isEmpty());
    }

    @Ignore
    @Test
    public void testMakeMovieRequest() {
        YtsResponse response = service.requestMovie("USER HASH", "MOVIE NAME / IMDB LINK");
        assertYtsResponse(response);
    }

    @Ignore
    @Test
    public void testVoteRequest() {
        YtsResponse response = service.voteRequest("USER HASH", 1234);
        assertYtsResponse(response);
    }

    @Ignore
    @Test
    public void testEditProfile() {
        Map<String, Object> optionals = new HashMap<String, Object>();
        YtsResponse response = service.editProfile("USER HASH", optionals);
        assertYtsResponse(response);
    }

    /**
     * Convenient method to assert {@link com.ytsclient.model.YtsResponse}
     * object.
     * <p>
     * 
     * @param response the response to be asserted
     */
    private static void assertYtsResponse(YtsResponse response) {
        assertNotNull(response);
        assertTrue(response.status != YtsStatus.FAIL);
        assertNull(response.error);
    }
}
