package drewmahrt.generalassemb.ly.instagramexample.models;

import com.google.gson.annotations.SerializedName;

/**
 * Class modeling Instagram users
 *
 * Created by alex on 7/19/16.
 */
public class InstaGramUser {
    private String id;
    private String username;

    @SerializedName("full_name")
    private String fullName;

    @SerializedName("profile_picture")
    private String profilePicture;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}
