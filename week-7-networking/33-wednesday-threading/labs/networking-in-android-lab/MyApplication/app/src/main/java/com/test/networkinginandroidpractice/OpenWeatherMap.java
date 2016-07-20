package com.test.networkinginandroidpractice;

/**
 * Created by audreyeso on 7/20/16.
 */
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
public interface OpenWeatherMap {

    @GET("/weather/{weather}")
    Call<Weather>getWeather(@Path("weather")String weather);
}
