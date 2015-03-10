package com.ytsclient;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by robertoestivill@gmail.com.
 */
public class YtsClientTest {

    private YtsClient client;

    /**
     * Test to verify the available module instances when initialized by default.
     * <br/>
     */
    @Test
    public void allModulesByDefault() {
        client = new YtsClient
                .Builder()
                .build();

        assertNotNull(client);
        assertNotNull(client.bookmarks());
        assertNotNull(client.comments());
        assertNotNull(client.movies());
        assertNotNull(client.requests());
        assertNotNull(client.user());
    }

    /**
     * Test to verify the available module instances when only YtsClient.Builder.withComments() is called.
     * <br/>
     */
    @Test
    public void onlyBookmarksModule() {
        client = new YtsClient
                .Builder()
                .withBookmarks()
                .build();

        assertNotNull(client);
        assertNotNull(client.bookmarks());
        assertCommentModuleException(client);
        assertMoviesModuleException(client);
        assertRequestsModuleException(client);
        assertUserModuleException(client);
    }

    /**
     * Test to verify the available module instances when only YtsClient.Builder.withComments() is called.
     * <br/>
     */
    @Test
    public void onlyCommentModule() {
        client = new YtsClient
                .Builder()
                .withComments()
                .build();

        assertNotNull(client);
        assertNotNull(client.comments());
        assertBookmarksModuleException(client);
        assertMoviesModuleException(client);
        assertRequestsModuleException(client);
        assertUserModuleException(client);
    }

    /**
     * Test to verify the available module instances when only YtsClient.Builder.withMovies() is called.
     * <br/>
     */
    @Test
    public void onlyMoviesModule() {
        client = new YtsClient
                .Builder()
                .withMovies()
                .build();

        assertNotNull(client);
        assertNotNull(client.movies());
        assertBookmarksModuleException(client);
        assertCommentModuleException(client);
        assertRequestsModuleException(client);
        assertUserModuleException(client);
    }

    /**
     * Test to verify the available module instances when only YtsClient.Builder.withRequests() is called.
     * <br/>
     */
    @Test
    public void onlyRequestsModule() {
        client = new YtsClient
                .Builder()
                .withRequests()
                .build();

        assertNotNull(client);
        assertNotNull(client.requests());
        assertBookmarksModuleException(client);
        assertCommentModuleException(client);
        assertMoviesModuleException(client);
        assertUserModuleException(client);
    }

    /**
     * Test to verify the available modules when only YtsClient.Builder.withUser() is called.
     * <br/>
     */
    @Test
    public void onlyUserModule() {
        client = new YtsClient
                .Builder()
                .withUser()
                .build();

        assertNotNull(client);
        assertNotNull(client.user());
        assertBookmarksModuleException(client);
        assertCommentModuleException(client);
        assertMoviesModuleException(client);
        assertRequestsModuleException(client);
    }

    /**
     * Assert that the YtsClient instances throws an IllegalStateException when calling YtsClient.bookmarks() without having initialized it.
     * <br/>
     *
     * @param client
     */
    private void assertBookmarksModuleException(YtsClient client) {
        try {
            client.bookmarks();
            fail();
        } catch (IllegalStateException e) {
            assertTrue(e.getMessage().contains("Bookmarks module not loaded"));
        }
    }

    /**
     * Assert that the YtsClient instances throws an IllegalStateException when calling YtsClient.comments() without having initialized it.
     * <br/>
     *
     * @param client
     */
    private void assertCommentModuleException(YtsClient client) {
        try {
            client.comments();
            fail();
        } catch (IllegalStateException e) {
            assertTrue(e.getMessage().contains("Comments module not loaded"));
        }
    }

    /**
     * Assert that the YtsClient instances throws an IllegalStateException when calling YtsClient.movies() without having initialized it.
     * <br/>
     *
     * @param client
     */
    private void assertMoviesModuleException(YtsClient client) {
        try {
            client.movies();
        } catch (IllegalStateException e) {
            assertTrue(e.getMessage().contains("Movies module not loaded"));
        }
    }

    /**
     * Assert that the YtsClient instances throws an IllegalStateException when calling YtsClient.requests() without having initialized it.
     * <br/>
     *
     * @param client
     */
    private void assertRequestsModuleException(YtsClient client) {
        try {
            client.requests();
        } catch (IllegalStateException e) {
            assertTrue(e.getMessage().contains("Requests module not loaded"));
        }
    }

    /**
     * Assert that the YtsClient instances throws an IllegalStateException when calling YtsClient.user() without having initialized it.
     * <br/>
     *
     * @param client
     */
    private void assertUserModuleException(YtsClient client) {
        try {
            client.user();
        } catch (IllegalStateException e) {
            assertTrue(e.getMessage().contains("User module not loaded"));
        }
    }
}
