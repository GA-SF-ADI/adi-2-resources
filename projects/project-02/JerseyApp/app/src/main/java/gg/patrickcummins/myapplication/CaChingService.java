package gg.patrickcummins.myapplication;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.io.IOException;

/**
 * Created by patrickcummins on 7/25/16.
 */

public class CaChingService extends Service {
    MediaPlayer mediaPlayer = new MediaPlayer();
    String url = "https://raw.githubusercontent.com/GA-SF-ADI/adi-2-resources/master/week-8-services/36-monday-services/homework/chaching.mp3?token=AG8siK7HVLn6ch-rl3imOw3m5OOYRUWDks5XoCkMwA%3D%3D";


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    mediaPlayer.setDataSource(url);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mediaPlayer.prepareAsync();
                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        mediaPlayer.start();
                    }
                });
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        stopSelf();
                    }
                });
            }
        }).run();
        return super.onStartCommand(intent, flags, startId);
    }








    @Override
    public void onDestroy() {

        mediaPlayer.release();
        stopForeground(true);
        super.onDestroy();
    }
}
