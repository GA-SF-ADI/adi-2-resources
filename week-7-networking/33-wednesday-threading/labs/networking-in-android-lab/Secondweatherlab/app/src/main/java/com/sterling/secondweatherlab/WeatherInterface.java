package com.sterling.secondweatherlab;

/**
 * Created by sterlinggerritz on 7/20/16.
 */
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface WeatherInterface {
    @GET("/data/2.5/weather?appid=ab1df022c5908ce3ff1da044de64862c")
    Call<Example> getLocation(@Query("q") String location);
}
