package ly.generalassemb.serviceexample;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by nolbertoarroyo on 7/25/16.
 */
public class CustomIntentService extends IntentService{
    public static String TAG = "CustomIntentService";
    public CustomIntentService() {
        super("customIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG,"create customService");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG,"onStartCommand customService");
        return super.onStartCommand(intent, flags, startId);

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"stop customService");
    }
}
