package com.example.michaeljeffress.networkinglab;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by michaeljeffress on 7/20/16.
 */
public interface OpenWeatherMapInterface {
    @GET("/data/2.5/weather")
    Call<Example> getCity(@Query("q") String city,
                       @Query("appid") String appId);
}
