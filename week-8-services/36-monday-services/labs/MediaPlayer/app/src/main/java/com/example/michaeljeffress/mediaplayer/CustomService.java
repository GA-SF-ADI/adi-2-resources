package com.example.michaeljeffress.mediaplayer;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by michaeljeffress on 7/25/16.
 */
public class CustomService extends Service {
    MediaPlayer mPlayer = new MediaPlayer();
    boolean isPrepared = false;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(final Intent intent, int flags, int startId) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (intent != null) {
                    String action = intent.getAction();

                    if ("PLAY".equalsIgnoreCase(action)) {


                        if (!isPrepared) {
                            try {
                                String url = "http://download.lisztonian.com/music/download/Clair%2Bde%2BLune-113.mp3";
                                mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                                mPlayer.setDataSource(url);
                                mPlayer.prepareAsync();
                                mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                                    @Override
                                    public void onPrepared(MediaPlayer mediaPlayer) {
                                        isPrepared = true;
                                        mPlayer.start();
                                    }
                                });
                                mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener()

                                {
                                    @Override
                                    public void onCompletion(MediaPlayer mp) {
                                        stopSelf();
                                    }
                                });
                            } catch (Throwable e) {
                                stopSelf();
                            }


                        } else {
                            mPlayer.start();
                        }
                    } else if ("PAUSE".equalsIgnoreCase(action)) {
                        if (mPlayer.isPlaying()) {
                            mPlayer.pause();
                        }
                    } else if ("STOP".equalsIgnoreCase(action)) {
                        stopSelf();
                    }
                }
            }


        };

        new Thread(runnable).start();

    return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        mPlayer.stop();
        mPlayer.release();
        isPrepared = false;
    }
}




