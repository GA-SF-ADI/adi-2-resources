package generalassembly.yuliyakaleda.calendarprovider;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends Activity {
    private static final String TAG = "ga.contentproviders";
    private CursorAdapter mCursorAdapter;
    private ListView lv;
    private static final int READ_CALENDAR_PERMISSIONS_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Read Calendar
        getPermissionToReadCalendar();
    }

    // Called when the user is performing an action which requires the app to read the
    // user's calendar
    @TargetApi(23)
    public void getPermissionToReadCalendar() {
        // 1) Use the support library version ContextCompat.checkSelfPermission(...) to avoid
        // checking the build version since Context.checkSelfPermission(...) is only available
        // in Marshmallow
        // 2) Always check for permission (even if permission has already been granted)
        // since the user can revoke permissions at any time through Settings
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CALENDAR)
                != PackageManager.PERMISSION_GRANTED) {

            // The permission is NOT already granted.
            // Check if the user has been asked about this permission already and denied
            // it. If so, we want to give more explanation about why the permission is needed.
            if (shouldShowRequestPermissionRationale(
                    Manifest.permission.READ_CALENDAR)) {
                // Show our own UI to explain to the user why we need to read the calendar
                // before actually requesting the permission and showing the default UI
            }

            // Fire off an async request to actually get the permission
            // This will show the standard permission request dialog UI
            requestPermissions(new String[]{Manifest.permission.READ_CALENDAR},
                    READ_CALENDAR_PERMISSIONS_REQUEST);
        } else if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CALENDAR)
                == PackageManager.PERMISSION_GRANTED) {
            //Permission granted. List calendar events.

            //set up views
            setUpViews();
        }
    }

    // Callback with the request from calling requestPermissions(...)
    @TargetApi(23)
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[],
                                           @NonNull int[] grantResults) {
        // Make sure it's our original request
        if (requestCode == READ_CALENDAR_PERMISSIONS_REQUEST) {
            if (grantResults.length == 1 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Read Calendar permission granted", Toast.LENGTH_SHORT).show();
                //set up views
                setUpViews();

            } else {
                // showRationale = false if user clicks Never Ask Again, otherwise true
                boolean showRationale = shouldShowRequestPermissionRationale(Manifest.permission.READ_CONTACTS);

                if (showRationale) {
                    // do something here to handle degraded mode
                } else {
                    Toast.makeText(this, "Read Calendar permission denied", Toast.LENGTH_SHORT).show();
                }
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }


    public void setUpViews() {

        //set up listview and click listener for items with mCursorAdapter
        lv = (ListView) findViewById(R.id.lv);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Cursor cursor = mCursorAdapter.getCursor();
                cursor.move(i);

                //create an AlertDialog when it is clicked to confirm deletion
                final long eventId = cursor.getLong(cursor.getColumnIndex(CalendarContract.Events._ID));
                //call deleteEvent
                deleteEvent(eventId);
                //I've included the alertdialog code since we haven't explicitly taught it.
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Are you sure you want to delete this event?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                deleteEvent(eventId);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        //call fetchEvents
        fetchEvents();
    }

    public void fetchEvents() {
        //define uri
        Uri uri = CalendarContract.Events.CONTENT_URI;
        // and get columns.
        String[] columns = {
                CalendarContract.Events._ID,
                CalendarContract.Events.TITLE,
                CalendarContract.Events.DTSTART
        };

        try {
            //get Cursor called cursor and query
            Cursor cursor = getContentResolver().query(uri,columns,null,null,CalendarContract.Events.DTSTART);;


            if (mCursorAdapter == null) {
                mCursorAdapter = new CursorAdapter(this, cursor, 0) {
                    @Override
                    public View newView(Context context, Cursor cursor, ViewGroup parent) {
                        return LayoutInflater.from(context).inflate(R.layout.list_item_layout, parent, false);
                    }

                    //bind the views
                    @Override
                    public void bindView(View view, Context context, Cursor cursor) {
                        TextView textView1 = (TextView)view.findViewById(R.id.textView1);
                        TextView textView2 = (TextView)view.findViewById(R.id.textView2);

                        String title = cursor.getString(cursor.getColumnIndex(CalendarContract.Events.TITLE));
                        long startTime = cursor.getLong(cursor.getColumnIndex(CalendarContract.Events.DTSTART));
                        String s = String.valueOf(startTime);

                        textView1.setText(cursor.getString(cursor.getColumnIndex(title)));
                        textView2.setText(cursor.getString(cursor.getColumnIndex(s)));

                    }
                };

                lv.setAdapter(mCursorAdapter);
            } else {
                mCursorAdapter.swapCursor(cursor);
            }

            //catch the exception if there is no permissions
        } catch (SecurityException e) {
            Log.d("MainActivity", Log.getStackTraceString(e));
        }


    }


    //user getContentResolver to delete an event. You will need to get a uri instance
    public void deleteEvent(long id) {

    }
}


