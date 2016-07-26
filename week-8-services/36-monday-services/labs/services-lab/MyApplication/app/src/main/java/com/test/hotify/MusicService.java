package com.test.hotify;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.io.IOException;

/**
 * Created by Jon Kim on 7/25/16.
 */
public class MusicService extends Service {
    MediaPlayer mPlayer;
    String url = "http://download.lisztonian.com/music/download/Clair%2Bde%2BLune-113.mp3";


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        mPlayer = new MediaPlayer();
        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mPlayer.setDataSource(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Runnable customRunnable = new Runnable() {
            @Override
            public void run() {

                mPlayer.prepareAsync();
                mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {

                        mPlayer.start();


                    }
                });
            }
        };

        Thread customThread = new Thread(customRunnable);
        customThread.start();



        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        mPlayer.stop();
        super.onDestroy();
    }
}
