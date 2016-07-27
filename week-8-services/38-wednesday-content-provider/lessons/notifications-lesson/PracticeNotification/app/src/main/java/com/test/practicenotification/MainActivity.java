package com.test.practicenotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int NOTIFICATION_ID = 12345;
    private static final int NOTIFICATION_ID_1 = 1;

    private Button button;
    private Button bigPicture;
    private Button bigText;
    private Button inboxStyle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        bigPicture = (Button) findViewById(R.id.button_big_picture);
        bigText = (Button) findViewById(R.id.button_big_text);
        inboxStyle = (Button) findViewById(R.id.button_inbox_style);

        button.setOnClickListener(this);
        inboxStyle.setOnClickListener(this);


        bigPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBigPictureNotification();
            }

        });

    }



    @Override
    public void onClick(View view) {
        setRegularNotification();

    }


    public void setRegularNotification() {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        // use System.currentTimeMillis() to have a unique ID for the pending intent
        PendingIntent pIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher);
        mBuilder.setContentTitle("Notification Alert, Click Me!");
        mBuilder.setContentText("Hi, This is Android Notification Detail!");
        mBuilder.setAutoCancel(true);
        mBuilder.setContentIntent(pIntent);

        Notification notification = mBuilder.build();
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        // NOTIFICATION_ID allows you to update the notification later on.
        mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
    }

    public void setBigPictureNotification() {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
        bigPictureStyle.bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.birthday)).build();

        mBuilder.setStyle(bigPictureStyle);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher);
        mBuilder.setContentTitle("Notification Alert, Click Me!");
        mBuilder.setContentText("Hi, This is Android with a Big Picture!");
        mBuilder.setAutoCancel(true);
        mBuilder.setContentIntent(pIntent);

        Notification notification = mBuilder.build();
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(NOTIFICATION_ID_1, mBuilder.build());
    }


//    public void setBigTextNotification() {
//        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//        PendingIntent pIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);
//
//        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
//        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
//        bigPictureStyle.bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.birthday)).build();
//
//        mBuilder.setStyle(bigPictureStyle);
//        mBuilder.setSmallIcon(R.mipmap.ic_launcher);
//        mBuilder.setContentTitle("Notification Alert, Click Me!");
//        mBuilder.setContentText("Hi, This is Android with a Big Picture!");
//        mBuilder.setAutoCancel(true);
//        mBuilder.setContentIntent(pIntent);
//
//        Notification notification = mBuilder.build();
//        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        mNotificationManager.notify(NOTIFICATION_ID_1, mBuilder.build());
//    }
}
