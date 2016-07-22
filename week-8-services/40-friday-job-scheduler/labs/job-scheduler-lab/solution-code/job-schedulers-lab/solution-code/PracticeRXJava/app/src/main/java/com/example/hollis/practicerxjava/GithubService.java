package com.example.hollis.practicerxjava;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by hollis on 7/17/16.
 */
public interface GithubService {

    @GET("users")
    Observable<User[]> getResults(@Query("since") int offset);

}
