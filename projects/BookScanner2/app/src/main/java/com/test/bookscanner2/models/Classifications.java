package com.test.bookscanner2.models;

/**
 * Created by audreyeso on 8/6/16.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Classifications {

    @SerializedName("dewey_decimal_class")
    @Expose
    private List<String> deweyDecimalClass = new ArrayList<String>();
    @SerializedName("lc_classifications")
    @Expose
    private List<String> lcClassifications = new ArrayList<String>();

    /**
     *
     * @return
     * The deweyDecimalClass
     */
    public List<String> getDeweyDecimalClass() {
        return deweyDecimalClass;
    }

    /**
     *
     * @param deweyDecimalClass
     * The dewey_decimal_class
     */
    public void setDeweyDecimalClass(List<String> deweyDecimalClass) {
        this.deweyDecimalClass = deweyDecimalClass;
    }

    /**
     *
     * @return
     * The lcClassifications
     */
    public List<String> getLcClassifications() {
        return lcClassifications;
    }

    /**
     *
     * @param lcClassifications
     * The lc_classifications
     */
    public void setLcClassifications(List<String> lcClassifications) {
        this.lcClassifications = lcClassifications;
    }

}