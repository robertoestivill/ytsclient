YTS Api Client
=========

Java library to consume the [YTS REST api][1] built on top of [Square's Retrofit][2].


Installation
--
This library is built with [Maven][3]. Gradle support will come later on.

```sh
git clone https://github.com/robertoestivill/yts-client.git yts-client
cd yts-client
mvn clean install
```

Once you have built it and install it to your local repository, you can reference it from your Maven project with the following dependency details

```xml
<dependency>
  <groupId>com.robertin</groupId>
  <artifactId>yts-client</artifactId>
  <version>0.1.0</version>
</dependency>
```


Usage
--
The main interface of the library is ```com.ytsclient.YtsClient```. 

Get a configured instance of the ```YtsClient``` by calling ```YtsClientFactory.create()``` method.

```java
YtsClient client = YtsClientFactory.create();
```

You can also call the overloaded method to pass in the ```LogLevel```

```java
YtsClient client = YtsClientFactory.create( LogLevel.FULL );
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
[2]:https://github.com/square/retrofit
[3]:http://maven.apache.org
[git-repo-url]:http://github.com/robertoestivill/yts-client