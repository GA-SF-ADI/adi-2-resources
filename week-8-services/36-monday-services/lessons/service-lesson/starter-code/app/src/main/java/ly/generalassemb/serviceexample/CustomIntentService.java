package ly.generalassemb.serviceexample;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by michaeljeffress on 7/25/16.
 */
public class CustomIntentService extends IntentService {

    public CustomIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }

//    @Override
//    public void onCreate() {
//        super.onCreate();
//    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
