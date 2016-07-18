package drewmahrt.generalassemb.ly.twitteroauthlab;

import android.database.DataSetObserver;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import drewmahrt.generalassemb.ly.twitteroauthlab.models.BearerToken;
import drewmahrt.generalassemb.ly.twitteroauthlab.models.Tweet;
import drewmahrt.generalassemb.ly.twitteroauthlab.models.Tweets;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = MainActivity.class.getName();

    private String mAccessToken;

    private Button searchButton;
    private EditText editText;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchButton = (Button)findViewById(R.id.search_button);
        editText = (EditText)findViewById(R.id.search_edit_text);
        listView = (ListView)findViewById(R.id.tweets_list);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTweets();
            }
        });

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(TwitterAppData.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        TwitterApiEndpointInterface twitterApi = retrofit.create(TwitterApiEndpointInterface.class);

        String plainString = TwitterAppData.CONSUMER_KEY+":"+TwitterAppData.CONSUMER_SECRET;
        byte[] data = new byte[0];
        try {
            data = plainString.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String base64 = Base64.encodeToString(data, Base64.NO_WRAP);

        Log.d(TAG,"Ready to make bearer req: "+base64);

        Call<ResponseBody> call = twitterApi.authorizeApplication("Basic "+base64,"application/x-www-form-urlencoded;charset=UTF-8","client_credentials");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.d(TAG,"Call completed!");
                try {
                    String responseString = response.body().string();
                    Log.d(TAG,"Token: "+responseString);
                    JSONObject object = new JSONObject(responseString);
                    mAccessToken = object.getString("access_token");
                    Log.d(TAG,"Access Token: "+mAccessToken);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d(TAG,"Bearer token call failed");
                Log.d(TAG,t.getMessage().toString());
            }
        });
    }

    private void getTweets(){
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(TwitterAppData.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        TwitterApiEndpointInterface twitterApi = retrofit.create(TwitterApiEndpointInterface.class);

        String searchName = editText.getText().toString();
        Call<ResponseBody> call = twitterApi.userTimeline("Bearer "+mAccessToken,searchName,20);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.d(TAG,"Call completed!");
                try {
                    String responseBody = response.body().string();
                    Log.d(TAG,"Response: "+responseBody);
                    JSONArray tweets = new JSONArray(responseBody);

                    ArrayList<Tweet> tweetList = new ArrayList<Tweet>();

                    for (int i = 0; i < tweets.length(); i++) {
                        JSONObject object = tweets.getJSONObject(i);
                        String text = object.getString("text");
                        String date = object.getString("created_at");
                        Tweet tweet  = new Tweet();
                        tweet.setText(text);
                        tweet.setCreatedAt(date);
                        tweetList.add(tweet);
                    }

                    TweetAdapter adapter = new TweetAdapter(MainActivity.this,tweetList);
                    listView.setAdapter(adapter);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d(TAG,"Get tweet call failed");
                Log.d(TAG,t.getMessage().toString());
            }
        });

    }
}
