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

package yts;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;
import yts.module.BookmarkModule;
import yts.module.CommentModule;
import yts.module.MovieModule;
import yts.module.RequestModule;
import yts.module.UserModule;

/**
 * Interface definition of the Yts API.
 * This interface defines each of the endpoints available on the Yts API.
 *
 * @author robertoestivill@gmail.com
 */
public class YtsClient {

    private BookmarkModule bookmarkModule;
    private CommentModule commentModule;
    private MovieModule movieModule;
    private RequestModule requestModule;
    private UserModule userModule;

    /**
     * Avoid instantiation. Use YtsClient.Builder
     */
    private YtsClient() {
    }

    public BookmarkModule bookmarks() {
        if (bookmarkModule == null) {
            throw new IllegalStateException("Bookmarks module not loaded. Call YtsClient.Builder.withBookmarks() ");
        }
        return bookmarkModule;
    }

    public CommentModule comments() {
        if (commentModule == null) {
            throw new IllegalStateException("Comments module not loaded. Call YtsClient.Builder.withComments() ");
        }
        return commentModule;
    }

    public MovieModule movies() {
        if (movieModule == null) {
            throw new IllegalStateException("Movies module not loaded. Call YtsClient.Builder.withMovies() ");
        }
        return movieModule;
    }

    public RequestModule requests() {
        if (requestModule == null) {
            throw new IllegalStateException("Requests module not loaded. Call YtsClient.Builder.withRequests() ");
        }
        return requestModule;
    }

    public UserModule user() {
        if (userModule == null) {
            throw new IllegalStateException("User module not loaded. Call YtsClient.Builder.withUser() ");
        }
        return userModule;
    }

    /**
     * Builder class.
     */
    public static class Builder {
        private RestAdapter.LogLevel logLevel = RestAdapter.LogLevel.NONE;
        private String apiUrl = "https://yts.ag/api/v2/";

        private boolean isCustomModulesInitialization = false;
        private boolean[] isModuleEnabled = new boolean[5];

        public Builder log(RestAdapter.LogLevel log) {
            if (logLevel == null) {
                throw new IllegalStateException("LogLevel can not be null");
            }
            logLevel = log;
            return this;
        }

        public Builder url(String url) {
            if (url == null) {
                throw new IllegalStateException("Url can not be null");
            }
            apiUrl = url;
            return this;
        }

        public Builder withBookmarks() {
            isCustomModulesInitialization = true;
            isModuleEnabled[0] = true;
            return this;
        }

        public Builder withComments() {
            isCustomModulesInitialization = true;
            isModuleEnabled[1] = true;
            return this;
        }

        public Builder withMovies() {
            isCustomModulesInitialization = true;
            isModuleEnabled[2] = true;
            return this;
        }

        public Builder withRequests() {
            isCustomModulesInitialization = true;
            isModuleEnabled[3] = true;
            return this;
        }

        public Builder withUser() {
            isCustomModulesInitialization = true;
            isModuleEnabled[4] = true;
            return this;
        }

        public YtsClient build() {
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd HH:mm:ss")
                    .create();

            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(apiUrl)
                    .setLogLevel(logLevel)
                    .setConverter(new GsonConverter(gson))
                    .build();

            YtsClient client = new YtsClient();
            if (!isCustomModulesInitialization || isModuleEnabled[0]) {
                client.bookmarkModule = restAdapter.create(BookmarkModule.class);
            }
            if (!isCustomModulesInitialization || isModuleEnabled[1]) {
                client.commentModule = restAdapter.create(CommentModule.class);
            }
            if (!isCustomModulesInitialization || isModuleEnabled[2]) {
                client.movieModule = restAdapter.create(MovieModule.class);
            }
            if (!isCustomModulesInitialization || isModuleEnabled[3]) {
                client.requestModule = restAdapter.create(RequestModule.class);
            }
            if (!isCustomModulesInitialization || isModuleEnabled[4]) {
                client.userModule = restAdapter.create(UserModule.class);
            }
            return client;
        }
    }
}
