package com.gradecodeschool.pandoratoolbarpractice;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

/**
 * Created by sterlinggerritz on 7/4/16.
 */
public class Pandora extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pandora);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_bottom);
        setSupportActionBar(toolbar);


        Button nextButton = (Button)findViewById(R.id.pandora_nextButton);


        if (nextButton != null) {
            nextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(Pandora.this, Podcasts.class);
                    startActivity(intent);

                }
            });
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_pandora, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.play_button:

                Toast.makeText(getApplicationContext(), "You Hit Play", Toast.LENGTH_SHORT).show();

                return true;

            case R.id.back_button:
                Toast.makeText(getApplicationContext(), "You are going  back", Toast.LENGTH_SHORT).show();

                return true;

            case R.id.next_button:
                Toast.makeText(getApplicationContext(), "You hit next", Toast.LENGTH_SHORT).show();

                return true;

            case R.id.pause_button:
                Toast.makeText(getApplicationContext(), "you hit pause", Toast.LENGTH_SHORT).show();

                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }

}