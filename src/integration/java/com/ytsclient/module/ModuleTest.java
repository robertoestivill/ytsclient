package com.ytsclient.module;

import com.ytsclient.YtsClient;
import com.ytsclient.model.UserKey;
import com.ytsclient.response.YtsResponse;
import com.ytsclient.response.YtsStatus;

import org.junit.BeforeClass;

import retrofit.RestAdapter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ModuleTest {

    static String APPLICATION_KEY; // hardcode your own
    static String USERNAME; // hardcode your own
    static String EMAIL; // hardcode your own
    static String PASSWORD; // hardcode your own

    static YtsClient CLIENT;
    static String USER_KEY;

    static {
        APPLICATION_KEY = init(APPLICATION_KEY, "APPLICATION_KEY");
        USERNAME = init(USERNAME, "USERNAME");
        EMAIL = init(EMAIL, "EMAIL");
        PASSWORD = init(PASSWORD, "PASSWORD");

        System.out.println("Initializing test data:");
        System.out.println("APPLICATION_KEY " + APPLICATION_KEY);
        System.out.println("USERNAME \t\t" + USERNAME);
        System.out.println("PASSWORD \t\t" + PASSWORD);
        System.out.println("EMAIL \t\t\t" + EMAIL);
    }

    @BeforeClass
    public static void setup() {
        CLIENT = new YtsClient
                .Builder()
                .log(RestAdapter.LogLevel.FULL)
                .build();

        YtsResponse<UserKey> response = CLIENT.user().key(
                APPLICATION_KEY,
                USERNAME,
                PASSWORD);

        assertNotNull(response);
        assertEquals(YtsStatus.OK, response.status);
        assertNotNull(response.data.userKey);
        USER_KEY = response.data.userKey;
    }

    private static String init(String value, String name) {
        if (value != null) {
            return value;
        }
        String env = System.getenv("YTS_" + name);
        if (env != null && env.length() > 0) {
            return env;
        }
        throw new IllegalStateException("Missing data for tests. Hardcode YtsTestData."
                + name + " or set YTS_" + name + " as an environment variable.");
    }
}
