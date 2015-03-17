package yts.module;

import yts.model.CommentConfirmation;
import yts.response.YtsResponse;
import yts.response.YtsStatus;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CommentModuleTest extends ModuleTest {

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