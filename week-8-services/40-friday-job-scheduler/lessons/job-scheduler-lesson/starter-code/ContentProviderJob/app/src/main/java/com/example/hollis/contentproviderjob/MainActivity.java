package com.example.hollis.contentproviderjob;

import android.Manifest;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DateFormat;

public class MainActivity extends AppCompatActivity {

  private static final String TAG = "MainActivity";
    public static final int JOB_ID = 14;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      Button startButton = (Button) findViewById(R.id.activity_main_start_service_button);
      startButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_CALENDAR) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(MainActivity.this, new  String[]{Manifest.permission.READ_CALENDAR}, 1);
              }
              JobScheduler jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);

              JobInfo jobInfo = new JobInfo.Builder(JOB_ID, new ComponentName(getPackageName(), CalendarJobService.class.getName())).setPeriodic(5000).build();
              jobScheduler.schedule(jobInfo);
          }
      });
  }
}
