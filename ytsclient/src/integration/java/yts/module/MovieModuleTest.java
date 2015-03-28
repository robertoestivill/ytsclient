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

import yts.model.MovieDetail;
import yts.model.MoviePage;
import yts.model.ParentalGuidePage;
import yts.model.ReviewPage;
import yts.model.SuggestionPage;
import yts.model.UpcomingMoviePage;
import yts.response.YtsResponse;
import yts.response.YtsStatus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class MovieModuleTest extends ModuleTest {

    @Ignore
    @Test
    public void testSuggestions() {
        YtsResponse<SuggestionPage> response = CLIENT
                .movies()
                .suggestions(1234);

        assertNotNull(response);
        assertEquals(YtsStatus.OK, response.status);
        assertNotNull(response.data);
        assertFalse(response.data.suggestions.isEmpty());
    }

    @Ignore
    @Test
    public void testUpcoming() {
        YtsResponse<UpcomingMoviePage> response = CLIENT
                .movies()
                .upcoming();

        assertNotNull(response);
        assertEquals(YtsStatus.OK, response.status);
        assertNotNull(response.data);
        assertFalse(response.data.upcomingMovies.isEmpty());
    }

    @Ignore
    @Test
    public void testDetails() {
        YtsResponse<MovieDetail> response = CLIENT
                .movies()
                .details(1234, null);

        assertNotNull(response);
        assertEquals(YtsStatus.OK, response.status);
        assertNotNull(response.data);
    }

    @Ignore
    @Test
    public void testList() {
        YtsResponse<MoviePage> response = CLIENT
                .movies()
                .list(null);

        assertNotNull(response);
        assertEquals(YtsStatus.OK, response.status);
        assertNotNull(response.data);
    }

    @Ignore
    @Test
    public void testParentalGuides() {
        YtsResponse<ParentalGuidePage> response = CLIENT
                .movies()
                .parentalGuides(1234);

        assertNotNull(response);
        assertEquals(YtsStatus.OK, response.status);
        assertNotNull(response.data);
    }

    @Ignore
    @Test
    public void testReviews() {
        YtsResponse<ReviewPage> response = CLIENT
                .movies()
                .reviews(1234);

        assertNotNull(response);
        assertEquals(YtsStatus.OK, response.status);
        assertNotNull(response.data);
    }

    @Ignore
    @Test
    public void testLike() {
        YtsResponse response = CLIENT
                .movies()
                .like(APPLICATION_KEY, USER_KEY, 1234);

        assertNotNull(response);
        assertEquals(YtsStatus.OK, response.status);
    }
}