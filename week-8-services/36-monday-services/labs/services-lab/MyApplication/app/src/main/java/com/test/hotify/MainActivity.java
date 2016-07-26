package com.test.hotify;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button playButton,pauseButton,stopButton;
    MusicService mService;
    boolean isBound = false;

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MusicService.MyLocalBinder binder = (MusicService.MyLocalBinder) iBinder;
            mService = binder.getService();
            isBound = true;

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            isBound = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playButton = (Button) findViewById(R.id.play_button);
        pauseButton = (Button) findViewById(R.id.pause_button);
        stopButton = (Button) findViewById(R.id.stop_button);

        Intent intent = new Intent(MainActivity.this,MusicService.class);
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mService.playMusic();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mService.stopMusic();
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mService.pauseMusic();
            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        if(isBound){
            unbindService(mConnection);
            isBound = false;
        }

    }
}
