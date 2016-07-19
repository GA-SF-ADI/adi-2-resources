package com.test.apilab;

/**
 * Created by audreyeso on 7/19/16.
 */
public class Array {
    public Photos getPhotos() {
        return photos;
    }

    public void setPhotos(Photos photos) {
        this.photos = photos;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    private Photos photos;
    private String stat;
}
