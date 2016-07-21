package com.example.hollis.notificationjobscheduler;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.support.v4.app.NotificationCompat;


/**
 * Created by hollis on 7/13/16.
 */
@TargetApi(21)
public class NotificationJobService extends JobService {
    @Override
    public boolean onStartJob(JobParameters params) {
        //TODO: CREATE YOUR NOTIFICATION!
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}
