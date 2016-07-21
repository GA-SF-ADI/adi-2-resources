package com.example.hollis.examplejobscheduler;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;

import java.util.Calendar;

/**
 * Created by hollis on 7/13/16.
 */

@TargetApi(21)
public class ExampleJobService extends JobService {
    @Override
    public boolean onStartJob(JobParameters params) {
        Log.d("ExampleJobService", "onStartJob: " + Calendar.getInstance().getTime());
        jobFinished(params, false);
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }


}
