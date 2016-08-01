package ly.generalassemb.serviceexample;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class FourthActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int NOTIFICATION_ID = 1;

    private String downloadUrl = null;
    boolean mShowingPlayButton = true;
    BoundExampleService boundExampleService;
    boolean isBound;

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            BoundExampleService.MyLocalBinder binder = (BoundExampleService.MyLocalBinder) service;
            boundExampleService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button notificationButton = (Button) findViewById(R.id.notification_button);
        notificationButton.setOnClickListener(this);
        Button styleInboxButton = (Button) findViewById(R.id.inbox_style__button);
        notificationButton.setOnClickListener(this);
        styleInboxButton.setOnClickListener(this);
        final ImageButton playPauseButton = (ImageButton) findViewById(R.id.playPauseButton);
        ImageButton stopButton = (ImageButton) findViewById(R.id.stopButton);
        final Intent intent = new Intent(FourthActivity.this, BoundExampleService.class);
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        playPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (boundExampleService == null) {
                    bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
                }


                // When clicked, start the service with a play or pause intent
                if (mShowingPlayButton) {

                    boundExampleService.startMusic();

                } else {
                    boundExampleService.pauseMusic();
                }
                // Set the button's image to the play or pause image. This can able be done with an if-else

                playPauseButton.setImageResource(mShowingPlayButton ?
                        android.R.drawable.ic_media_pause : android.R.drawable.ic_media_play);

                // This is toggling the boolean from true to false, and vice versa
                mShowingPlayButton = !mShowingPlayButton;
            }
        });


        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // When clicked, start the service with a stop intent
                if (isBound) {
                    unbindService(mServiceConnection);
                }
                Log.d("Main Activity", "" + boundExampleService);
                // Set the play button's image to the play image. Reset the state.

                playPauseButton.setImageResource(android.R.drawable.ic_media_play);
                mShowingPlayButton = true;
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.notification_button:
                showNormalNotification();
                break;
            case R.id.inbox_style__button:
                shownInboxStyleNotification();
                break;
        }
    }

    private void showNormalNotification() {
        Intent intent = new Intent(this,FourthActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent,0);
        NotificationCompat.Builder mbuilder = new NotificationCompat.Builder(this);
        mbuilder.setSmallIcon(R.mipmap.ic_launcher);
        mbuilder.setContentTitle("Audrey");
        mbuilder.setContentText("Audrey");
        mbuilder.setContentIntent(pendingIntent);
        mbuilder.setAutoCancel(true);
        mbuilder.setPriority(Notification.PRIORITY_LOW);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    notificationManager.notify(NOTIFICATION_ID, mbuilder.build());
    }

    private void shownInboxStyleNotification() {
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        inboxStyle.setBigContentTitle("Inbox Notification");
        inboxStyle.addLine("line 1");
        inboxStyle.addLine("line 2");
        inboxStyle.setSummaryText("more than 2");

        Intent intent = new Intent(this, SecondActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,(int)System.currentTimeMillis(), intent, 0);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher);
        mBuilder.setContentTitle("Audrey again");
        mBuilder.setContentText("Audrey again again");
        mBuilder.setContentIntent(pendingIntent);
        mBuilder.setAutoCancel(true);
        mBuilder.setPriority(Notification.PRIORITY_LOW);
        mBuilder.setStyle(inboxStyle);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID, mBuilder.build());
    }
}

