package com.test.servicesmusiclab;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
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
    boolean musicPlaying = false;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //create new thread
    }
        @Override
        public int onStartCommand (final Intent intent, int flags, int startId){
            Log.i(TAG, "Music Service Started");




            Runnable musicRunnable = new Runnable() {
                @Override
                public void run() {
                    //run the music
                    if(intent!= null){
                        String musicAction = intent.getAction();

                        if("PLAY".equalsIgnoreCase(musicAction)) {
                            if(!musicPlaying) {
                                try {
                                    String url = "http://download.lisztonian.com/music/download/Clair%2Bde%2BLune-113.mp3";
                                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                                    mediaPlayer.setDataSource(url);

                                    mediaPlayer.prepareAsync(); //goes here

                                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                                        @Override
                                        public void onPrepared(MediaPlayer mediaPlayer) {
                                            musicPlaying =true;
                                            mediaPlayer.start();
                                        }

                                    });

                                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mediaPlayer) {
                                            stopSelf();

                                        }

                                    });

                                } catch (Throwable e) {

                                    e.printStackTrace();
                                    Toast.makeText(MusicService.this, "File cannot play.", Toast.LENGTH_SHORT).show();
                                    stopSelf();

                                }
                            }
                        }
                    }

                }

            };



            // run the thread
          new Thread(musicRunnable).start();

            // toast after the "work" was finished
            Toast.makeText(getApplicationContext(), "Music Service work is finished", Toast.LENGTH_SHORT).show();

            return START_NOT_STICKY; //comes from service class
        }


        @Override
        public void onDestroy () {
            super.onDestroy();
            Log.i(TAG, "Service Destroyed");
            Toast.makeText(this, "Service Destroyed", Toast.LENGTH_SHORT).show();
            mediaPlayer.stop();
            mediaPlayer.release();
            musicPlaying = false;
            //read about stopForeground in the notes... it removes the notification
            stopForeground(true);
        }
    }
