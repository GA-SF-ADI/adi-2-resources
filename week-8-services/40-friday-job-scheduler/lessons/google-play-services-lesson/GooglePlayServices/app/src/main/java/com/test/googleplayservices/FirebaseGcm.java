package com.test.googleplayservices;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by audreyeso on 7/29/16.
 */

public class FirebaseGcm extends FirebaseMessagingService {

    private static final String TAG = "FireBaseGcm";
    private static final int NOTIF_ID = 1;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        Log.i(TAG, "onMessageReceived: here is the message: " + remoteMessage.getFrom());;
        Log.i(TAG, "FireBase push notification " + remoteMessage.getNotification().getBody());

        String title = "Message from Audrey!";
        String content = remoteMessage.getNotification().getBody();

       // Utiliies.builNotification(title, content, R.mipmap.ic_launcher, NOTIF_ID, getApplicationContext());

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);

        mBuilder.setSmallIcon(R.mipmap.ic_launcher);
        mBuilder.setContentTitle("Notification Alert, Click Me!" + remoteMessage.getFrom());
        mBuilder.setContentText("Hi" + remoteMessage.getNotification().getBody());

        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        // NOTIFICATION_ID allows you to update the notification later on.
        mNotificationManager.notify(NOTIF_ID, mBuilder.build());

    }

}
