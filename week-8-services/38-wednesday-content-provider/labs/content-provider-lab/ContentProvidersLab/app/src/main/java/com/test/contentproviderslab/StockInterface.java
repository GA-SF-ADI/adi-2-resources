package com.test.contentproviderslab;

import retrofit2.http.GET;
/**
 * Created by audreyeso on 7/28/16.
 */
public interface StockInterface {

    //String stockUrl = "http://dev.markitondemand.com/MODApis/Api/v2/Quote/json?symbol="+symbol;
    @GET("Quote/json?symbol=\"+symbol")
    Call<Stock> getQuote(@Path("symbol") String id);
}
