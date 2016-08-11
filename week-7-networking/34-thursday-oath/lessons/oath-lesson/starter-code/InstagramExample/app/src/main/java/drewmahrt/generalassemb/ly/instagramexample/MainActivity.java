package drewmahrt.generalassemb.ly.instagramexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import drewmahrt.generalassemb.ly.instagramexample.models.RecentMedia;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
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

        // TODO assign value;
        mAccessToken = getIntent().getStringExtra(LoginActivity.INTENT_KEY_TOKEN);
        String userId = getIntent().getStringExtra(LoginActivity.INTENT_KEY_ID);

        Call<RecentMedia> call = instaGramService.getImage(mAccessToken);
        // TODO: Make the getImage() api call using accessToken

        call.enqueue(new Callback<RecentMedia>() {
            @Override
            public void onResponse(Call<RecentMedia> call, Response<RecentMedia> response) {
                String url = response.body().getData()[0].getImages().getStandard_resolution().getUrl();

                // TODO: In onResponse() you can use Picasso to load image from url into mImage ImageView
                Picasso.with(MainActivity.this).load(url).into(mImage);
                // TODO: Use image url and pass to picasso like so.
            }

            @Override
            public void onFailure(Call<RecentMedia> call, Throwable t) {

            }
        });




        // HINT: Use RecentMedia model to get image url

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
