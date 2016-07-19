package drewmahrt.generalassemb.ly.instagramexample.models;

import com.google.gson.annotations.SerializedName;

/**
 * Model for Instagram Authentication response
 *
 * Created by alex on 7/19/16.
 */
public class AuthenticationResponse {
    @SerializedName("access_token")
    private String token;

    private InstaGramUser user;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public InstaGramUser getUser() {
        return user;
    }

    public void setUser(InstaGramUser user) {
        this.user = user;
    }
}
