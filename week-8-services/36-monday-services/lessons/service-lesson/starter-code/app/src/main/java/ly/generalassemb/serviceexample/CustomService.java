package ly.generalassemb.serviceexample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by audreyeso on 7/30/16.
 */
public class CustomService extends Service {
    private static final String TAG = "CustomService";
    private static Thread thread;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "Service Created");

        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        });

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "Service Created and should do some work");

        //String fromMain = intent.getStringExtra(MainActivity.INTENT_KEY_SERVICE);
        //return super.onStartCommand(intent, flags, startId);
        thread.run();

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
