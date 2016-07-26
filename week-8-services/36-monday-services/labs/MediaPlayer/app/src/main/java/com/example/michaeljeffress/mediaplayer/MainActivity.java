package com.example.michaeljeffress.mediaplayer;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonPlay;
    Button buttonPause;
    Button buttonStop;

    private String url = null;

    boolean showPlayButton = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button buttonPlay = (Button)findViewById(R.id.buttonPlay);
        final Button buttonPause = (Button)findViewById(R.id.buttonPause);
        final Button buttonStop = (Button)findViewById(R.id.buttonStop);

        buttonPause.setVisibility(View.INVISIBLE);

        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CustomService.class);
                intent.setAction("PLAY");
                buttonPlay.setVisibility(View.INVISIBLE);
                buttonPause.setVisibility(View.VISIBLE);
                startService(intent);

            }
        });

        buttonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CustomService.class);
                intent.setAction("PAUSE");
                buttonPlay.setVisibility(View.VISIBLE);
                buttonPause.setVisibility(View.INVISIBLE);

            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CustomService.class);
                buttonPlay.setVisibility(View.VISIBLE);
                buttonPause.setVisibility(View.INVISIBLE);
                stopService(intent);
            }
        });


    }


}
