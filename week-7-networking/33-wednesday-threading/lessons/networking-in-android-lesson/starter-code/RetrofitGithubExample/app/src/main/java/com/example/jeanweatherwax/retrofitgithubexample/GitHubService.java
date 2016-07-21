package com.example.jeanweatherwax.retrofitgithubexample;


import com.example.jeanweatherwax.retrofitgithubexample.models.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface GitHubService {
    @GET("/users/{username}")
    Call<User> getUser(@Path("username") String username);
    //use @GET to get the path to the users: /users/{username}
    //then create a Call of type User to get the path, taking an input of the username

}
