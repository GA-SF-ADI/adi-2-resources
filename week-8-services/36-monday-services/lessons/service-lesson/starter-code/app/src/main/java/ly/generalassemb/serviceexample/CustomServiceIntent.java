package ly.generalassemb.serviceexample;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by audreyeso on 7/30/16.
 */
public class CustomServiceIntent extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public CustomServiceIntent(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }
}
