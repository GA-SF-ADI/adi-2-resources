package drewmahrt.generalassemb.ly.twitteroauthlab;

import java.util.List;

import drewmahrt.generalassemb.ly.twitteroauthlab.models.BearerToken;
import drewmahrt.generalassemb.ly.twitteroauthlab.models.Tweet;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by drewmahrt on 4/22/16.
 */
public interface TwitterApiEndpointInterface {
    @POST("oauth2/token")
    Call<ResponseBody> authorizeApplication(@Header("Authorization") String authorization,
                                            @Header("Content-Type") String contentType,
                                            @Query("grant_type") String grantType);

    @GET("1.1/statuses/user_timeline.json")
    Call<ResponseBody> userTimeline(@Header("Authorization") String authorization, @Query("screen_name") String screenName, @Query("count") int count);
}

