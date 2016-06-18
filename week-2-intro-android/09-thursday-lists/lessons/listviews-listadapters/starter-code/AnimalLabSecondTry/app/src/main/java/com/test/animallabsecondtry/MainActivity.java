package com.test.animallabsecondtry;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import java.lang.StringBuilder;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    final Button animalButton = (Button) findViewById(R.id.animal_button);
    animalButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick (View view) {
            Intent animalIntent = new Intent(MainActivity.this, AnimalActivity.class);
            startActivity(animalIntent);
                }
             }

            );
        }
    }





