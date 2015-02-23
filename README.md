YTS Api Client
=========

Java library to consume the [YTS REST api][1].

[![Build Status](https://snap-ci.com/robertoestivill/YTS-Client/branch/master/build_image)](https://snap-ci.com/robertoestivill/YTS-Client/branch/master)

Get the code
-- 
```sh
git clone https://github.com/robertoestivill/yts-client.git yts-client
```

Build with Maven 
--

```sh
cd yts-client
mvn clean install
```

Once you have built it and install it to your local repository, you can reference it from your Maven project with the following dependency details

```xml
<dependency>
  <groupId>com.robertin</groupId>
  <artifactId>yts-client</artifactId>
  <version>${LATEST_VERSION}</version>
</dependency>
```

Build with Gradle
--

```sh
cd yts-client
./gradlew clean install
```

Once you have built it and install it to your local repository, you can reference it from your Gradle project with the following dependency details

```json
dependencies {
    compile group: 'com.robertin', name: 'yts-client', version: '${LATEST_VERSION}'
}
```



Usage
--
The main interface of the library is ```com.ytsclient.YtsClient```. 

Get a configured instance of the ```YtsClient``` by using the ```YtsClient.Builder()``` class.

```java
YtsClient client = new YtsClient.Builder().build();
```

You can also pass the ```LogLevel``` or a custom url

```java
YtsClient client = new YtsClient.Builder()
            .log( LogLevel.FULL )
            .url( "http://yts.re" )
            .build();
```


Methods
--
Once you have a ```YtsClient``` instance, you can call any of the following methods:

* ```editProfile```
* ```forgotPassword```
* ```getMovieComments```
* ```getMovieDetails```
* ```getMovieRequests```
* ```getMovies```
* ```getUpcomingMovies```
* ```getUserDetails```
* ```getUserProfile```
* ```login```
* ```postComment```
* ```register```
* ```registerConfirmation```
* ```requestMovie```
* ```resetPassword```
* ```voteRequest```



Integration Tests
--

The ```com.ytsclient.YtsClientTest``` class has an integration test for every method in main interface. 

This tests were used as a tool to validate the well functioning of the library. However, because we are hitting a production API, all the tests are ```@Ignore```'d. 

Please uncomment whatever test you might need.



License
----

    Copyright 2014 Roberto Estivill

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

[1]:http://yts.re/api
[git-repo-url]:http://github.com/robertoestivill/yts-client
