package com.example.hollis.sharedpreferenceexample;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    WeatherSQliteOpenHelper helper;
    Button fahr;
    Button cels;
    Button kelv;
    SharedPreferences sharedPreferences;
    public static String sharedPrefsKey = "sharedPrefKey";
    public static String initializedWeatherKey = "weatherKey";
    public static String prefferedTempKey = "tempTypeKey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences(sharedPrefsKey, Context.MODE_PRIVATE);

        //Gets an Instance of our weather helper
        helper = WeatherSQliteOpenHelper.getInstance(this);


        //inserts weathers into our database
        //TODO: THIS WILL RUN ON ONCREATE EVERY TIME, USE SHAREDPREFERENCES TO MAKE IT NOT HAPPEN
        Boolean weatherInitialized;

        weatherInitialized = sharedPreferences.getBoolean(initializedWeatherKey, false);
        if (!weatherInitialized){
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
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(initializedWeatherKey, true);
            editor.commit();
        }


        listView = (ListView) findViewById(R.id.listview);

        //These Click Listeners determine which type of temperature should be shown
        //TODO: Save the users preferences on shared preferences

        String preferredType=sharedPreferences.getString(prefferedTempKey, "none");
        //TODO: Have the correct one load up onCreate or onResume;
        fahr = (Button) findViewById(R.id.fahr_button);
        cels = (Button) findViewById(R.id.celsius_button);
        kelv = (Button) findViewById(R.id.kelvin_button);
        if (preferredType.equals("f")){
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(MainActivity.this,
                    android.R.layout.simple_list_item_2,
                    helper.getTemp("fahrenheit"),
                    new String[]{WeatherSQliteOpenHelper.COL_DAY, WeatherSQliteOpenHelper.COL_TEMP_FAHR},
                    new int[] {android.R.id.text1, android.R.id.text2},
                    0);
            listView.setAdapter(adapter);
        }else if (preferredType.equals("c")){
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(MainActivity.this,
                    android.R.layout.simple_list_item_2,
                    helper.getTemp("celsius"),
                    new String[]{WeatherSQliteOpenHelper.COL_DAY, WeatherSQliteOpenHelper.COL_TEMP_CEL},
                    new int[] {android.R.id.text1, android.R.id.text2},
                    0);
            listView.setAdapter(adapter);

        }else if (preferredType.equals("k")){
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(MainActivity.this,
                    android.R.layout.simple_list_item_2,
                    helper.getTemp("kelvin"),
                    new String[]{WeatherSQliteOpenHelper.COL_DAY, WeatherSQliteOpenHelper.COL_TEMP_KELVIN},
                    new int[] {android.R.id.text1, android.R.id.text2},
                    0);
            listView.setAdapter(adapter);
        }

        fahr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleCursorAdapter adapter = new SimpleCursorAdapter(MainActivity.this,
                        android.R.layout.simple_list_item_2,
                        helper.getTemp("fahrenheit"),
                        new String[]{WeatherSQliteOpenHelper.COL_DAY, WeatherSQliteOpenHelper.COL_TEMP_FAHR},
                        new int[] {android.R.id.text1, android.R.id.text2},
                        0);
                listView.setAdapter(adapter);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(prefferedTempKey, "f");
                editor.commit();
            }
        });

        cels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleCursorAdapter adapter = new SimpleCursorAdapter(MainActivity.this,
                        android.R.layout.simple_list_item_2,
                        helper.getTemp("celsius"),
                        new String[]{WeatherSQliteOpenHelper.COL_DAY, WeatherSQliteOpenHelper.COL_TEMP_CEL},
                        new int[] {android.R.id.text1, android.R.id.text2},
                        0);
                listView.setAdapter(adapter);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(prefferedTempKey, "c");
                editor.commit();
            }
        });
        kelv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleCursorAdapter adapter = new SimpleCursorAdapter(MainActivity.this,
                        android.R.layout.simple_list_item_2,
                        helper.getTemp("kelvin"),
                        new String[]{WeatherSQliteOpenHelper.COL_DAY, WeatherSQliteOpenHelper.COL_TEMP_KELVIN},
                        new int[] {android.R.id.text1, android.R.id.text2},
                        0);
                listView.setAdapter(adapter);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(prefferedTempKey, "k");
                editor.commit();
            }
        });
    }
}
