package com.test.snug;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioButton;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

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


            }
        });


//        Cursor cursor = db.getHatTeams(userSearchTeamRequest);


       /* ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, teamNamesFromDatabase);

        MultiAutoCompleteTextView textView = (MultiAutoCompleteTextView) findViewById(R.id.auto_search_description_etc);
        textView.setAdapter(adapter);
        textView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

*/


    }

    /*private static final String[] TEAM_NAMES_FROM_DATABASE = new String[]{
            "LA Angels", "Oakland A's", "San Francisco Giants", "LA Dodgers"
    };

    public String[] teamNamesFromDatabase() {
        Context context = getApplicationContext();
        HatsSQLiteOpenHelper db = new HatsSQLiteOpenHelper(context);

        Cursor cursor = db.getHatTeams();
        ArrayList<String> teamNamesFromDatabaseArrayList = new ArrayList<String>();
        while (!cursor.isAfterLast()) {
            names.add(cursor.getString(cursor.getColumnIndex("name")));
            cursor.moveToNext();
        }
        cursor.close();
        return names.toArray(new String[names.size()]);
    }
*/

}