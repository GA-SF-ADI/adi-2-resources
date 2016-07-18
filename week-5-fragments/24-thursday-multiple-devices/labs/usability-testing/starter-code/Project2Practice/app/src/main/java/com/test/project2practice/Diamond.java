package com.test.project2practice;

/**
 * Created by audreyeso on 7/7/16.
 */
public class Diamond {
    private String giaReportNum;
    private String style;
    private String cost;
    private String caratWeight;

    public Diamond(String giaReportNum, String style, String cost) {
        this.giaReportNum = giaReportNum;
        this.style = giaReportNum;
        this.cost = cost;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getGiaReportNum() {
        return giaReportNum;
    }

    public void setGiaReportNum(String giaReportNum) {
        this.giaReportNum = giaReportNum;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }


    public String getCaratWeight() {
        return caratWeight;
    }

    public void setCaratWeight(String caratWeight) {
        this.caratWeight = caratWeight;
    }
}
