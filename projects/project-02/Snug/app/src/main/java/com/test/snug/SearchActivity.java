package com.test.snug;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_activity_main_toolbar);
        setSupportActionBar(toolbar);

        final FloatingActionButton startSearchFAB = (FloatingActionButton) findViewById(R.id.fab_to_start_search);

        final RadioButton fittedRadioButton = (RadioButton) findViewById(R.id.fitted_cap_radio_button);
        final RadioButton snapbackRadioButton = (RadioButton) findViewById(R.id.snapback_cap_radio_button);
        final boolean fitted = false;
        final boolean snapback = false;


        fittedRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (fittedRadioButton.isChecked()) {
                    if (!fitted) {
                        fittedRadioButton.setChecked(true);
                        snapbackRadioButton.setChecked(false);

                    } else {

                        fittedRadioButton.setChecked(false);
                        snapbackRadioButton.setChecked(false);
                    }
                }

            }


        });

        snapbackRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (snapbackRadioButton.isChecked()) {
                    if (!snapback) {
                        snapbackRadioButton.setChecked(true);
                        fittedRadioButton.setChecked(false);

                    } else {

                        snapbackRadioButton.setChecked(false);
                        fittedRadioButton.setChecked(false);
                    }
                }


            }
        });

        startSearchFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchActivity.this, MainActivity.class);
                startActivity(intent);


            }
        });


    }




}