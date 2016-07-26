package ly.generalassemb.serviceexample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.text.LoginFilter;
import android.util.Log;

/**
 * Created by nolbertoarroyo on 7/25/16.
 */
public class CustomService extends Service {

    public static String TAG = "customService";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG,"Service Created");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"Service Destroyed");
    }
}
