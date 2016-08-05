package co.ga.hotify;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class HotifyService extends Service {
    private final MyLocalBinder myBinder = new MyLocalBinder();
    MediaPlayer mPlayer = new MediaPlayer();

    boolean isPrepared = false;

    public void startMusic(){
        if (!isPrepared){
            try {
                String url = "http://download.lisztonian.com/music/download/Clair%2Bde%2BLune-113.mp3";
                mPlayer.reset();
                mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mPlayer.setDataSource(url);
                mPlayer.prepareAsync();
                mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        isPrepared = true;
                        mPlayer.start();
                    }
                });
                mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        stopSelf();
                    }
                });
            } catch (Throwable e) {
                e.printStackTrace();
                Toast.makeText(HotifyService.this, "Could not play file", Toast.LENGTH_SHORT).show();
                stopSelf();
            }
        } else {
            // ... else, if the player is already prepared, just play the song
            mPlayer.start();
        }

    }


    public void pauseMusic(){
        if(isPrepared) {
            if (mPlayer.isPlaying()) {
                mPlayer.pause();
            }
        }
    }


    @Override
    public boolean onUnbind(Intent intent) {
        if(mPlayer.isPlaying()){
            mPlayer.stop();
        }
        isPrepared = false;
        stopForeground(true);
        return super.onUnbind(intent);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    public class MyLocalBinder extends Binder {
        HotifyService getService(){
            return HotifyService.this;
        }
    }
}
