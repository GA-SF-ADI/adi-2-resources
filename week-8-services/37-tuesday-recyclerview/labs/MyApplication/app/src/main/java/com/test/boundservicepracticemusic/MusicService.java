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
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by audreyeso on 7/25/16.
 */

public class MusicService extends Service {


    MediaPlayer mediaPlayer = new MediaPlayer();
    private static final String TAG = "MusicService";
    private final IBinder myBinder = new MyLocalBinder();
    private int length = 0;

    boolean musicPlaying = false;

    //necessary to have even though it is set to null
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

    public void playMusic(String action) {
    length++;
        Log.d("TAG", "length is " + length);

        if ("PLAY".contains(action)) {
            if (!musicPlaying) {
                try {

                    String url = "http://download.lisztonian.com/music/download/Clair%2Bde%2BLune-113.mp3";
                    //mediaPlayer.reset();
                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC); //.STREAM_MUSIC
                    mediaPlayer.setDataSource(url); //set the url here

                    mediaPlayer.prepareAsync();

                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            //when the mediaPlayer is ready, being playing the song
                            musicPlaying = true;
                            mediaPlayer.seekTo(length);
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

        if ("PAUSE".contains(action)) {
            if (musicPlaying) {
                //musicPlaying = false;
                mediaPlayer.pause();
                length=mediaPlayer.getCurrentPosition();

            }
        }
    }
}









