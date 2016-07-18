package com.example.hollis.gson_example;

import java.util.concurrent.locks.Condition;


import com.google.gson.annotations.SerializedName;


/**
 * Created by michaeljeffress on 7/18/16.
 */
public class Item {
    private String title;
    private long lat;
    @SerializedName("long")
    private long longitude;
    private String link;
    private String pubDate;
    private Condition condition;
    private Forecast forecast;
    private String description;
    private Guid guid;


}
