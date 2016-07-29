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
    public JobScheduler jobScheduler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();
        setOnClickListeners();
        jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);


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
                JobInfo jobInfo = new JobInfo.Builder( JOB_INFO,
                        new ComponentName( getPackageName(),
                                NotificationJobService.class.getName()))  //the name of the JobService you will eventually create
                        .setPeriodic(10000) //The period that you want your jobbuilder to run on
                        .build();

                //TODO: MAKE SURE THE MANIFEFST IS CORRECT


                //TODO: GET AN INSTANCE OF YOUR JOB SCHEDULER



                //TODO: SCHEDULE YOUR JOB

                jobScheduler.schedule(jobInfo);

            }
        });

        stopJobButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: GET AN INSTANCE OF YOUR JOBSCHEDULER

                //TODO: CANCEL YOUR JOB
                jobScheduler.cancel(JOB_INFO);
            }
        });
    }
}
