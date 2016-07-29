package co.ga.hotify;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private String downloadUrl = null;

    // Is Play or Pause showing right now?
    boolean mShowingPlayButton = true;
    HotifyService hotifyService;
    boolean isBound;

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            HotifyService.MyLocalBinder binder = (HotifyService.MyLocalBinder) service;
            hotifyService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ImageButton playPauseButton = (ImageButton) findViewById(R.id.playPauseButton);
        ImageButton stopButton = (ImageButton) findViewById(R.id.stopButton);
        final Intent intent = new Intent(MainActivity.this, HotifyService.class);
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);

        playPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hotifyService == null){
                    bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
                }


                    // When clicked, start the service with a play or pause intent
                    if(mShowingPlayButton){
                        hotifyService.startMusic();
                    }else{
                        hotifyService.pauseMusic();
                    }
                    // Set the button's image to the play or pause image. This can able be done with an if-else

                    playPauseButton.setImageResource(mShowingPlayButton ?
                            android.R.drawable.ic_media_pause : android.R.drawable.ic_media_play);

                    // This is toggling the boolean from true to false, and vice versa
                    mShowingPlayButton = !mShowingPlayButton;
                }
        });


        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // When clicked, start the service with a stop intent
                if(isBound) {
                    unbindService(mServiceConnection);
                }
                Log.d("Main Activity", ""+ hotifyService);
                // Set the play button's image to the play image. Reset the state.

                playPauseButton.setImageResource(android.R.drawable.ic_media_play);
                mShowingPlayButton = true;
            }
        });

    }

}
