package com.example.hollis.examplejobscheduler;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public static final int JOB_ID = 23;
    @TargetApi(21)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JobInfo jobInfo = new JobInfo.Builder(JOB_ID,
                new ComponentName(getPackageName(),
                       ExampleJobService.class.getName() ))
                .setPeriodic(4000)
                .build();

        JobScheduler jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        int result = jobScheduler.schedule(jobInfo);
        if(result<=0){
            //handle it!
        }
        
    }

}
