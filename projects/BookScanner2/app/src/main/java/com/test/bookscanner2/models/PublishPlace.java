package com.test.bookscanner2.models;

/**
 * Created by audreyeso on 8/6/16.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class PublishPlace {

    @SerializedName("name")
    @Expose
    private String name;

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

}