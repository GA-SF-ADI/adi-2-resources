package com.test.myapplication;

import android.app.IntentService;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;

import java.io.IOException;

/**
 * Created by Jon Kim on 7/25/16.
 */
public class CustomIntentService extends IntentService {
    MediaPlayer mPlayer;
    public CustomIntentService() {
        super("CustomIntentService");
    }

    @Override
    public void onCreate() {
        mPlayer = new MediaPlayer();
        String url = "https://raw.githubusercontent.com/GA-SF-ADI/adi-2-resources/master/week-8-services/36-monday-services/homework/chaching.mp3?token=AQriIVGYTgI3PsEsytAneSGBL2rdztCdks5XoEE7wA%3D%3D";

        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mPlayer.setDataSource(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.onCreate();
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        mPlayer.prepareAsync();
        mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                mPlayer.start();


            }
        });

    }
}
