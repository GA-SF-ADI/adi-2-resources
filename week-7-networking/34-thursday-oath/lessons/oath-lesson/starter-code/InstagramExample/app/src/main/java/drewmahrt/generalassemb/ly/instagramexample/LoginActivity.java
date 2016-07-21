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
                if (url.contains("code=")) {
                    System.out.println(url);
                    int index = url.indexOf("=");
                    System.out.println(url.substring(index + 1));
                    String code = url.substring(index + 1);
                    getAccessToken(code);
                    return true;
                } else {
                    return false;
                }
            }
        });
        //STEP 1: the url is taken from https://www.instagram.com/developer/authentication/
        //this is what users are directed to at first
        // https://api.instagram.com/oauth/authorize/?client_id=CLIENT-ID&redirect_uri=REDIRECT-URI&response_type=code
        //this is what insta gives us, but you have to change it to match your own client id and callback url...
        // you have these variables already
        //CALL back URL is the redirect url

        mWebView.loadUrl("https://instagram.com/oauth/authorize/?client_id=" +
                InstagramAppData.CLIENT_ID + "&redirect_uri=" + InstagramAppData.CALLBACK_URL
                + "&response_type=code&scope=public_content");
    }

    private void setupInstaGramApiService() {
        // Create retrofit instance with a base url and GsonConverter
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(InstagramAppData.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        instaGramService = retrofit.create(InstaGramService.class);
    }

    //STEP 3: get access token, this method needs the secret, id, codekey, url, and code
    // this can be found on the API doc as step three: request the access token
    // you must have all of these things because instagram requires it...
    private void getAccessToken(String code) {
        Log.d(LoginActivity.class.getName(), "Trying to get access token");

        // Pass in the form data for this post call.. they all live inside Instagram app data
        //instagram requires it...
        Call<AuthenticationResponse> call = instaGramService.postAccessCode(
                InstagramAppData.CLIENT_SECRET,
                InstagramAppData.CLIENT_ID,
                InstagramAppData.AUTH_CODE_KEY,
                InstagramAppData.CALLBACK_URL,
                code);

        // TODO: run the call on a worker thread asynchronously

        // TODO: On sucessful response, get AuthenticationResponse object from the response object
        // TODO: Get your user from AuthenticationResponse

        //STEP 4: make a call to retrofit and we want ASYNCHRONOUS so we use enqueue
        //make a call back
        //now it will run on a seperate thread
        // this method is called when it hears a response back
        //.enqueue can only be used with retrofit! you can't use it with your own database
        //onResponse runs on the UI thread
        call.enqueue(new retrofit2.Callback<AuthenticationResponse>() {
            @Override
            public void onResponse(retrofit2.Call<AuthenticationResponse> call, retrofit2.Response<AuthenticationResponse> response) {
                // grab the two objects from the response
                //STEP 5: use AuthenticationResponse object to get response
                //get the user if you want to
                AuthenticationResponse authenticationResponse = response.body();
                InstaGramUser user = authenticationResponse.getUser();

                Log.i(TAG, "onResponse: successful access for " + user.getFullName());
        //STEP 6: Create a new intent and pass in extras
                //have keys... id and token that are going to be sent to the next activity
                //you could do shared preferences if you want to save it
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                //passed to the next activity
                intent.putExtra(INTENT_KEY_TOKEN, authenticationResponse.getToken());
                intent.putExtra(INTENT_KEY_ID, user.getId());
                startActivity(intent);
                finish();
            }

            @Override
            public void onFailure(retrofit2.Call<AuthenticationResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: getting access token");
            }
        });

        // TODO: Put extras into intents using provided keys at top of file and launch MainActivity

    }
}
