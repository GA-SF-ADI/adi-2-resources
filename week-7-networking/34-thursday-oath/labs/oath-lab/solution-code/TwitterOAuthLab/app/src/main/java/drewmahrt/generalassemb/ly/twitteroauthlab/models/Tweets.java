package drewmahrt.generalassemb.ly.twitteroauthlab.models;

import java.util.ArrayList;

/**
 * Created by drewmahrt on 4/22/16.
 */
public class Tweets {
    ArrayList<Tweet> tweets = new ArrayList<>();

    public Tweets(){}

    public Tweets(ArrayList<Tweet> tweets){
        this.tweets = tweets;
    }

    public ArrayList<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(ArrayList<Tweet> tweets) {
        this.tweets = tweets;
    }
}
