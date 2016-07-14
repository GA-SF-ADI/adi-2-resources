package com.test.snug;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioButton;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
    private static String LOG_TAG = "SearchActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_activity_main_toolbar);
        setSupportActionBar(toolbar);

        Context context = getApplicationContext();
        HatsSQLiteOpenHelper db = new HatsSQLiteOpenHelper(context);

        final FloatingActionButton startSearchFAB = (FloatingActionButton) findViewById(R.id.fab_to_start_search);

        final RadioButton fittedRadioButton = (RadioButton) findViewById(R.id.fitted_cap_radio_button);
        final RadioButton snapbackRadioButton = (RadioButton) findViewById(R.id.snapback_cap_radio_button);

        final EditText priceMax = (EditText) findViewById(R.id.editText_price);
        final EditText requestedTeam = (EditText) findViewById(R.id.auto_search_description_etc);

        String userSearchTeamRequest = requestedTeam.getText().toString();

        final boolean fitted = false;
        final boolean snapback = false;


        fittedRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (fittedRadioButton.isChecked()) {

                    fittedRadioButton.setChecked(true);
                    snapbackRadioButton.setChecked(false);

                } else {

                    fittedRadioButton.setChecked(false);
                    snapbackRadioButton.setChecked(false);
                }
            }


        });

        snapbackRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (snapbackRadioButton.isChecked()) {

                    snapbackRadioButton.setChecked(true);
                    fittedRadioButton.setChecked(false);

                } else {

                    snapbackRadioButton.setChecked(false);
                    fittedRadioButton.setChecked(false);
                }
            }


        });

        startSearchFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(SearchActivity.this, MainActivity.class);

//                intent.putExtra("maxPriceSearch", maxPrice);


                startActivity(intent);

                onStop();

            }
        });


//    TODO: Remove Strings from cursor and put strings into Array to be passed into MultiAutoCompleteTextView adapter below

        Cursor cursor = db.getHatTeams();

        Log.d(LOG_TAG, "cursor created with getHatTeams()");

        ArrayList<String> teamNamesFromDatabaseArrayList = new ArrayList<String>();

        Log.d(LOG_TAG, "teamNamesFromDatabaseArrayList ArrayList created");

        while (!cursor.isAfterLast()) {

            teamNamesFromDatabaseArrayList.add(cursor.getString(cursor.getColumnIndex(HatsSQLiteOpenHelper.HAT_COLUMN_HATNAME)));
            Log.d(LOG_TAG, "team name pulled from cursor and added to ArrayList");
        }

        Log.d(LOG_TAG, "ArrayList full with all team names");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, teamNamesFromDatabaseArrayList);

        Log.d(LOG_TAG, "MultiAutoCompleteTextView created");

        MultiAutoCompleteTextView textView = (MultiAutoCompleteTextView) findViewById(R.id.auto_search_description_etc);

        Log.d(LOG_TAG, "MultiAutoCompleteTextView view binded to activity");

        textView.setAdapter(adapter);

        Log.d(LOG_TAG, "MultiAutoCompleteTextView adapter created");

        textView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        Log.d(LOG_TAG, "Tokenizer set");


    }

//        Cursor cursor = db.getHatTeams(userSearchTeamRequest);

}
