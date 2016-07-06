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
    ListView listView;
    WeatherSQliteOpenHelper helper;
    Button fahr;
    Button cels;
    Button kelv;
    boolean fahrClicked;
    boolean celsClicked;
    boolean kelvClicked;

    public static String MY_DATA = "my data";
    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Gets an Instance of our weather helper
        helper = WeatherSQliteOpenHelper.getInstance(this);

    preferences=getPreferences(Context.MODE_PRIVATE);
        //inserts weathers into our database
        //TODO: THIS WILL RUN ON ONCREATE EVERY TIME, USE SHAREDPREFERENCES TO MAKE IT NOT HAPPEN
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


        listView = (ListView) findViewById(R.id.listview);


        //These Click Listeners determine which type of temperature should be shown
        //TODO: Save the users preferences on shared preferences
        //TODO: Have the correct one load inside of onResume;
        fahr = (Button) findViewById(R.id.fahr_button);
        cels = (Button) findViewById(R.id.celsius_button);
        kelv = (Button) findViewById(R.id.kelvin_button);

        fahr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listView.setAdapter(null);
                setAdapter(WeatherSQliteOpenHelper.COL_TEMP_FAHR);
                fahrClicked = true && celsClicked != true && kelvClicked != true;
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(MY_DATA, WeatherSQliteOpenHelper.COL_TEMP_FAHR);
                editor.commit();
            }
        });

        cels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listView.setAdapter(null);
                setAdapter(WeatherSQliteOpenHelper.COL_TEMP_CEL);
                celsClicked = true && fahrClicked != true && kelvClicked != true;
                SharedPreferences.Editor editor =preferences.edit();
                editor.putString(MY_DATA, WeatherSQliteOpenHelper.COL_TEMP_CEL);
                editor.commit();
            }
        });
        kelv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listView.setAdapter(null);
                setAdapter(WeatherSQliteOpenHelper.COL_TEMP_KELVIN);
                kelvClicked = true && celsClicked != true && fahrClicked != true;
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(MY_DATA, WeatherSQliteOpenHelper.COL_TEMP_KELVIN);
                editor.commit();
            }
        });
    }


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

    @Override
    protected void onPause() {
        super.onPause();
        //save to shared preferences
        preferences = MainActivity.this.getSharedPreferences("sharedPrefereces", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        if (fahrClicked == true) {
            editor.putString("text", WeatherSQliteOpenHelper.COL_TEMP_FAHR);
        } else if (celsClicked == true) {
            editor.putString("text", WeatherSQliteOpenHelper.COL_TEMP_CEL);
        } else if (kelvClicked == true){
            editor.putString("text", WeatherSQliteOpenHelper.COL_TEMP_KELVIN);
        }

        editor.commit();

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (fahrClicked == true) {
            setAdapter(WeatherSQliteOpenHelper.COL_TEMP_FAHR);
        } else if (celsClicked == true) {
            setAdapter(WeatherSQliteOpenHelper.COL_TEMP_CEL);
        } else if (kelvClicked == true) {
            setAdapter(WeatherSQliteOpenHelper.COL_TEMP_KELVIN);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (fahrClicked = true) {
            setAdapter(WeatherSQliteOpenHelper.COL_TEMP_FAHR);
        } else if (celsClicked = true) {
            setAdapter(WeatherSQliteOpenHelper.COL_TEMP_CEL);
        } else if (kelvClicked = true) {
            setAdapter(WeatherSQliteOpenHelper.COL_TEMP_KELVIN);
        }
    }


}


