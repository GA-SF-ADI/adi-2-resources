package com.test.a2ndpandoraattempt;

import android.graphics.Bitmap;
import android.media.Image;

/**
 * Created by LangstonSmith on 6/25/16.
 */
public class Station {

    String stationName;

    Integer yearWhenListenedTo;



    public Station(String stationName, Integer yearWhenListenedTo) {
        this.stationName = stationName;
        this.yearWhenListenedTo = yearWhenListenedTo;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public Integer getYearWhenListenedTo() {
        return yearWhenListenedTo;
    }

    public void setYearWhenListenedTo(Integer yearWhenListenedTo) {
        this.yearWhenListenedTo = yearWhenListenedTo;
    }


}
