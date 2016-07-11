package com.example.hollis.sharedpreferenceexample;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    //make global string
    private String curColumn = "default";
    //global
    SharedPreferences sharedPreferences;
    public static final String TAG = "MainActivity";
    public static final String TEMP_TYPE = "tempurature type";
    public static final String INSERTED_INTO_DATABASE_KEY = "have inserted into database";
    ListView listView;
    WeatherSQliteOpenHelper helper;
    Button fahr;
    Button cels;
    Button kelv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Gets an Instance of our weather helper
        helper = WeatherSQliteOpenHelper.getInstance(this);


        //inserts weathers into our database
        //TODO: THIS WILL RUN ON ONCREATE EVERY TIME, USE SHAREDPREFERENCES TO MAKE IT NOT HAPPEN
       sharedPreferences = getSharedPreferences("MainActivityExample", Context.MODE_PRIVATE);


        //check if we've added it before by checking our shared preferences
        boolean isAdded = sharedPreferences.getBoolean("isAdded", false);

        //check if is added is NOT true
        if (!isAdded) {

            Weather weather1 = new Weather("Monday", 20, 78, 295);
            Weather weather2 = new Weather("Tuesday", 4, 23, 232);
            Weather weather3 = new Weather("Wednesday", 2, 42, 123);
            Weather weather4 = new Weather("Thursday", 13, 21, 245);
            Weather weather5 = new Weather("Friday", 18, 32, 231);
            helper.insert(weather1);
            helper.insert(weather2);
            helper.insert(weather3);
            helper.insert(weather4);
            helper.insert(weather5);

            //change isAdded to true in our shared preferences
            //grabbed editor
            SharedPreferences.Editor editor = sharedPreferences.edit();
            //put value into the editor and it must match "isAdded"
            editor.putBoolean("isAdded", true);
            //commit our changes
            editor.commit();
        }

        listView = (ListView) findViewById(R.id.listview);


        //These Click Listeners determine which type of temperature should be shown
        //TODO: Save the users preferences on shared preferences
        //TODO: Have the correct one load up onCreate or onResume;
        fahr = (Button) findViewById(R.id.fahr_button);
        cels = (Button) findViewById(R.id.celsius_button);
        kelv = (Button) findViewById(R.id.kelvin_button);
        //change onClick Listeners to change curColumn
        fahr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAdapter(WeatherSQliteOpenHelper.COL_TEMP_FAHR);
                //change onClick Listeners to change curColumn
                curColumn = WeatherSQliteOpenHelper.COL_TEMP_FAHR;

            }
        });

        cels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAdapter(WeatherSQliteOpenHelper.COL_TEMP_CEL);
                //change onClick Listeners to change curColumn
                curColumn = WeatherSQliteOpenHelper.COL_TEMP_CEL;


            }
        });
        kelv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAdapter(WeatherSQliteOpenHelper.COL_TEMP_KELVIN);
                //change onClick Listeners to change curColumn
                curColumn = WeatherSQliteOpenHelper.COL_TEMP_KELVIN;


            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        //save the current column to shared preferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("curColumn", curColumn);
        editor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //run setadapter on the column if it is in shared preferences
        curColumn = sharedPreferences.getString("curColumn", "default");

        //check if it's not equal to default and set adapter
        if(!curColumn.equals("default")){
            setAdapter(curColumn);
        }
    }

    //Temp Type needs to be the static variable from WeatherSQlite Open helper that is the correct colum
    public void setAdapter(String curColumn) {
        if (curColumn.equals(WeatherSQliteOpenHelper.COL_TEMP_CEL) || curColumn.equals(WeatherSQliteOpenHelper.COL_TEMP_KELVIN) || curColumn.equals(WeatherSQliteOpenHelper.COL_TEMP_FAHR)) {
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(MainActivity.this,
                    android.R.layout.simple_list_item_2,
                    helper.getTemp(curColumn),
                    new String[]{WeatherSQliteOpenHelper.COL_DAY, curColumn},
                    new int[]{android.R.id.text1, android.R.id.text2},
                    0);
            listView.setAdapter(adapter);
        } else {
            Toast.makeText(this, "Click a Button to show tempuratures!", Toast.LENGTH_SHORT).show();
        }
    }
}
