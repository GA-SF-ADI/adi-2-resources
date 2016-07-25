package com.test.servicesmusiclab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                // TODO START your CustomService here

                Intent intent = new Intent(MainActivity.this, MusicService.class);
                startService(intent);

            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO STOP your CustomService here
                Intent intent = new Intent(MainActivity.this, MusicService.class);
                stopService(intent);

            }
        });

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

