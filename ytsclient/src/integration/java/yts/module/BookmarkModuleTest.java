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

import yts.model.BookmarkPage;
import yts.response.YtsResponse;
import yts.response.YtsStatus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class BookmarkModuleTest extends ModuleTest {

    @Ignore
    @Test
    public void testCreateDelete() {
        // Create bookmark
        Integer movieId = 3798;
        YtsResponse responseCreate = CLIENT.bookmarks()
                .create(APPLICATION_KEY,
                        USER_KEY,
                        movieId);

        assertNotNull(responseCreate);
        assertEquals(YtsStatus.OK, responseCreate.status);

        // Delete bookmark
        YtsResponse responseDelete = CLIENT.bookmarks()
                .delete(APPLICATION_KEY,
                        USER_KEY,
                        movieId);

        assertNotNull(responseDelete);
        assertEquals(YtsStatus.OK, responseDelete.status);
    }

    @Ignore
    @Test
    public void testList() {
        YtsResponse<BookmarkPage> responseList = CLIENT.bookmarks()
                .list(USER_KEY,
                        null);

        assertNotNull(responseList);
        assertEquals(YtsStatus.OK, responseList.status);
        assertNotNull(responseList.data);
        assertNotNull(responseList.data.bookmarks);
        assertFalse(responseList.data.bookmarks.isEmpty());
    }
}