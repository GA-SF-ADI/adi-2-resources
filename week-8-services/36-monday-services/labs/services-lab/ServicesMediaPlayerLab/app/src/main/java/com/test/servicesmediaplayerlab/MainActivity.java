package com.test.servicesmediaplayerlab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button play;
    Button pause;
    Button stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = (Button)findViewById(R.id.play_button);
        pause = (Button)findViewById(R.id.pause_button);
        stop = (Button)findViewById(R.id.stop_button);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent playIntent = new Intent(MainActivity.this, CustomService.class);
                String play = "play";
                playIntent.putExtra("play",play);
                startService(playIntent);
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pauseIntent = new Intent(MainActivity.this, CustomService.class);
                String pause = "pause";
                pauseIntent.putExtra("pause",pause);
                startService(pauseIntent);
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent stopIntent = new Intent(MainActivity.this, CustomService.class);
                String stop = "stop";
                stopIntent.putExtra("stop",stop);
                stopService(stopIntent);
            }
        });

    }

}
