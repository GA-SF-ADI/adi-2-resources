package com.example.kitty.networkinglab;

import com.example.kitty.networkinglab.Models.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface WeatherInterface {
    @GET("/data/2.5/weather?appid=9712164f7130c1a000002dd0edb8135e")
    Call<Example> getLocation(@Query("q") String location);
}
