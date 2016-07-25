package ly.generalassemb.serviceexample;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by Jon Kim on 7/25/16.
 */
public class CustomIntentService extends IntentService {
    public static String INTENT_KEY_SERVICE = "key";
    public CustomIntentService() {
        super("CustomIntentService");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }
}
