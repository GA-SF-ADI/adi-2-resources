package com.test.bookscanner2.models;

/**
 * Created by audreyeso on 8/6/16.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("ISBN")
    @Expose
    private ISBN iSBN;
    private String myTitle;

    /**
     *
     * @return
     * The iSBN9780980200447
     */
    public ISBN getiSBN() {
        return iSBN;
    }

    /**
     *
     * @param iSBN
     * The ISBN:9780980200447
     */
    public void setiSBN(ISBN iSBN) {
        this.iSBN = iSBN;
    }


    public String getMyTitle(String isbn) {
        return myTitle;
    }

    public void setMyTitle(String myTitle) {
        this.myTitle = myTitle;
    }
}
