---
title: Networking in Android
duration: "1:30"
creator:
    name: Jean Weatherwax
    city: San Francisco
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Networking in Android

### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Explain what Retrofit is
- Make a POJO model class from a JSON schema
- Make a service interface with Retrofit
- Use Retrofit and GSONConverterFactory to display API data using a service interface

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- Work with JSON
- Start a background thread using AsyncTask

### INSTRUCTOR PREP
*Before this lesson, instructors will need to:*
- Read through the lesson
- Add additional instructor notes as needed
- Edit language or examples to fit your ideas and teaching style
- Open, read, run, and edit (optional) the starter and solution code to ensure it's working and that you agree with how the code was written

---
## Opening (5 mins)

> Check: Ask the students to identify the main use cases for networking in Android.

Networking in android is mainly about the ability to send and receive data from remote server. This data can be either a plain text, XML, JSON, image or a video stream. Android primarily supports two HTTP clients for networking, one by using Apache HttpClient and other using HttpURLConnection.

## Introduction: Check the Network Connection (10 mins)

Every application that deals with networking requires permissions to be declared in the Manifest:  

```xml
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
```

Before your app attempts to connect to the network, you can check to see whether a network connection is available using `getActiveNetworkInfo()` and `isConnected()`. Remember, the device may be out of range of a network, or the user may have disabled both Wi-Fi and mobile data access. Thus, to improve user experience before getting connected, you may check the connection:

```java
ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
if (networkInfo != null && networkInfo.isConnected()) {
    // the connection is available
} else {
    // the connection is not available
}
```

## Guided Practice: What is Retrofit? (10 mins)

[Retrofit](http://square.github.io/retrofit/) is a library from Square that gives us a REST HTTP client for Android and Java. The library provides a powerful framework for authenticating and interacting with APIs and sending network requests with [OkHttp](http://square.github.io/okhttp/), another Square library. You can think of Retrofit as wrapping OkHttp. You'll definitely use Retrofit when developing to download JSON and XML data from APIs.

> Check:  Ask students what Retrofit is used for in their own words.

## Setup (5 mins): 

You can follow along as we code a basic Retrofit example using the GitHub API.

In addition to adding the above permissions to your Manifest, you'll need to add the following dependencies to your gradle:

```gradle
    compile 'com.squareup.retrofit2:retrofit:2.0.2'
    compile 'com.squareup.retrofit2:converter-gson:2.0.2'
```

This compiles the additional libraries we need.

## Making a POJO model (10 mins)

We'll want to make a model class (in this case, a User model based on the user information from the GitHub API). There are a couple of ways to do this. The first way is the manual approach, which requires you to make good use of the [Gson](https://github.com/google/gson) library. The second approach auto-generating the Java classes you need by capturing the JSON output and using [jsonschema2pojo](http://www.jsonschema2pojo.org/). It's good to know the manual Gson way, but often in practice using jsonschema2pojo is very efficient. We'll be using this second method for this lesson.

On the jsonschema2pojo site, select the option of *JSON* for Source Type and Annotation style as *GSON*. Then, enter in the API URL to transform (for example, https://api.github.com/users/jeanmw):

```json
{
  "login": "jeanmw",
  "id": 11809238,
  "avatar_url": "https://avatars.githubusercontent.com/u/11809238?v=3",
  "gravatar_id": "",
  "url": "https://api.github.com/users/jeanmw",
  "html_url": "https://github.com/jeanmw",
  "followers_url": "https://api.github.com/users/jeanmw/followers",
  "following_url": "https://api.github.com/users/jeanmw/following{/other_user}",
  "gists_url": "https://api.github.com/users/jeanmw/gists{/gist_id}",
  "starred_url": "https://api.github.com/users/jeanmw/starred{/owner}{/repo}",
  "subscriptions_url": "https://api.github.com/users/jeanmw/subscriptions",
  "organizations_url": "https://api.github.com/users/jeanmw/orgs",
  "repos_url": "https://api.github.com/users/jeanmw/repos",
  "events_url": "https://api.github.com/users/jeanmw/events{/privacy}",
  "received_events_url": "https://api.github.com/users/jeanmw/received_events",
  "type": "User",
  "site_admin": false,
  "name": "Jean Weatherwax",
  "company": "General Assembly",
  "blog": null,
  "location": "San Francisco",
  "email": null,
  "hireable": null,
  "bio": null,
  "public_repos": 4,
  "public_gists": 0,
  "followers": 0,
  "following": 0,
  "created_at": "2015-04-05T19:02:55Z",
  "updated_at": "2016-07-12T23:02:00Z"
}
```

You can then create a class in your project 'User' and paste the resultant methods from the converter that will generate a model for our GitHub User. You can put this class in a *models* folder for organization purposes.

## Guided Practice: Making a service interface and using it with Retrofit (40 mins)

The next step is to create an interface to use with our endpoint and Retrofit. 

```java

package com.example.jeanweatherwax.retrofitgithubexample;


import com.example.jeanweatherwax.retrofitgithubexample.models.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface GitHubService {
    @GET("/users/{username}")
    Call<User> getUser(@Path("username") String username);
}
```

This interface:

1. Gets the endpoint (we'll append this to our base URL in the MainActivity)
2. Creates a Call Object that takes in a User model type, with the path specified to be a username String input. We'll fill in this input with actual user input in the MainActivity.

After you call `connect()`, you can get an InputStream of the data by calling `getInputStream()`. An InputStream is a readable source of bytes. Once you get an InputStream, it's common to decode or convert it into a target data type.


Next, in the MainActivity, we'll use this interface. First, create a variable to store our base API URL:


```java
private static String baseUrl = "https://api.github.com/";
```

Then, we create a Retrofit service in our MainActivity, and add GsonConverter for json parsing:

```java
Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
```

Next, we get an instance of our service and get Call<User> :

```java
		GitHubService service = retrofit.create(GitHubService.class);

        Call<User> call = service.getUser(userName);
```

And then, we execute the call we've created and perform updates to our textviews to display data. 

```java
            call.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {

                    try {

                        String userName = response.body().getName();

                        String location = response.body().getLocation();

                        String company = response.body().getCompany();

                        nameView.setText("GitHub Name: " + userName);
                        locationView.setText("location: " + location);
                        companyView.setText("Company: " + company);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {

                }
            });
```

This whole block is wrapped in a method *getUserInfo()* that we will call when a button is clicked. We also make sure to check for network connectivity as previously mentioned:

```java
protected void getUserInfo(String userName) {
        Log.d("MainActivity: ", "getting github info");

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            GitHubService service = retrofit.create(GitHubService.class);

            Call<User> call = service.getUser(userName);

            call.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {

                    try {

                        String userName = response.body().getName();

                        String location = response.body().getLocation();

                        String company = response.body().getCompany();

                        nameView.setText("GitHub Name: " + userName);
                        locationView.setText("location: " + location);
                        companyView.setText("Company: " + company);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {

                }
            });

        } else {
            Toast.makeText(MainActivity.this, "No network connection", Toast.LENGTH_LONG).show();
        }

    }
```

>Instructor note: explain each step in the above


## Conclusion (5 mins)

- What is the main use case of Retrofit in Android?
- What permissions should be added to the Manifest file to establish network connection?
- What are the steps to use Retrofit to display API data in your Android app?
