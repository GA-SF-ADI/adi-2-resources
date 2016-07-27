package com.test.notificationslab;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final int NOTIFICATION_ID_WIFI = 0;
    private static final int NOTIFICATION_ID_NO_WIFI = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void setWifiConnectedNotification() {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
        bigPictureStyle.bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.pinkwifi)).build();

        mBuilder.setStyle(bigPictureStyle);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher);
        mBuilder.setContentTitle("Notification Alert, Click Me!");
        mBuilder.setContentText("Hi, You are connected to the wifi!");
        mBuilder.setAutoCancel(true);
        mBuilder.setContentIntent(pIntent);

        Notification notification = mBuilder.build();
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(NOTIFICATION_ID_WIFI, mBuilder.build());
    }

    public void setWifiDisconnectedNotification() {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
        bigPictureStyle.bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.pinkwifi)).build();

        mBuilder.setStyle(bigPictureStyle);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher);
        mBuilder.setContentTitle("Notification Alert, Click Me!");
        mBuilder.setContentText("Hi, You are connected to the wifi!");
        mBuilder.setAutoCancel(true);
        mBuilder.setContentIntent(pIntent);

        Notification notification = mBuilder.build();
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(NOTIFICATION_ID_NO_WIFI, mBuilder.build());
    }
}
