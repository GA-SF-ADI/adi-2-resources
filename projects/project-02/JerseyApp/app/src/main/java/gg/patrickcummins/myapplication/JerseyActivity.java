package gg.patrickcummins.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class JerseyActivity extends AppCompatActivity {
    TextView jerseyColor1, jerseyColor2, jerseyColor3;
    ImageView jerseyImageView;
    String currentPlayer;
    //TODO: Alot of shit, connect to db

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jersey);

        Intent currentIntent = getIntent();
        currentPlayer = currentIntent.getStringExtra("playerName");

        setViews();
        setOnClickListenersAndJerseyDefault();
    }
    //TODO:Fix for Raiders 2 Jerseys
    private void setOnClickListenersAndJerseyDefault() {
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance(JerseyActivity.this);
        ArrayList<Integer> playerJerseysList = databaseHelper.getPlayerJerseysList(currentPlayer);
        jerseyImageView.setImageResource(playerJerseysList.get(0));
        setColorOnClick(jerseyColor1, playerJerseysList.get(0) );
        setColorOnClick(jerseyColor2, playerJerseysList.get(1) );
        setColorOnClick(jerseyColor3, playerJerseysList.get(2) );
    }

    private void setColorOnClick(TextView textView, final int jerseyDrawable) {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jerseyImageView.setImageResource(jerseyDrawable);
            }
        });
    }

    private void setViews() {
        jerseyColor1 = (TextView) findViewById(R.id.jersey1);
        jerseyColor2 = (TextView) findViewById(R.id.jersey2);
        jerseyColor3 = (TextView) findViewById(R.id.jersey3);
        jerseyImageView = (ImageView) findViewById(R.id.jerseyImageView);
    }
}
