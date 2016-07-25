package ly.generalassemb.serviceexample;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by audreyeso on 7/25/16.
 */
public class HelloIntentService extends IntentService {

    private final String TAG = "CustomIntentService";

    public HelloIntentService() {
        super("HelloIntentService name");
        Log.i(TAG, "CustomService Constructor");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        Log.i(TAG, "CustomService begin work work");
        try {
            Thread.sleep(10000);
            Log.i(TAG, "CustomService end work");
        } catch (InterruptedException e) {
            // Restore interrupt status.
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "CustomService destroyed destroyed!!!");
    }
}
