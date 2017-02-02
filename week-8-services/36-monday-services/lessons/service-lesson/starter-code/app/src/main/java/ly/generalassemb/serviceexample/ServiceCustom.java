package ly.generalassemb.serviceexample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by audreyeso on 7/25/16.
 */
public class ServiceCustom extends Service {
    private static final String TAG = "CustomService";

    private Thread thread;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onCreate() {
        super.onCreate();

        //the runnable creates a new thread
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // sleep the thread for 10 seconds then we will show toast
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        });
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "Service Started, should do some work");

        // run the thread
        thread.run();

        // toast after the "work" was finished
        Toast.makeText(getApplicationContext(), "Service work finished", Toast.LENGTH_SHORT).show();

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Service Destroyed");
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_SHORT).show();
    }
}
