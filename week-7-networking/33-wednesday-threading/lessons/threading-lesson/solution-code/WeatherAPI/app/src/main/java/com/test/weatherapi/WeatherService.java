package com.test.weatherapi;

import com.test.weatherapi.Models.BigWeather;
import com.test.weatherapi.Models.Weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Jon Kim on 7/20/16.
 */
public interface WeatherService {
    @GET("/data/2.5/weather/")
    Call<BigWeather> getWeather(
            @Query("q") String cityName,
            @Query("appid") String apiKey
    );

}
