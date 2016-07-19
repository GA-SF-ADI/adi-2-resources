package drewmahrt.generalassemb.ly.instagramexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private String mAccessToken;
    private ImageView mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImage = (ImageView)findViewById(R.id.image);

        mAccessToken = getIntent().getStringExtra(LoginActivity.INTENT_KEY_TOKEN);

        final OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.instagram.com/v1/users/self/media/recent/?access_token="+mAccessToken)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                String responseBody = response.body().string();
                try {
                    JSONObject results = new JSONObject(responseBody);
                    JSONArray dataArray = results.getJSONArray("data");
                    JSONObject dataObject = dataArray.getJSONObject(0);
                    Log.d(LoginActivity.class.getName(),"Data Object: "+dataObject.toString());
                    JSONObject imagesObject = dataObject.getJSONObject("images");
                    JSONObject standardResObject = imagesObject.getJSONObject("standard_resolution");
                    final String imageUrl = standardResObject.getString("url");
                    Log.d(LoginActivity.class.getName(),"Image URL: "+standardResObject.getString("url"));

                    MainActivity.this.runOnUiThread(new Runnable(){
                        @Override
                        public void run() {
                            Picasso.with(MainActivity.this).load(imageUrl).into(mImage);                        }
                    });

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
