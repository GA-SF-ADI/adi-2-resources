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
import retrofit2.Callback;
import retrofit2.Response;
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
        mWebView.loadUrl( "https://www.instagram.com/developer/authentication/putmyindividualvalueshere" + "&redirect_uri=" + InstagramAppData.CALLBACK_URL + "&response_type=code");
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
                /* Include AUTH_CODE_KEY */,
                /* Include CALLBACK_URL */,
                /* Include code */);

        // TODO: run the call on a worker thread asynchronously
        call.enqueue(new Callback<AuthenticationResponse>() {
            @Override
            public void onResponse(Call<AuthenticationResponse> call, Response<AuthenticationResponse> response) {

            }

            @Override
            public void onFailure(Call<AuthenticationResponse> call, Throwable t) {

            }
        });

        // TODO: On sucessful response, get AuthenticationResponse object from the response object
        // TODO: Get your user from AuthenticationResponse
        AuthenticationResponse authenticationResponse = response.body();
        InstaGramUser user = authentificationResponse.getUser();

        // TODO: Put extras into intents using provided keys at top of file and launch MainActivity

    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.putExtra(INTENT_KEY_TOKEN, authenticationResponse.getToken());
        intent.putExtra(INTENT_KEY_ID, user.getID());
        startActivity(intent);
        finish();
    }
}
