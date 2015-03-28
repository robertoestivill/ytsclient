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

import yts.model.CommentConfirmation;
import yts.response.YtsResponse;
import yts.response.YtsStatus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CommentModuleTest extends ModuleTest {

    @Ignore
    @Test
    public void testAll() {
        // Create comment
        Integer movieId = 3795; // Even after deletion the comment still exists
        YtsResponse<CommentConfirmation> responseCreate = CLIENT.comments()
                .create(APPLICATION_KEY,
                        USER_KEY,
                        movieId,
                        "This is a test comment. Please disregard.");

        assertNotNull(responseCreate);
        assertEquals(YtsStatus.OK, responseCreate.status);
        assertNotNull(responseCreate.data);
        assertEquals(movieId, responseCreate.data.movieId);

        Integer commentId = responseCreate.data.commentId;

        // Like comment
        YtsResponse responseLike = CLIENT.comments()
                .like(APPLICATION_KEY,
                        USER_KEY,
                        commentId);

        assertNotNull(responseLike);
        assertEquals(YtsStatus.OK, responseLike.status);

        // Report comment
        YtsResponse responseReport = CLIENT.comments()
                .report(APPLICATION_KEY,
                        USER_KEY,
                        commentId);

        assertNotNull(responseReport);
        assertEquals(YtsStatus.OK, responseReport.status);

        // Delete comment
        YtsResponse responseDelete = CLIENT.comments()
                .delete(APPLICATION_KEY,
                        USER_KEY,
                        commentId);

        assertNotNull(responseDelete);
        assertEquals(YtsStatus.OK, responseDelete.status);
    }
}