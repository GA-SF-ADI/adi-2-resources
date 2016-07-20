package com.test.weather;

/**
 * Created by LangstonSmith on 7/20/16.
 */

import com.test.weather.models.Forecast;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetroInterface {


        @GET("data/2.5/weather")
        Call<Forecast> getForecast(
                @Query("q") String cityName,
                @Query("appid") String appId);



}
