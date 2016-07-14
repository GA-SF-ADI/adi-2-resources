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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
    private static String LOG_TAG = "SearchActivity";

    private static final String TAG = "SearchActivity";
    private static final boolean VERBOSE = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //Setting up views, toolbars, and binding data

        Toolbar toolbar = (Toolbar) findViewById(R.id.search_activity_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        final FloatingActionButton startSearchFAB = (FloatingActionButton) findViewById(R.id.fab_to_start_search);

        final RadioButton fittedRadioButton = (RadioButton) findViewById(R.id.fitted_cap_radio_button);
        final RadioButton snapbackRadioButton = (RadioButton) findViewById(R.id.snapback_cap_radio_button);
        final Button clearSearchButton = (Button) findViewById(R.id.button_clear_search_paramaters);

        ImageButton cartButtonInToolbar = (ImageButton) findViewById(R.id.button_in_toolbar_to_view_cart);

        final EditText priceMax = (EditText) findViewById(R.id.editText_price);
        final EditText requestedTeam = (EditText) findViewById(R.id.auto_search_description_etc);

        Context context = getApplicationContext();
        HatsSQLiteOpenHelper db = new HatsSQLiteOpenHelper(context);

        final String userSearchTeamRequest = requestedTeam.getText().toString();


        final boolean fitted = false;
        final boolean snapback = false;


        //Radio button if statement listeners which toggle them on/off

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

                final String priceMaxRequest = priceMax.getText().toString();

                Intent intent = new Intent(SearchActivity.this, MainActivity.class);


                Toast.makeText(SearchActivity.this, "The requested teams are: " + userSearchTeamRequest, Toast.LENGTH_SHORT).show();

//                TODO: Make toast telling people to only do one search parameter!

                if (userSearchTeamRequest.isEmpty()) {


                    if (fittedRadioButton.isChecked()) {

                        if (snapbackRadioButton.isChecked()) {

                            if (priceMaxRequest.isEmpty()) {


                            }


                        }

                    }


                } else {

                }



//                TODO: Grab any inputted teams

                if (!userSearchTeamRequest.isEmpty() && !fittedRadioButton.isChecked() && !snapbackRadioButton.isChecked() && priceMaxRequest.isEmpty()) {

                    intent = new Intent(SearchActivity.this, MainActivity.class);

//                    intent.putExtra("userSearchTeamRequest", priceMaxRequest); <–– TODO: Need to figure out how to pass this through

                    Toast.makeText(SearchActivity.this, "The requested teams are: " + userSearchTeamRequest, Toast.LENGTH_SHORT).show();

                    startActivity(intent);


                }

                if (userSearchTeamRequest.isEmpty() && fittedRadioButton.isChecked() && !snapbackRadioButton.isChecked() && priceMaxRequest.isEmpty()) {

                    intent = new Intent(SearchActivity.this, MainActivity.class);

                    intent.putExtra("fittedRadioButton is checked", fittedRadioButton.isChecked());

                    Toast.makeText(SearchActivity.this, "The fittedRadioButton button selected", Toast.LENGTH_SHORT).show();

                    startActivity(intent);


                }
                if (userSearchTeamRequest.isEmpty() && snapbackRadioButton.isChecked() && !fittedRadioButton.isChecked() && priceMaxRequest.isEmpty()) {

                    intent = new Intent(SearchActivity.this, MainActivity.class);

                    intent.putExtra("snapbackRadioButton is checked", snapbackRadioButton.isChecked());

                    Toast.makeText(SearchActivity.this, "The snapbackRadioButton selected", Toast.LENGTH_SHORT).show();

                    startActivity(intent);


                }
                if (!priceMaxRequest.isEmpty() && userSearchTeamRequest.isEmpty() && !fittedRadioButton.isChecked() && !snapbackRadioButton.isChecked()) {

                    intent = new Intent(SearchActivity.this, MainActivity.class);

                    intent.putExtra("priceMaxRequest", priceMaxRequest);

                    Toast.makeText(SearchActivity.this, "The max price is: " + priceMaxRequest, Toast.LENGTH_SHORT).show();

                    startActivity(intent);

                }


            }
        });

        //Clearing search paramaters when "Clear Search" button is clicked

        clearSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ((MultiAutoCompleteTextView) findViewById(R.id.auto_search_description_etc)).setText("");
                ((RadioButton) findViewById(R.id.fitted_cap_radio_button)).setChecked(false);
                ((RadioButton) findViewById(R.id.snapback_cap_radio_button)).setChecked(false);
                ((EditText) findViewById(R.id.editText_price)).setText("");
            }
        });

        //Menu image button click listeners
        cartButtonInToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SearchActivity.this, ShoppingCartActivity.class);
                startActivity(intent);

            }
        });


        //Grabbing unique ArrayList of team names and eventually passing it to MultiAutoCompleteTextView and its cursor

        Cursor cursor = db.getHatTeams();

        Log.d(LOG_TAG, "cursor created with getHatTeams()");

        ArrayList<String> teamNamesFromDatabaseArrayList = new ArrayList<String>();

        Log.d(LOG_TAG, "teamNamesFromDatabaseArrayList ArrayList created");

        while (cursor.moveToNext()) { //<–TODO: Need to do more than just .moveToNext()? Close it?

            teamNamesFromDatabaseArrayList.add(cursor.getString(cursor.getColumnIndex(HatsSQLiteOpenHelper.HAT_COLUMN_HATNAME)));
            Log.d(LOG_TAG, "team name pulled from cursor and added to ArrayList");
        }

        Log.d(LOG_TAG, "ArrayList full with all team names");

        cursor.close();

        Log.d(LOG_TAG, "Cursor closed");


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

    @Override
    public void onStart() {
        super.onStart();
        if (VERBOSE) Log.e(TAG, "++ ON START ++");
    }

    @Override
    public void onResume() {
        super.onResume();
        if (VERBOSE) Log.e(TAG, "+ ON RESUME +");
    }

    @Override
    public void onPause() {
        super.onPause();
        if (VERBOSE) Log.e(TAG, "- ON PAUSE -");
    }

    @Override
    public void onStop() {
        super.onStop();
        if (VERBOSE) Log.e(TAG, "-- ON STOP --");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (VERBOSE) Log.e(TAG, "- ON DESTROY -");
    }

}


