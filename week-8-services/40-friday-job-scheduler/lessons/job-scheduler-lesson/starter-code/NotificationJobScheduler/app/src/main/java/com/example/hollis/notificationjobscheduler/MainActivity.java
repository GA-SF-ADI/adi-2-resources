package com.example.hollis.notificationjobscheduler;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.lang.annotation.Target;

public class MainActivity extends AppCompatActivity {
    Button startJobButton, stopJobButton;
    public static final int JOB_INFO = 12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();
        setOnClickListeners();



    }
    public void setViews(){
        startJobButton = (Button) findViewById(R.id.activity_main_start_job_button);
        stopJobButton = (Button) findViewById(R.id.activity_main_stop_job_button);
    }

    public void setOnClickListeners(){
        startJobButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //TODO: CREATE YOUR JOB INFO OBJECT


                //TODO: MAKE SURE THE MANIFEFST IS CORRECT


                //TODO: GET AN INSTANCE OF YOUR JOB SCHEDULER



                //TODO: SCHEDULE YOUR JOB


            }
        });

        stopJobButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: GET AN INSTANCE OF YOUR JOBSCHEDULER
                //TODO: CANCEL YOUR JOB
            }
        });
    }
}
