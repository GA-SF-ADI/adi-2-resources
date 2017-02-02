package com.test.bookscanner2.models;

/**
 * Created by audreyeso on 8/6/16.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("ISBN:9780980200447")
    @Expose
    private ISBN9780980200447 iSBN9780980200447;

    /**
     *
     * @return
     * The iSBN9780980200447
     */
    public ISBN9780980200447 getISBN9780980200447() {
        return iSBN9780980200447;
    }

    /**
     *
     * @param iSBN9780980200447
     * The ISBN:9780980200447
     */
    public void setISBN9780980200447(ISBN9780980200447 iSBN9780980200447) {
        this.iSBN9780980200447 = iSBN9780980200447;
    }

}
