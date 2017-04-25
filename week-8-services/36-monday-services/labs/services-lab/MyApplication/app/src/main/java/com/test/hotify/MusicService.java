package com.test.hotify;
import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import java.io.IOException;

/**
 * Created by Jon Kim on 7/25/16.
 */
public class MusicService extends Service {
    MediaPlayer mPlayer;
    String url = "http://download.lisztonian.com/music/download/Clair%2Bde%2BLune-113.mp3";
    private final IBinder myBinder = new MyLocalBinder();
    int length;
    boolean isPrepared = false;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    public class MyLocalBinder extends Binder{
        MusicService getService(){
            return MusicService.this;
        }
    }

    @Override
    public void onCreate() {
        mPlayer = new MediaPlayer();
        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mPlayer.setDataSource(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        super.onCreate();
    }

    @Override
    public void onDestroy() {
        mPlayer.stop();
        super.onDestroy();
    }
    //This method works but it doesn't work after I press stop. App doesn't crash but it says "start called in state 0" "error(-38,0)"
    public void playMusic(){
        if(length>0){
            mPlayer.seekTo(length);
            mPlayer.start();
        }else if(!isPrepared){
        Runnable customRunnable = new Runnable() {
            @Override
            public void run() {

                mPlayer.prepareAsync();
                mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {

                        mPlayer.start();

                    }
                });
            }
        };

            Thread customThread = new Thread(customRunnable);
            customThread.start();
            isPrepared=true;
        }else{
            mPlayer.start();
        }
    }

    public void stopMusic(){
        mPlayer.stop();
        length=0;
    }

    public void pauseMusic(){
        if(mPlayer.isPlaying()){
            mPlayer.pause();
            length=mPlayer.getCurrentPosition();
        }else{
            mPlayer.seekTo(length);
            mPlayer.start();
        }
    }
}
