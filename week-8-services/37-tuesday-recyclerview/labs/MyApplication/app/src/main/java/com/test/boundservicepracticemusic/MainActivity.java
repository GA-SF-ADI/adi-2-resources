package com.test.boundservicepracticemusic;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.test.boundservicepracticemusic.MusicService;
import com.test.boundservicepracticemusic.R;

public class MainActivity extends AppCompatActivity {

    // Using the boolean mPlayingMusic to see if user has clicked on "PLAY" or "PAUSE"
    boolean mPlayingMusic =  true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setting views (3 buttons: play, pause, stop)
        setViews();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Intent intent = new Intent(MainActivity.this, MusicService.class);
        stopService(intent);

        intent = new Intent(MainActivity.this, MusicService.class);
        stopService(intent);
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
                Intent intent = new Intent(MainActivity.this, MusicService.class);
                intent.setAction(mPlayingMusic ? "PLAY" : "PAUSE");
                startService(intent);

            }
        });

        //Stopping MusicService here
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MusicService.class);
                stopService(intent);
                mPlayingMusic = true;

            }
        });

        //Stopping music service here... it is just stopping again and destroying the service
        //Had difficulty getting it to pause with
        //There is no pauseService
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO PAUSE your CustomService here
                Intent intent = new Intent(MainActivity.this, MusicService.class);
                stopService(intent);
            }
        });
    }
}
