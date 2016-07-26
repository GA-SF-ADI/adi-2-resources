package com.test.snug;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by LangstonSmith on 7/25/16.
 */
public class PaymentSoundService extends Service {

    MediaPlayer mMediaPlayer;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.chaching);

        mediaPlayer.start();

        /*mMediaPlayer.prepareAsync(); // prepare async to not block main thread*/


        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("PaymentSoundService", "Service Destroyed");
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_SHORT).show();
    }


}
