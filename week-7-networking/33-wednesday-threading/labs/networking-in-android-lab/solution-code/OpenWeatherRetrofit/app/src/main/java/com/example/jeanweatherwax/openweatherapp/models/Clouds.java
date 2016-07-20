package com.example.jeanweatherwax.openweatherapp.models;

import com.google.gson.annotations.Expose;

/**
 * Created by jeanweatherwax on 7/13/16.
 */
public class Clouds {


    @Expose
    private Integer all;

    /**
     *
     * @return
     * The all
     */
    public Integer getAll() {
        return all;
    }

    /**
     *
     * @param all
     * The all
     */
    public void setAll(Integer all) {
        this.all = all;
    }
}
