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

//STEP 7:this token is necessary for any API call! user is optional
        mAccessToken = getIntent().getStringExtra(LoginActivity.INTENT_KEY_TOKEN);// TODO assign value;


        // TODO: Make the getImage() api call using accessToken

        // TODO: In onResponse() you can use Picasso to load image from url into mImage ImageView

        // TODO: Use image url and pass to picasso like so.
                //STEP 8:
        instaGramService.getImage(mAccessToken).enqueue(new retrofit2.Callback<RecentMedia>() {
            @Override
            public void onResponse(retrofit2.Call<RecentMedia> call, retrofit2.Response<RecentMedia> response) {
                RecentMedia recentMedia = response.body();
                // STEP 9: follow the path until you can get the URL
                //getData()[0] returns the first thing... only 1 image
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

        // HINT: Use RecentMedia model to get image url


    private void setupApiService(){
        // Create retrofit instance with a base url and GsonConverter
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(InstagramAppData.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        instaGramService = retrofit.create(InstaGramService.class);
    }
}
