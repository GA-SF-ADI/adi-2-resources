package com.test.servicesmusiclab;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by audreyeso on 7/25/16.
 */
public class MusicService extends Service {

    private static final String TAG = "MusicService";
    private Thread thread;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //create new thread

        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //run the music

            }

        });

    }
        @Override
        public int onStartCommand (Intent intent,int flags, int startId){
            Log.i(TAG, "Music Service Started");

            // run the thread
            thread.run();

            // toast after the "work" was finished
            Toast.makeText(getApplicationContext(), "Music Service work is finished", Toast.LENGTH_SHORT).show();

            return START_STICKY; //comes from service class
        }

        @Override
        public void onDestroy () {
            super.onDestroy();
            Log.i(TAG, "Service Destroyed");
            Toast.makeText(this, "Service Destroyed", Toast.LENGTH_SHORT).show();
        }
    }
