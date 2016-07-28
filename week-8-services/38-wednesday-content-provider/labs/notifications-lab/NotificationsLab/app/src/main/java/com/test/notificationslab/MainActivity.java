package com.test.notificationslab;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;

public class MainActivity extends AppCompatActivity {
    public static int BIG_PIC_NOTIFICATION_ID = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            // the connection is available
            setNetworkAvailableNotification();

        } else {
            // the connection is not available
            setNoNetworkNotification();
        }
    }

    public void setNetworkAvailableNotification(){
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,(int) System.currentTimeMillis(), intent, 0);

        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
        bigPictureStyle.bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.network_available)).build();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("Network AvailableNotification");
        builder.setContentText("Connected to network");
        builder.setAutoCancel(true);
        builder.setStyle(bigPictureStyle);
        builder.setContentIntent(pendingIntent);
        builder.setPriority(Notification.PRIORITY_MAX);

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
// NOTIFICATION_ID allows you to update the notification later on.
        mNotificationManager.notify(BIG_PIC_NOTIFICATION_ID, builder.build());

    }
    public void setNoNetworkNotification(){
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,(int) System.currentTimeMillis(), intent, 0);

        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
        bigPictureStyle.bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.no_network)).build();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("No network Notification");
        builder.setContentText("your network is disconnected");
        builder.setAutoCancel(false);
        builder.setStyle(bigPictureStyle);
        builder.setContentIntent(pendingIntent);
        builder.setPriority(Notification.PRIORITY_MAX);

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
// NOTIFICATION_ID allows you to update the notification later on.
        mNotificationManager.notify(BIG_PIC_NOTIFICATION_ID, builder.build());

    }
}
