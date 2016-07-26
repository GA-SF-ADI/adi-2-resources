package com.test.servicesmediaplayerlab;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by nolbertoarroyo on 7/25/16.
 */
public class CustomService extends Service {
    MediaPlayer mediaPlayer;
    Boolean isPrepared = false;
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
    public int onStartCommand(final Intent intent, int flags, int startId) {

        //created musicRunnable
        Runnable musicRunnable = new Runnable() {
            @Override
            public void run() {

            // checking if intent is not null
                // if it is not null, then we check the action and prepare the mediaplayer
                if (intent != null) {
                    String action = intent.getAction();

                    if ("play".equals(action)) {


                        if (!isPrepared) {
                            try {
                                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                                mediaPlayer.setDataSource(url);

                                mediaPlayer.prepareAsync();
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

                            } catch (Throwable e) {
                                e.printStackTrace();
                                Toast.makeText(CustomService.this, "could not play file", Toast.LENGTH_SHORT).show();
                                stopSelf();
                            }
                        }// checking if the action from intent is "pause" or if it is "stop"
                    } else if ("pause".equals(action) && mediaPlayer.isPlaying()) {
                        mediaPlayer.pause();
                    } else if ("stop".equals(action)) {
                        stopSelf();
                    }
                }
            }
        };
        new Thread(musicRunnable).start();


        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        mediaPlayer.release();
        isPrepared = false;
        // stopping the mediaplayer

    }
}
