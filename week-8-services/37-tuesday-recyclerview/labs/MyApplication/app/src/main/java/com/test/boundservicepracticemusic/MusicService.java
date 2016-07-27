package com.test.boundservicepracticemusic;

/**
 * Created by audreyeso on 7/26/16.
 */

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by audreyeso on 7/25/16.
 */

public class MusicService extends Service {


    MediaPlayer mediaPlayer = new MediaPlayer();
    private final IBinder myBinder = new MyLocalBinder();
    boolean musicPlaying = false;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }


    public class MyLocalBinder extends Binder {
        MusicService getService() {
            return MusicService.this;
        }
    }

    //will play music (from url) when play button is clicked
    public void playMusic(String action) {

        if ("PLAY".contains(action)) {
            if (!musicPlaying) {
                try {

                    String url = "http://download.lisztonian.com/music/download/Clair%2Bde%2BLune-113.mp3";
                    mediaPlayer.reset();
                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    mediaPlayer.setDataSource(url);

                    mediaPlayer.prepareAsync();

                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {

                            mediaPlayer.start();
                        }
                    });

                } catch (Throwable e) {

                    e.printStackTrace();
                    Toast.makeText(MusicService.this, "File cannot play.", Toast.LENGTH_SHORT).show();
                    stopSelf();
                }
            }
        }

        //will pause if the mediaPlayer is currently playing
        if ("PAUSE".contains(action)) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();

            }
        }

        //will stop if the mediaPlayer is currently playing
        if("STOP".contains(action)) {
            if(mediaPlayer.isPlaying()){
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
            }
        }
    }
}









