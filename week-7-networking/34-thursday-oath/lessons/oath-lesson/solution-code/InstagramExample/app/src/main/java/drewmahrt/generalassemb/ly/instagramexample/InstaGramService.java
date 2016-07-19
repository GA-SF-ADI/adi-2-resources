package drewmahrt.generalassemb.ly.instagramexample;

import drewmahrt.generalassemb.ly.instagramexample.models.AuthenticationResponse;
import drewmahrt.generalassemb.ly.instagramexample.models.RecentMedia;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Interface for Instagram API's
 *
 * Created by alex on 7/19/16.
 */
public interface InstaGramService {

    /**
     * FormUrlEncoded Annocation is used for POST calls that want
     * to include certain fields in the post call
     *
     * @param secret CLIENT secret key
     * @param id CLIENT id
     * @param grantType grant type
     * @param redirect redirect uri
     * @param code authorization code
     * @return
     */
    @FormUrlEncoded
    @POST("oauth/access_token")
    Call<AuthenticationResponse> postAccessCode(
            @Field("client_secret") String secret,
            @Field("client_id") String id,
            @Field("grant_type") String grantType,
            @Field("redirect_uri") String redirect,
            @Field("code") String code);

    /**
     * Return the recent media
     *
     * @param token
     * @return
     */
    @GET("v1/users/self/media/recent/")
    Call<RecentMedia> getImage(@Query("access_token") String token);
}
