package gg.patrickcummins.hotify;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity implements SongRecyclerViewAdapter.OnSongClick {
    Button play, pause, stop;
    String songUrl;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter rvAdapter;
    private RecyclerView.LayoutManager rvLayoutManager;

    private ArrayList<Song> dataList = new ArrayList<Song>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setViews();
        setSongs();
        setAdapter();
        setOnClicks();

    }

    private void setAdapter() {
        rvLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(rvLayoutManager);
        rvAdapter = new SongRecyclerViewAdapter(dataList, this);
        recyclerView.setAdapter(rvAdapter);
    }

    private void setSongs() {
        dataList.add(new Song("Clair de Lune","http://download.lisztonian.com/music/download/Clair%2Bde%2BLune-113.mp3"));
        dataList.add(new Song("ChaChing", "https://raw.githubusercontent.com/GA-SF-ADI/adi-2-resources/master/week-8-services/36-monday-services/homework/chaching.mp3?token=AG8siB58xzB7UfSEDEeezyXnKrASLcR_ks5XoO9gwA%3D%3D"));
    }

    private void setOnClicks() {
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SongService.class);
                intent.putExtra("userinput", "play");
                startService(intent);
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SongService.class);
                intent.putExtra("userinput", "pause");
                startService(intent);
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SongService.class);
                intent.putExtra("userinput", "stop");
                startService(intent);
            }
        });
    }

    private void setViews() {
        play = (Button) findViewById(R.id.play);
        pause = (Button) findViewById(R.id.pause);
        stop = (Button) findViewById(R.id.stop);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

    }

    @Override
    public void setSong(int position) {
        this.songUrl = dataList.get(position).getSongUrl();
        Intent stopIntent = new Intent(MainActivity.this, SongService.class);
        stopIntent.putExtra("userinput", "stop");
        startService(stopIntent);
        Intent intent = new Intent(MainActivity.this, SongService.class);
        intent.putExtra("userinput", "play");
        intent.putExtra("songUrl", songUrl);
        startService(intent);
    }
}
