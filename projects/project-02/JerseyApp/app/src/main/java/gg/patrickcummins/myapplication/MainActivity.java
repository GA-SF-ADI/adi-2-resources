package gg.patrickcummins.myapplication;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.SupportActionModeWrapper;
import android.view.View;
import android.widget.ImageView;

import static android.R.attr.process;

public class MainActivity extends AppCompatActivity {
    ImageView warriors, raiders, sharks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setImageViews();
        setOnClickListeners();

    }

    private void setOnClickListeners() {
        warriors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRosterActivity("warriors");
            }
        });
        raiders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRosterActivity("raiders");
            }
        });
        sharks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRosterActivity("sharks");
            }
        });

    }

    private void startRosterActivity(String team) {
        Intent intent = new Intent(MainActivity.this, RostersActivity.class);
        intent.putExtra("team", team);
        startActivity(intent);

    }

    private void setImageViews() {
        warriors = (ImageView) findViewById(R.id.warriorsImageView);
        raiders = (ImageView) findViewById(R.id.raidersImageView);
        sharks = (ImageView) findViewById(R.id.sharksImageView);
    }

}
