package yts.module;

import org.junit.Test;

import yts.model.BookmarkPage;
import yts.response.YtsResponse;
import yts.response.YtsStatus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class BookmarkModuleTest extends ModuleTest {

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