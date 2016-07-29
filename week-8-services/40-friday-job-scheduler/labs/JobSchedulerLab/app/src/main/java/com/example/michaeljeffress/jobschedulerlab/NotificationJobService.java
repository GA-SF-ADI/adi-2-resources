package com.example.michaeljeffress.jobschedulerlab;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.database.Cursor;
import android.icu.util.Calendar;
import android.net.Uri;
import android.provider.CalendarContract;
import android.support.v4.app.NotificationCompat;

/**
 * Created by michaeljeffress on 7/29/16.
 */
public class NotificationJobService extends JobService {

    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        Uri uri = CalendarContract.Events.CONTENT_URI;
        String[] columns = new String[]{
                CalendarContract.Events._ID,
                CalendarContract.Events.CALENDAR_ID,
                CalendarContract.Events.ORGANIZER,
                CalendarContract.Events.TITLE,
                CalendarContract.Events.EVENT_LOCATION,
                CalendarContract.Events.DESCRIPTION,
                CalendarContract.Events.DTSTART,
                CalendarContract.Events.DTEND,
        };

        try {
            Cursor cursor = getContentResolver().query(
                    uri,
                    columns,
                    null, // positive events only
                    null,
                    CalendarContract.Events.DTSTART + " ASC"
            );


            cursor.moveToFirst();
            String str = cursor.getString(cursor.getColumnIndex(CalendarContract.Events.TITLE));
            long dtstart = cursor.getLong(cursor.getColumnIndex(CalendarContract.Events.DTSTART));

            if (dtstart - java.util.Calendar.getInstance().getTimeInMillis() < 10000) {
                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
                mBuilder.setSmallIcon(R.mipmap.ic_launcher);
                mBuilder.setContentTitle(str);
                mBuilder.setContentText("Hi, This is Android Notification Detail!");
                mBuilder.setPriority(Notification.PRIORITY_MAX);
                NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                mNotificationManager.notify(1, mBuilder.build());
            }return false;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
