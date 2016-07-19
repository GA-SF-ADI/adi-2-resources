package drewmahrt.generalassemb.ly.instagramexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import drewmahrt.generalassemb.ly.instagramexample.models.AuthenticationResponse;
import drewmahrt.generalassemb.ly.instagramexample.models.InstaGramUser;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = LoginActivity.class.getSimpleName();
    public static final String INTENT_KEY_TOKEN = "accessToken";
    public static final String INTENT_KEY_ID = "userId";

    private WebView mWebView;
    private InstaGramService instaGramService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // setup the API service using retrofit
        setupInstaGramApiService();

        mWebView = (WebView) findViewById(R.id.webview);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if(url.contains("code=")){
                    System.out.println(url);
                    int index = url.indexOf("=");
                    System.out.println(url.substring(index+1));
                    String code = url.substring(index+1);
                    getAccessToken(code);
                    return true;
                }else {
                    return false;
                }
            }
        });
        mWebView.loadUrl("https://instagram.com/oauth/authorize/?client_id="+ InstagramAppData.CLIENT_ID +"&redirect_uri="+ InstagramAppData.CALLBACK_URL  +"&response_type=code&scope=public_content");
    }

    private void setupInstaGramApiService(){
        // Create retrofit instance with a base url and GsonConverter
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(InstagramAppData.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        instaGramService = retrofit.create(InstaGramService.class);
    }

    private void getAccessToken(String code){
        Log.d(LoginActivity.class.getName(),"Trying to get access token");

        // Pass in the form data for this post call
        Call<AuthenticationResponse> call = instaGramService.postAccessCode(
                InstagramAppData.CLIENT_SECRET,
                InstagramAppData.CLIENT_ID,
                InstagramAppData.AUTH_CODE_KEY,
                InstagramAppData.CALLBACK_URL,
                code);

        call.enqueue(new retrofit2.Callback<AuthenticationResponse>() {
            @Override
            public void onResponse(retrofit2.Call<AuthenticationResponse> call, retrofit2.Response<AuthenticationResponse> response) {
                // grab the two objects from the response
                AuthenticationResponse authenticationResponse = response.body();
                InstaGramUser user = authenticationResponse.getUser();

                Log.i(TAG, "onResponse: successful access for " + user.getFullName());

                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                intent.putExtra(INTENT_KEY_TOKEN,authenticationResponse.getToken());
                intent.putExtra(INTENT_KEY_ID, user.getId());
                startActivity(intent);
            }

            @Override
            public void onFailure(retrofit2.Call<AuthenticationResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: getting access token");
            }
        });
    }
}
