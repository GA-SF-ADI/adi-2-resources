package com.test.myjs;

import android.app.IntentService;
import android.content.Intent;
import android.media.MediaPlayer;

/**
 * Created by nolbertoarroyo on 7/26/16.
 */
public class MusicService extends IntentService {
    MediaPlayer mediaPlayer;
    public MusicService() {
        super("MusicService");

    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = new MediaPlayer();
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    mediaPlayer= MediaPlayer.create(MusicService.this, R.raw.cha);
        mediaPlayer.start();

    }
}
