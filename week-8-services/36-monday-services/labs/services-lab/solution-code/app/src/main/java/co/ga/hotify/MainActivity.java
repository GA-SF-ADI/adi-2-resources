package co.ga.hotify;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private String downloadUrl = null;

    // Is Play or Pause showing right now?
    boolean mShowingPlayButton = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ImageButton playPauseButton = (ImageButton) findViewById(R.id.playPauseButton);
        ImageButton stopButton = (ImageButton) findViewById(R.id.stopButton);

        playPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // When clicked, start the service with a play or pause intent

                Intent intent = new Intent(MainActivity.this, HotifyService.class);
                intent.setAction(mShowingPlayButton ? "PLAY" : "PAUSE");
                startService(intent);

                // Set the button's image to the play or pause image. This can able be done with an if-else

                playPauseButton.setImageResource(mShowingPlayButton?
                        android.R.drawable.ic_media_pause : android.R.drawable.ic_media_play);

                // This is toggling the boolean from true to false, and vice versa
                mShowingPlayButton = !mShowingPlayButton;
            }
        });


        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // When clicked, start the service with a stop intent

                Intent intent = new Intent(MainActivity.this, HotifyService.class);
                stopService(intent);

                // Set the play button's image to the play image. Reset the state.

                playPauseButton.setImageResource(android.R.drawable.ic_media_play);
                mShowingPlayButton = true;
            }
        });

    }

}
