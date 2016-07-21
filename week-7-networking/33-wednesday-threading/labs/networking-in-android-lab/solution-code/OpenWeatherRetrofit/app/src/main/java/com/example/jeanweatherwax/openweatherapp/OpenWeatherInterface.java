package com.example.jeanweatherwax.openweatherapp;

import com.example.jeanweatherwax.openweatherapp.models.Model;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


/**
 * Created by jeanweatherwax on 7/13/16.
 */
public interface OpenWeatherInterface {

    @GET("/data/2.5/weather")  //
    Call<Model> getWeather(@Query("q") String city,
                           @Query("units") String units,
                           @Query("appid") String appid);

}
