package com.test.boundservicepracticemusic;

/**
 * Created by audreyeso on 7/26/16.
 */
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
                                //These 3 lines of the set the song to whatever the url is
                                String url = "http://download.lisztonian.com/music/download/Clair%2Bde%2BLune-113.mp3";
                                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC); //.STREAM_MUSIC
                                mediaPlayer.setDataSource(url); //set the url here

                                mediaPlayer.prepareAsync();
                                //this line prepares the media player to be played
                                //notice how it done asynchronously the regular prepare method would be slower
                                // and wait for the whole song is loaded... asynchronously (does not load the whole song)

                                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                                    @Override
                                    public void onPrepared(MediaPlayer mediaPlayer) {
                                        //when the mediaPlayer is ready, being playing the song
                                        musicPlaying = true;
                                        mediaPlayer.start();
                                    }

                                });

                            } catch (Throwable e) {
                                //We use this so that if something fails, an exception in thrown and the app won't crash
                                //stack trace is printed and show toast if something is going wrong

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

        return START_NOT_STICKY; //comes from service class... can be STICKY or NOT STICKY
        //STICKY: service is restarted when app is destroyed
        //NON STICKY: use not sticky to avoid this
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Service Destroyed");
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_SHORT).show();
        //stops the playback
        mediaPlayer.stop();
        // When the service is destroyed (anytime the service is stopped), we release the memory used
        // by the media player, which can be a lot of memory.
        mediaPlayer.release();
        musicPlaying = false;
    }
}
