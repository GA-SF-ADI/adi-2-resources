package drewmahrt.generalassemb.ly.instagramexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import drewmahrt.generalassemb.ly.instagramexample.models.RecentMedia;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private String mAccessToken;
    private ImageView mImage;

    private InstaGramService instaGramService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupApiService();

        mImage = (ImageView)findViewById(R.id.image);
        mAccessToken = getIntent().getStringExtra(LoginActivity.INTENT_KEY_TOKEN);
        
        instaGramService.getImage(mAccessToken).enqueue(new retrofit2.Callback<RecentMedia>() {
            @Override
            public void onResponse(retrofit2.Call<RecentMedia> call, retrofit2.Response<RecentMedia> response) {
                RecentMedia recentMedia = response.body();

                final String imageUrl = recentMedia.getData()[0].getImages().getStandard_resolution().getUrl();

                Log.i(TAG, "onResponse imageUrl: " + imageUrl);
                MainActivity.this.runOnUiThread(new Runnable(){
                    @Override
                    public void run() {
                        Picasso.with(MainActivity.this).load(imageUrl).into(mImage);                        }
                });
            }

            @Override
            public void onFailure(retrofit2.Call<RecentMedia> call, Throwable t) {

            }
        });
    }

    private void setupApiService(){
        // Create retrofit instance with a base url and GsonConverter
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(InstagramAppData.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        instaGramService = retrofit.create(InstaGramService.class);
    }
}
