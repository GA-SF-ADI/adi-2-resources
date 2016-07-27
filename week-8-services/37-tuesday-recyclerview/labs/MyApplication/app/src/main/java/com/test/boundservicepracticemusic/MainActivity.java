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

import com.test.boundservicepracticemusic.MusicService;
import com.test.boundservicepracticemusic.R;

public class MainActivity extends AppCompatActivity {

    MusicService musicService = new MusicService();
    // Using the boolean mPlayingMusic to see if user has clicked on "PLAY" or "PAUSE"
    boolean mPlayingMusic = true;

    protected ServiceConnection myConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName className, IBinder service) {
            MusicService.MyLocalBinder binder = (MusicService.MyLocalBinder) service;
            musicService = binder.getService();
            Toast.makeText(MainActivity.this, "onServiceConnected", Toast.LENGTH_SHORT).show();
            mPlayingMusic = true;
        }

        public void onServiceDisconnected(ComponentName className) {
            //Log.e(TAG, "onServiceDisconnected");
            Toast.makeText(MainActivity.this, "onServiceDisonnected", Toast.LENGTH_SHORT).show();
            mPlayingMusic = false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setting views (3 buttons: play, pause, stop)
        setViews();
        final Intent intent = new Intent(this, MusicService.class);
        bindService(intent, myConnection, Context.BIND_AUTO_CREATE);
    }

    //Using this method to set the views and then this
    //method will be called in onCreate
    private void setViews() {
        setServiceViews();
    }

    //Linking buttons that were created in XML
    private void setServiceViews() {
        Button playButton = (Button) findViewById(R.id.play_button);
        Button stopButton = (Button) findViewById(R.id.stop_button);
        Button pauseButton = (Button) findViewById(R.id.pause_button);


        //Starting MusicService here
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, MusicService.class);
//                intent.setAction(mPlayingMusic ? "PLAY" : "PAUSE");
//                startService(intent);
                musicService.playMusic("PLAY");
                mPlayingMusic = true;
                Toast.makeText(MainActivity.this, "playing music", Toast.LENGTH_SHORT).show();

            }
        });

        //Stopping MusicService here
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, MusicService.class);
//                stopService(intent);
//                mPlayingMusic = true;

            }
        });

        //Stopping music service here... it is just stopping again and destroying the service
        //Had difficulty getting it to pause with
        //There is no pauseService
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                musicService.playMusic("PAUSE");
                mPlayingMusic = false;
                Toast.makeText(MainActivity.this, "pausing music", Toast.LENGTH_SHORT).show();
            }
        });

    }

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
