package com.example.hollis.notificationjobscheduler;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.support.v4.app.NotificationCompat;


/**
 * Created by hollis on 7/13/16.
 */
@TargetApi(21)
public class NotificationJobService extends JobService {
    @Override
    public boolean onStartJob(JobParameters params) {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher);
        mBuilder.setContentTitle("Notification Alert, Click Me!");
        mBuilder.setContentText("Hi, This is Android Notification Detail!");
        mBuilder.setPriority(Notification.PRIORITY_MAX);
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(1, mBuilder.build());
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}
