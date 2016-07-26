package com.test.servicesmediaplayerlab;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.io.IOException;

/**
 * Created by nolbertoarroyo on 7/25/16.
 */
public class CustomService extends Service {
    MediaPlayer  mediaPlayer;
    Boolean isPrepared= false;
    String url = "http://download.lisztonian.com/music/download/Clair%2Bde%2BLune-113.mp3";
    @Override
    public void onCreate() {
        super.onCreate();

        mediaPlayer = new MediaPlayer();

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Runnable musicRunnable = new Runnable() {
            @Override
            public void run() {
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    mediaPlayer.setDataSource(url);
                } catch (IOException e) {
                    e.printStackTrace();
                }


                mediaPlayer.prepareAsync();
            }
        };



        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mediaPlayer.start();
                isPrepared = true;
            }
        });
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopSelf();
            }
        });
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        isPrepared=false;

    }
}
