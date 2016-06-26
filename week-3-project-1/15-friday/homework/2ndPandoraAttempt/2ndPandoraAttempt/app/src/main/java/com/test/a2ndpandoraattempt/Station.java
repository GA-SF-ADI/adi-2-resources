package com.test.a2ndpandoraattempt;

import android.graphics.Bitmap;
import android.media.Image;

/**
 * Created by LangstonSmith on 6/25/16.
 */
public class Station {

    String stationName;

    Integer yearWhenListenedTo;

    Bitmap albumCover;


    public Station(String stationName, Integer yearWhenListenedTo, Bitmap albumCover) {
        this.stationName = stationName;
        this.yearWhenListenedTo = yearWhenListenedTo;
        this.albumCover = albumCover;
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

    public Bitmap getAlbumCover() {
        return albumCover;
    }

    public void setAlbumCover(Bitmap albumCover) {
        this.albumCover = albumCover;
    }
}
