YTS Api Client
=========

Java library to consume the [YTS REST api][1].

---
Get the code
-- 

```sh
git clone https://github.com/robertoestivill/ytsclient.git ytsclient
```

Maven
--

```xml
<dependency>
  <groupId>com.robertoestivill.ytsclient</groupId>
  <artifactId>ytsclient</artifactId>
  <version>${LATEST_VERSION}</version>
</dependency>
```

Gradle
--

```groovy
dependencies {
    compile 'com.robertoestivill.ytsclient:ytsclient:${LATEST_VERSION}'
}
```


---
Get started
--
The main class of the library is `ytsclient.YtsClient`.

Get a configured instance of the `YtsClient` by using the `YtsClient.Builder()` class.

```java
YtsClient client = new YtsClient.Builder()
            .build();
```

You can also pass the `retrofit.RestAdapter.LogLevel` and/or a custom `url`

```java
YtsClient client = new YtsClient.Builder()
            .log( LogLevel.FULL )
            .url( "http://yts.to/api/v2" )
            .build();
```

---
Modules
--

A module is a set of API's grouped by some functionality or model.
The library contains the following modules:

* `BookmarkModule`
* `CommentModule`
* `MovieModule`
* `RequestkModule`
* `UserModule`
 

By default, `YtsClient.Builder` will load and have all the modules available. However, you can specify the modules you would like to load by calling the following methods:

* `YtsClient.Builder.withBookmarks()`
* `YtsClient.Builder.withComments()`
* `YtsClient.Builder.withMovies()`
* `YtsClient.Builder.withRequests()`
* `YtsClient.Builder.withUser()`

To access the methods of a module, you need to acquire a reference to the module by calling one of the following methods:

* `YtsClient.bookmarks()`
* `YtsClient.comments()`
* `YtsClient.movies()`
* `YtsClient.requests()`
* `YtsClient.user()`

If a module is requested without having been loaded, then an `IllegalStateException` will be thrown.

In the following example, only the `UserModule` and the `MovieModule` are loaded. 

```java
YtsClient client = new YtsClient.Builder()
            .withUser()
            .withMovies()
            .build();
            
...
UserModule userModule = client.user();
YtsResponse response = userModule.profile();

... // or
YtsResponse response = client.user().profile();

...
client.comments(); // throws IllegalStateException
```


---
Methods
--

All the methods in all the modules have three implementations: synchronous, asynchronous and reactive. 

The methods that returns an Observable are suffixed with `Rx` because they take the same parameters than the synchronous methods and therefore can not be overloaded.

Example `MovieModule.list`

```java
    // synchronous, blocking
    @GET("/list_movies.json")
    public YtsResponse<MoviePage> list(
            @QueryMap Map<String, Object> options);

    // asynchronous with callback
    @GET("/list_movies.json")
    public void list(
            @QueryMap Map<String, Object> options,
            Callback<YtsResponse<MoviePage>> callback);

    // reactive returns an rx.Observable
    @GET("/list_movies.json")
    public Observable<YtsResponse<MoviePage>> listRx(
            @QueryMap Map<String, Object> options);        
```


The supported methods are:

* `BookmarkModule`
  * `list()`
  * `create()`
  * `delete()`
* `CommentModule`
  * `list()`
  * `create()`
  * `delete()`
  * `like()`
  * `report()`
* `MovieModule`
  * `list()`
  * `details()`
  * `suggestions()`
  * `reviews()`
  * `parentalGuides()`
  * `upcoming()`
  * `like()`
* `RequestModule`
  * `create()`
* `UserModule`
  * `profile()`
  * `details()`
  * `edit()`
  * `key()`
  * `register()`
  * `forgotPassword()`
  * `resetPassword()`
  * `picture()`


---
 Integration Tests
--

Integration tests have been separated from unit tests into a different source folder and task.

You can find the integration tests in `src/integration/java` folder.

All the integration tests have been `@Ignore`'d because they use the production API. 

To run them, comment or delete the `@Ignore` annotation, and add your details the following constants to the `ModuleTest` class before executing the tests.
* `APPLICATION_KEY`
* `USERNAME` 
* `PASSWORD`
* `EMAIL` 

Also, instead of harcoding the values, you can also set up the following environment variables in order to configure your settings without having to modify the source code.
* `YTS_APPLICATION_KEY`
* `YTS_USERNAME`
* `YTS_PASSWORD`
* `YTS_EMAIL`

You can now run them by executing the following task.

```sh
./gradlew integration
```


---
License
----

    Copyright 2015 Roberto Estivill

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

[1]:http://yts.to/api
[git-repo-url]:http://github.com/robertoestivill/ytsclient