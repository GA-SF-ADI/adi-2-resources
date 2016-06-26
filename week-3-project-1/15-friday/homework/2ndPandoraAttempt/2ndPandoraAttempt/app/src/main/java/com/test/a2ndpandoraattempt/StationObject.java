package com.test.a2ndpandoraattempt;

/**
 * Created by LangstonSmith on 6/25/16.
 */
public class StationObject {

    String stationName;

    Integer yearWhenListenedTo;


    public StationObject(String stationName, Integer yearWhenListenedTo) {
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
