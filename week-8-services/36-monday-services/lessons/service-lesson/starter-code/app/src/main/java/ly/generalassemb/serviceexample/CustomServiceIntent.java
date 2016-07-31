package ly.generalassemb.serviceexample;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by audreyeso on 7/30/16.
 */
public class CustomServiceIntent extends IntentService {

    private final String TAG = "CustomIntentService";

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public CustomServiceIntent(String name) {
        super(name);
        Log.i(TAG, "CustomService Constructor");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        try {
            Thread.sleep(5000);
        }catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "CustomService destroyed");
    }
}
