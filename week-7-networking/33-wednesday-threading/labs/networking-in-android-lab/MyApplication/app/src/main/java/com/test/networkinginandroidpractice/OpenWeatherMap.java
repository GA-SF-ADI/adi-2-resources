package com.test.networkinginandroidpractice;

/**
 * Created by audreyeso on 7/20/16.
 */
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenWeatherMap {

    @GET("/data/2.5/weather")
    Call<Example>getWeather(@Query("q") String cityName,
                            @Query("APPID") String apiKey);
}
