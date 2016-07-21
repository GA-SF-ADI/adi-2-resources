package generalassembly.yuliyakaleda.calendarprovider;

import android.app.Activity;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
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

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    lv = (ListView) findViewById(R.id.lv);

    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Cursor cursor = mCursorAdapter.getCursor();
        cursor.move(position);

        final long eventId = cursor.getLong(cursor.getColumnIndex(CalendarContract.Events._ID));
        deleteEvent(eventId);
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

    fetchEvents();
  }

  public void fetchEvents() {
    Uri uri = CalendarContract.Events.CONTENT_URI;
    String [] columns = new String[] { //columns I want to return
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
            CalendarContract.Events.DTSTART + " DESC"
    );

    if(mCursorAdapter == null) {
      mCursorAdapter = new CursorAdapter(this, cursor, 0) {
        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
          return LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_2, parent, false);
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {
          TextView text1 = (TextView) view.findViewById(android.R.id.text1);
          TextView text2 = (TextView) view.findViewById(android.R.id.text2);

          String title = cursor.getString(cursor.getColumnIndex(CalendarContract.Events.TITLE));
          long startTime = cursor.getLong(cursor.getColumnIndex(CalendarContract.Events.DTSTART));

          text1.setText(title);
          text2.setText(DateFormat.getDateInstance(DateFormat.SHORT).format(startTime));
        }
      };

      lv.setAdapter(mCursorAdapter);
    }else{
      mCursorAdapter.swapCursor(cursor);
    }
  }


  public void deleteEvent(long id) {
    Uri uri = ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, id);
    Log.d(MainActivity.class.getName(),"Deleting uri: "+uri.toString());
    getContentResolver().delete(uri, null, null);
    fetchEvents();
  }
}


