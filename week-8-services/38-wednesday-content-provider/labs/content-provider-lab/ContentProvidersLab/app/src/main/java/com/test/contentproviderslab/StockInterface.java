package com.test.contentproviderslab;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by audreyeso on 7/28/16.
 */
public interface StockInterface {

    //String stockUrl = "http://dev.markitondemand.com/MODApis/Api/v2/Quote/json?symbol="+symbol;
    @GET("Quote/json?symbol=\"+symbol")
    Call<Stock> getQuote(@Path("symbol") String id);
}
