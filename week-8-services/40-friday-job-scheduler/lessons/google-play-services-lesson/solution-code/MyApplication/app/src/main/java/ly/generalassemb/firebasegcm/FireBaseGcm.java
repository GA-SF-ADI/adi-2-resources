package ly.generalassemb.firebasegcm;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by alex on 7/28/16.
 */
public class FireBaseGcm extends FirebaseMessagingService {
    private static final int NOTIF_ID = 9999;

    private static final String TAG = "FireBaseGcm";
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        Log.i(TAG, "onMessageReceived: " + remoteMessage.getFrom());;
        Log.i(TAG, "onMessageReceived: title " + remoteMessage.getNotification().getTitle());
        Log.i(TAG, "onMessageReceived: body " + remoteMessage.getNotification().getBody());

        String title = "Message from the Cloud!";
        String content = remoteMessage.getNotification().getBody();

        Util.builNotification(title, content, R.mipmap.ic_launcher, NOTIF_ID, getApplicationContext());
    }
}
