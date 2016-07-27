package com.test.boundservicepracticemusic;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    MusicService musicService = new MusicService();
    boolean mPlayingMusic = true;

    protected ServiceConnection myConnection = new ServiceConnection() {
        //onServiceConnected is called when the connection with the service is established
        public void onServiceConnected(ComponentName className, IBinder service) {
            //Got a binder and then cast it
            MusicService.MyLocalBinder binder = (MusicService.MyLocalBinder) service;
            musicService = binder.getService();
            Toast.makeText(MainActivity.this, "onServiceConnected", Toast.LENGTH_SHORT).show();
            mPlayingMusic = true;
        }
        //onServiceDisconnected is called when the connection with the service disconnects unexpectedly
        public void onServiceDisconnected(ComponentName className) {
            Toast.makeText(MainActivity.this, "onServiceDisonnected", Toast.LENGTH_SHORT).show();
            mPlayingMusic = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setViews();
        //Bind to MusicService
        final Intent intent = new Intent(this, MusicService.class);
        bindService(intent, myConnection, Context.BIND_AUTO_CREATE);
    }


    private void setViews() {
        setServiceViews();
    }


    private void setServiceViews() {
        Button playButton = (Button) findViewById(R.id.play_button);
        Button stopButton = (Button) findViewById(R.id.stop_button);
        Button pauseButton = (Button) findViewById(R.id.pause_button);


        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                musicService.playMusic("PLAY");
                mPlayingMusic = true;
                Toast.makeText(MainActivity.this, "playing music", Toast.LENGTH_SHORT).show();

            }
        });


        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                musicService.playMusic("STOP");
                mPlayingMusic = false;
                Toast.makeText(MainActivity.this, "stopping music", Toast.LENGTH_SHORT).show();

            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                musicService.playMusic("PAUSE");
                mPlayingMusic = false;
                Toast.makeText(MainActivity.this, "pausing music", Toast.LENGTH_SHORT).show();
            }
        });

    }

    //Unbind from MusicService
    @Override
    public void onStop() {
        super.onStop();
        Toast.makeText(MainActivity.this, "onStop", Toast.LENGTH_SHORT).show();
        if (mPlayingMusic) {
            unbindService(myConnection);
            mPlayingMusic = false;
        }
    }

}
