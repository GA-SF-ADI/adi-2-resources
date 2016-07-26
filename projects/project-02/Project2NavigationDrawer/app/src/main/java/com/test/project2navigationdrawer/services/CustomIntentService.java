package com.test.project2navigationdrawer.services;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.io.InterruptedIOException;

/**
 * Created by audreyeso on 7/25/16.
 */
public class CustomIntentService extends IntentService {
    private final String TAG = "CustomIntentService";
    MediaPlayer mediaPlayer = new MediaPlayer();
    boolean isPrepared = false;


    public CustomIntentService() {
        super("CustomIntentService");
        Log.i(TAG, "CustomIntentService Constructor");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        Log.i(TAG, "CustomService begin work");

        if ("TRUE".contains("TRUE")) {
            if (!isPrepared) {
                try {
                    String url = "";
                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    mediaPlayer.setDataSource(url);
                    Log.d("CustomIntentService", "setting media player");
                } catch (Throwable e) {
                    e.printStackTrace();
                    Log.d("CustomIntentService", "error caught for media player");
                }

                mediaPlayer.prepareAsync();
                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {

                        // once the player is prepared, start playing the song

                        isPrepared = true;
                        mediaPlayer.start();
                    }
                });

            }
        }
    }
        @Override
        public void onDestroy () {
            super.onDestroy();
            Log.i(TAG, "CustomService destroyed");
        }
    }


