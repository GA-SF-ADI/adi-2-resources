package gg.patrickcummins.networkinglab;

import gg.patrickcummins.networkinglab.models.Weather;
import gg.patrickcummins.networkinglab.models.WeatherObject;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by patrickcummins on 7/20/16.
 */

public interface WeatherService {
    @GET("weather")
    Call<WeatherObject> getWeather(
            @Query("q") String cityname,
            @Query("APPID") String appId
    );
}
