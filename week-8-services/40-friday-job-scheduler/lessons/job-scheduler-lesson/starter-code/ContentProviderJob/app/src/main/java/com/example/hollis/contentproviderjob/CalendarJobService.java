package com.example.hollis.contentproviderjob;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import java.util.Calendar;

/**
 * Created by hollis on 7/14/16.
 */
public class CalendarJobService extends JobService {
    @Override
    public boolean onStartJob(JobParameters params) {
        Uri uri = CalendarContract.Events.CONTENT_URI;
        String[] columns = new String[]{ //columns I want to return
                CalendarContract.Events._ID,
                CalendarContract.Events.CALENDAR_ID, // Calendars._ID
                CalendarContract.Events.ORGANIZER,
                CalendarContract.Events.TITLE,
                CalendarContract.Events.EVENT_LOCATION,
                CalendarContract.Events.DESCRIPTION,
                CalendarContract.Events.DTSTART,
                CalendarContract.Events.DTEND,
        };

        Cursor cursor = getContentResolver().query(
                uri,
                columns,
                null,
                null,
                CalendarContract.Events.DTSTART + "ASC"
        );
        Log.d("Service", "checking the calendar");
        if(cursor.moveToFirst()){
            String stringTimeToStart = cursor.getString(cursor.getColumnIndex(CalendarContract.Events.DTSTART));
            long timeToStart = Long.valueOf(stringTimeToStart);
            long curTime = Calendar.getInstance().getTimeInMillis();
            Log.d("Serivce", timeToStart + "< = time to thing");
            Log.d("Service", curTime + " <- current time");
            Log.d("Service", "differince is " + (timeToStart -Calendar.getInstance().getTimeInMillis()));
            if(timeToStart-curTime<3600000){
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext());
                builder.setSmallIcon(android.R.mipmap.sym_def_app_icon);
                builder.setContentTitle("You have an event coming up!");
                builder.setContentText(cursor.getString(cursor.getColumnIndex(CalendarContract.Events.TITLE)));
                builder.setAutoCancel(true);
                Notification notification = builder.build();
                notificationManager.notify(0, notification);
            }
        }
        cursor.close();

        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}
