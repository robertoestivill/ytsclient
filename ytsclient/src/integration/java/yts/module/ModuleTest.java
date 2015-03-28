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

import org.junit.BeforeClass;

import retrofit.RestAdapter;
import yts.YtsClient;
import yts.model.UserKey;
import yts.response.YtsResponse;
import yts.response.YtsStatus;

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
