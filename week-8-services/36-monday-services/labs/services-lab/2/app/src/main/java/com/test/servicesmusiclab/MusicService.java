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
//extended Service
public class MusicService extends Service {

    //created a new media player
    MediaPlayer mediaPlayer = new MediaPlayer();
    private static final String TAG = "MusicService";
    //when boolean is set to true, it will NOT play music
    //the PLAY button will not work
    boolean musicPlaying = false;

    //necessary to have even though it is set to null
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
    public int onStartCommand(final Intent intent, int flags, int startId) {
        Log.i(TAG, "Music Service Started");
        //According to notes, you must use a runnable here so that all of the code inside of it is
        //run on a seperate thread otherwise, it will be much slower
        //I must also start the thread at the bottom with this code : new Thread(musicRunnable).start();

        Runnable musicRunnable = new Runnable() {
            @Override
            public void run() {
                //run the music
                if (intent != null) {
                    String musicAction = intent.getAction();// the musicAction can be PLAY, PAUSE, or STOP

                    if ("PLAY".contains(musicAction)) {
                        //or you can write .equalsIgnoreCase and "if" the musicAction is PLAY... do the following:
                        if (!musicPlaying) {
                            try {
                                String url = "http://download.lisztonian.com/music/download/Clair%2Bde%2BLune-113.mp3";
                                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                                mediaPlayer.setDataSource(url);

                                mediaPlayer.prepareAsync(); //goes here

                                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                                    @Override
                                    public void onPrepared(MediaPlayer mediaPlayer) {
                                        musicPlaying = true;
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
    public void onDestroy() {
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
