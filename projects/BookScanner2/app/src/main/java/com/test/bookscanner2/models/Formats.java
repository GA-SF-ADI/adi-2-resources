package com.test.bookscanner2.models;

/**
 * Created by audreyeso on 8/6/16.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Formats {

    @SerializedName("djvu")
    @Expose
    private Djvu djvu;

    /**
     *
     * @return
     * The djvu
     */
    public Djvu getDjvu() {
        return djvu;
    }

    /**
     *
     * @param djvu
     * The djvu
     */
    public void setDjvu(Djvu djvu) {
        this.djvu = djvu;
    }

}