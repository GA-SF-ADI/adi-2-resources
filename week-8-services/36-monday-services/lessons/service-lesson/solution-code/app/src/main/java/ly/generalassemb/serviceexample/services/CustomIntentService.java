package ly.generalassemb.serviceexample.services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by alex on 4/13/16.
 */
public class CustomIntentService extends IntentService {
    private final String TAG = "CustomIntentService";

    /**
     * A constructor is required, and must call the super IntentService(String)
     * constructor with a name for the worker thread.
     */
    public CustomIntentService(){
        super("CustomIntentService");
        Log.i(TAG, "CustomService Constructor");
    }

    /**
     * The IntentService calls this method from the default worker thread with
     * the intent that started the service. When this method returns, IntentService
     * stops the service, as appropriate.
     */
    @Override
    protected void onHandleIntent(Intent intent) {
        // Normally we would do some work here, like download a file.
        // For our sample, we just sleep for 10 seconds.
        Log.i(TAG, "CustomService begin work");
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
        Log.i(TAG, "CustomService destroyed");
    }
}
