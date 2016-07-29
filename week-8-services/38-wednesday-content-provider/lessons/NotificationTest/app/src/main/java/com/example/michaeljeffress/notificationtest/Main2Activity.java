package com.example.michaeljeffress.notificationtest;

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

public class Main2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
                inboxStyle.setBigContentTitle("Inbox Notification");
                inboxStyle.addLine("Message 1.");
                inboxStyle.addLine("Message 2.");
                inboxStyle.addLine("Message 3.");
                inboxStyle.addLine("Message 4.");
                inboxStyle.addLine("Message 5.");
                inboxStyle.setSummaryText("+2 more");

                Intent intent = new Intent(Main2Activity.this, Main2Activity.class);
                // use System.currentTimeMillis() to have a unique ID for the pending intent
                PendingIntent pIntent = PendingIntent.getActivity(Main2Activity.this, (int) System.currentTimeMillis(), intent, 0);

                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(Main2Activity.this);
                mBuilder.setSmallIcon(R.mipmap.ic_launcher);
                mBuilder.setContentTitle("Notification Alert, Click Me!");
                mBuilder.setContentText("Hi, This is Android Notification Detail!");
                mBuilder.setContentIntent(pIntent);
                mBuilder.setPriority(Notification.PRIORITY_MAX);
                mBuilder.setStyle(inboxStyle);

                NotificationManager mNotificationManager =
                        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                // NOTIFICATION_ID allows you to update the notification later on.
                mNotificationManager.notify(125, mBuilder.build());
            }

        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
                bigPictureStyle.bigPicture(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher)).build();

                Intent intent = new Intent(Main2Activity.this, Main2Activity.class);
                // use System.currentTimeMillis() to have a unique ID for the pending intent
                PendingIntent pIntent = PendingIntent.getActivity(Main2Activity.this, (int) System.currentTimeMillis(), intent, 0);

                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(Main2Activity.this);
                mBuilder.setSmallIcon(R.mipmap.ic_launcher);
                mBuilder.setContentTitle("Notification Alert, Click Me!");
                mBuilder.setContentText("Hi, This is Android Notification Detail!");
                mBuilder.setContentIntent(pIntent);
                mBuilder.setPriority(Notification.PRIORITY_MAX);
                mBuilder.setStyle(bigPictureStyle);

                NotificationManager mNotificationManager =
                        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                // NOTIFICATION_ID allows you to update the notification later on.
                mNotificationManager.notify(125, mBuilder.build());
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();
                bigText.bigText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
                bigText.setBigContentTitle("Big Text Notification");
                bigText.setSummaryText("By: Author of Lorem ipsum");

                Intent intent = new Intent(Main2Activity.this, Main2Activity.class);
                // use System.currentTimeMillis() to have a unique ID for the pending intent
                PendingIntent pIntent = PendingIntent.getActivity(Main2Activity.this, (int) System.currentTimeMillis(), intent, 0);

                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(Main2Activity.this);
                mBuilder.setSmallIcon(R.mipmap.ic_launcher);
                mBuilder.setContentTitle("Notification Alert, Click Me!");
                mBuilder.setContentText("Hi, This is Android Notification Detail!");
                mBuilder.setContentIntent(pIntent);
                mBuilder.setPriority(Notification.PRIORITY_MAX);
                mBuilder.setStyle(bigText);

                NotificationManager mNotificationManager =
                        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                // NOTIFICATION_ID allows you to update the notification later on.
                mNotificationManager.notify(125, mBuilder.build());
            }
        });


    }
}
