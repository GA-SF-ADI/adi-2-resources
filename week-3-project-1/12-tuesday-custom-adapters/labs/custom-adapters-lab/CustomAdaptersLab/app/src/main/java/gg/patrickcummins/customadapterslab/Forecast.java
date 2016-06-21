package gg.patrickcummins.customadapterslab;

import android.graphics.drawable.Drawable;

/**
 * Created by patrickcummins on 6/21/16.
 */

public class Forecast {
    private String high;
    private String low;
    private String weatherPrediction;
    private Drawable drawable;

    public Forecast(String high, String low, String weatherPrediction) {
        this.high = high;
        this.low = low;
        this.weatherPrediction = weatherPrediction;

    }

    public String getHigh() {
        return high;
    }

    public String getLow() {
        return low;
    }

    public String getWeatherPrediction() {
        return weatherPrediction;
    }
}
