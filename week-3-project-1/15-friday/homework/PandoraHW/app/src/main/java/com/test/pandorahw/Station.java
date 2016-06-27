package com.test.pandorahw;

import android.widget.ImageView;

/**
 * Created by nolbertoarroyo on 6/26/16.
 */
public class Station {
    private String name;
    private String songs;
    private String lastListened;
    private int stationImage;


    public  Station(String name, String lastListened,int stationImage){
        this.name = name;
        this.lastListened=lastListened;
        this.stationImage = stationImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSongs() {
        return songs;
    }

    public void setSongs(String songs) {
        this.songs = songs;
    }

    public String getLastListened() {
        return lastListened;
    }

    public void setLastListened(String lastListened) {
        this.lastListened = lastListened;
    }

    public int getStationImage(int music) {
        return stationImage;
    }

    public void setStationImage(int stationImage) {
        this.stationImage = stationImage;
    }


}
