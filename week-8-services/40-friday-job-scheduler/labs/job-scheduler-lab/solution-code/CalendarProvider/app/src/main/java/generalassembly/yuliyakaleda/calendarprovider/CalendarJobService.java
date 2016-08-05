package generalassembly.yuliyakaleda.calendarprovider;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import java.util.Calendar;

/**
 * Created by hollis on 7/28/16.
 */
@TargetApi(21)
public class CalendarJobService extends JobService {
    private final String TAG = "JobService";

    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        CalendarEvent latestEvent = fetchLatest();
        if(latestEvent!= null) {
            Log.d(TAG, "onStartJob: " + latestEvent.getTitle());
            if(latestEvent.getDtStart() - Calendar.getInstance().getTimeInMillis() < 10000) {
                Notification notificationCompat = new NotificationCompat.Builder(getApplicationContext())
                        .setContentTitle(latestEvent.getTitle()).setSmallIcon(R.mipmap.ic_launcher).build();
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(1, notificationCompat);
            }
        }
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    public CalendarEvent fetchLatest() {
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
                 "? > 0",
                new String[]{CalendarContract.Events.DTSTART},
                CalendarContract.Events.DTSTART + " ASC"
        );
        CalendarEvent calendarEvent;
        if(cursor.moveToFirst()){
             calendarEvent = new CalendarEvent(cursor.getString(cursor.getColumnIndex(CalendarContract.Events.ORGANIZER)),
            cursor.getString(cursor.getColumnIndex(CalendarContract.Events.TITLE)),
            cursor.getString(cursor.getColumnIndex(CalendarContract.Events.EVENT_LOCATION)),
            cursor.getString(cursor.getColumnIndex(CalendarContract.Events.DESCRIPTION)),
            cursor.getLong(cursor.getColumnIndex(CalendarContract.Events.DTSTART)),
            cursor.getLong(cursor.getColumnIndex(CalendarContract.Events.DTEND)));
        }else{
            Log.d(TAG, "fetchLatest: none found");
            calendarEvent=null;
        }
        return calendarEvent;
    }
}
