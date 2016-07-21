package com.example.hollis.notificationjobscheduler;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.support.v4.app.NotificationCompat;

import java.util.Calendar;


/**
 * Created by hollis on 7/13/16.
 */
@TargetApi(21)
public class NotificationJobService extends JobService {
    @Override
    public boolean onStartJob(JobParameters params) {
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext());
        builder.setSmallIcon(android.R.mipmap.sym_def_app_icon);
        builder.setContentTitle("BREAKING NEWS");
        builder.setContentText("read all about it" + Calendar.getInstance().getTime());
        builder.setAutoCancel(true);
        Notification notification = builder.build();
        notificationManager.notify(0, notification);
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}
