package com.test.retrofitlab;

/**
 * Created by nolbertoarroyo on 7/20/16.
 */
import com.test.retrofitlab.Example;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WeatherService {
    @GET("data/2.5/weather")

        Call<Example>getWeather(@Query("q")String name,
                                @Query("appid") String appid);
    }


