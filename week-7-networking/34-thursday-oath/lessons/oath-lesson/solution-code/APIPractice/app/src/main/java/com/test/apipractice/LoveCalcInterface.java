package com.test.apipractice;

import com.test.apipractice.models.Model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by audreyeso on 7/23/16.
 */
public interface LoveCalcInterface {

    @GET("/getPercentage/")
    Call<Model> getLoveCalc(@Query("fname")String fname,
                            @Query("sname")String sname);

}
