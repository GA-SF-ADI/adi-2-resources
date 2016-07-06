package com.example.hollis.sharedpreferenceexample;

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
    SharedPreferences sharedPreferences;
    String lastTemp;
    public static final String TEMP = "temperature measurement";
    public static final String DATA_INSERTED = "DATA INSERTED";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Gets an Instance of our weather helper
        helper = WeatherSQliteOpenHelper.getInstance(this);


        //inserts weathers into our database
        //TODO: THIS WILL RUN ON ONCREATE EVERY TIME, USE SHAREDPREFERENCES TO MAKE IT NOT HAPPEN
        sharedPreferences= getSharedPreferences("main",MODE_PRIVATE);

        boolean hasInserted =sharedPreferences.getBoolean(DATA_INSERTED, false);
        if(!hasInserted) {


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
            editor.putBoolean(DATA_INSERTED, true);
            editor.commit();
        }


        listView = (ListView) findViewById(R.id.listview);

        //These Click Listeners determine which type of temperature should be shown
        //TODO: Save the users preferences on shared preferences
        //TODO: Have the correct one load inside of onResume;
         lastTemp = sharedPreferences.getString(TEMP,"DEFAULT");
        fahr = (Button) findViewById(R.id.fahr_button);
        cels = (Button) findViewById(R.id.celsius_button);
        kelv = (Button) findViewById(R.id.kelvin_button);
        fahr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAdapter(WeatherSQliteOpenHelper.COL_TEMP_FAHR);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(TEMP, WeatherSQliteOpenHelper.COL_TEMP_FAHR);
                editor.commit();
            }
        });

        cels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAdapter(WeatherSQliteOpenHelper.COL_TEMP_CEL);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(TEMP, WeatherSQliteOpenHelper.COL_TEMP_CEL);
                editor.commit();
            }
        });
        kelv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAdapter(WeatherSQliteOpenHelper.COL_TEMP_KELVIN);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(TEMP, WeatherSQliteOpenHelper.COL_TEMP_KELVIN);
                editor.commit();
            }
        });
    }


    public void setAdapter(String curColumn){
        if(curColumn.equals(WeatherSQliteOpenHelper.COL_TEMP_CEL) ||curColumn.equals(WeatherSQliteOpenHelper.COL_TEMP_KELVIN) ||curColumn.equals(WeatherSQliteOpenHelper.COL_TEMP_FAHR)) {
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(MainActivity.this,
                    android.R.layout.simple_list_item_2,
                    helper.getTemp(curColumn),
                    new String[]{WeatherSQliteOpenHelper.COL_DAY, curColumn},
                    new int[]{android.R.id.text1, android.R.id.text2},
                    0);
            listView.setAdapter(adapter);
        }else{
            Toast.makeText(this, "Click a Button to show temperatures!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onResume() {
        setAdapter(lastTemp);
        //on resume setting the view to lastTemp
        super.onResume();
    }

    @Override
    protected void onPause() {
        SharedPreferences.Editor editor = sharedPreferences.edit();


        super.onPause();
    }
}
