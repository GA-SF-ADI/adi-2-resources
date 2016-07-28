package com.test.buttonnotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;
    Button button2;
    Button button3;
    Button button4;
    public static int NOTIFICATION_ID = 1;
    public static int BIG_TEXT_NOTIFICATION_ID = 2;
    public static int BIG_PIC_NOTIFICATION_ID = 3;
    public static int INBOX_NOTIFICATION_ID = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setRegularNotification();
                button.setBackgroundColor(Color.BLUE);


            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBigTextNotification();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInboxNotificaton();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBigPictureNotification();
            }
        });
    }


    public void setRegularNotification() {

        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        PendingIntent pendIntent = PendingIntent.getActivity(MainActivity.this, (int) System.currentTimeMillis(), intent, 0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("Notification Alert, Click Me!");
        builder.setContentText("This is my notification");
        builder.setAutoCancel(true);
        builder.setContentIntent(pendIntent);
        builder.setPriority(Notification.PRIORITY_MAX);

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
// NOTIFICATION_ID allows you to update the notification later on.
        mNotificationManager.notify(NOTIFICATION_ID, builder.build());


    }

    public void setBigTextNotification() {

        NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();
        bigText.bigText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        bigText.setBigContentTitle("Big Text Notification");
        bigText.setSummaryText("By: Author of Lorem ipsum");

        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
        builder.setSmallIcon(R.mipmap.ic_launcher);

        builder.setStyle(bigText);
        builder.setContentTitle("Big Text Notification");
        builder.setContentText("This is my notification");
        builder.setAutoCancel(true);
        builder.setPriority(Notification.PRIORITY_MAX);
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
// NOTIFICATION_ID allows you to update the notification later on.
        mNotificationManager.notify(BIG_TEXT_NOTIFICATION_ID, builder.build());


    }

    public void setInboxNotificaton() {
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        inboxStyle.setBigContentTitle("Inbox Notification");
        inboxStyle.addLine("Message 1.");
        inboxStyle.addLine("Message 2.");
        inboxStyle.addLine("Message 3.");
        inboxStyle.addLine("Message 4.");
        inboxStyle.addLine("Message 5.");
        inboxStyle.setSummaryText("+2 more");


        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("Inbox Notification");
        builder.setContentText("This is my notification");
        builder.setAutoCancel(true);
        builder.setStyle(inboxStyle);
        builder.setPriority(Notification.PRIORITY_MAX);

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
// NOTIFICATION_ID allows you to update the notification later on.
        mNotificationManager.notify(INBOX_NOTIFICATION_ID, builder.build());

    }
    public void setBigPictureNotification(){

        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
        bigPictureStyle.bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.doggie)).build();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("Picture Notification");
        builder.setContentText("This is my notification");
        builder.setAutoCancel(true);
        builder.setStyle(bigPictureStyle);
        builder.setPriority(Notification.PRIORITY_MAX);

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
// NOTIFICATION_ID allows you to update the notification later on.
        mNotificationManager.notify(BIG_PIC_NOTIFICATION_ID, builder.build());

    }


}


