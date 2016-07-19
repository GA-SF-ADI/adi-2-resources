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
        mWebView.loadUrl(/* Include your url here */);
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
                /* TODO Include CLIENT_SECRET */,
                /* TODO Include CLIENT_ID */,
                /* TODO Include AUTH_CODE_KEY */,
                /* TODO Include CALLBACK_URL */,
                /* TODO Include code */);

        // TODO: make the api call on seprate worker thread

        // TODO: From response grab token and user id and send them as intent extras when launching MainActivity

    }
}
