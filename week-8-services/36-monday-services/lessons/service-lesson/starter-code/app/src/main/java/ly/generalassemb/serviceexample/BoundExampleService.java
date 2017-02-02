package ly.generalassemb.serviceexample;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by audreyeso on 7/31/16.
 */
public class BoundExampleService extends Service {

    private final MyLocalBinder myLocalBinder = new MyLocalBinder();
    MediaPlayer mediaPlayer = new MediaPlayer();
    boolean isPrepared = false;

    public void startMusic() {
        if (!isPrepared) {
            try {
                String url = "http://download.lisztonian.com/music/download/Clair%2Bde%2BLune-113.mp3";
                mediaPlayer.reset();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mediaPlayer.setDataSource(url);
                mediaPlayer.prepareAsync();
                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        isPrepared = true;
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
                Toast.makeText(BoundExampleService.this, "Could not play file", Toast.LENGTH_SHORT).show();
            }
        } else {
        }
    }

    public void pauseMusic() {
        if (isPrepared) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
            }
        }
    }



    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
        isPrepared = false;
        return super.onUnbind(intent);
    }

    public class MyLocalBinder extends Binder {
        BoundExampleService getService() {
            return BoundExampleService.this;
        }
    }


}
