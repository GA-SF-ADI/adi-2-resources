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
    private String curCol;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listview);

        helper = WeatherSQliteOpenHelper.getInstance(this);

        sharedPreferences = getPreferences(Context.MODE_PRIVATE);


        //looked at answers and saw that you made an editor everytime you used one. is that needed?
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        String units = sharedPreferences.getString("pick", "default");
        boolean add = sharedPreferences.getBoolean("add", false);


        //i needed to take a peak at the solution code for this. I would have never figured this out.
        //can we have some examples like this where you can show different/creative ways to use certain topics.
        //i didn't even know this was possible.
        if (!add) {

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
            editor.putBoolean("add",true);
            editor.commit();
        }


        if(!units.equals("default")){
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(MainActivity.this,
                    android.R.layout.simple_list_item_2,
                    helper.getTemp(units),
                    new String[]{WeatherSQliteOpenHelper.COL_DAY, units},
                    new int[] {android.R.id.text1, android.R.id.text2},
                    0);
            listView.setAdapter(adapter);

        }

        //These Click Listeners determine which type of temperature should be shown
        //TODO: Save the users preferences on shared preferences
        //TODO: Have the correct one load up onCreate or onResume;
        fahr = (Button) findViewById(R.id.fahr_button);
        cels = (Button) findViewById(R.id.celsius_button);
        kelv = (Button) findViewById(R.id.kelvin_button);
        fahr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleCursorAdapter adapter = new SimpleCursorAdapter(MainActivity.this,
                        android.R.layout.simple_list_item_2,
                        helper.getTemp("Fahrenheit"),
                        new String[]{WeatherSQliteOpenHelper.COL_DAY, WeatherSQliteOpenHelper.COL_TEMP_FAHR},
                        new int[] {android.R.id.text1, android.R.id.text2},
                        0);
                editor.putString("pick",WeatherSQliteOpenHelper.COL_TEMP_FAHR);
                editor.commit();
//                curCol = WeatherSQliteOpenHelper.COL_TEMP_FAHR
                listView.setAdapter(adapter);
            }
        });

        cels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleCursorAdapter adapter = new SimpleCursorAdapter(MainActivity.this,
                        android.R.layout.simple_list_item_2,
                        helper.getTemp("Celsius"),
                        new String[]{WeatherSQliteOpenHelper.COL_DAY, WeatherSQliteOpenHelper.COL_TEMP_CEL},
                        new int[] {android.R.id.text1, android.R.id.text2},
                        0);
                editor.putString("pick",WeatherSQliteOpenHelper.COL_TEMP_CEL);
                editor.commit();
//                curCol = WeatherSQliteOpenHelper.COL_TEMP_CEL;
                listView.setAdapter(adapter);
            }
        });
        kelv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleCursorAdapter adapter = new SimpleCursorAdapter(MainActivity.this,
                        android.R.layout.simple_list_item_2,
                        helper.getTemp("Kelvin"),
                        new String[]{WeatherSQliteOpenHelper.COL_DAY, WeatherSQliteOpenHelper.COL_TEMP_KELVIN},
                        new int[] {android.R.id.text1, android.R.id.text2},
                        0);
                editor.putString("pick",WeatherSQliteOpenHelper.COL_TEMP_KELVIN);
                editor.commit();
//                curCol = WeatherSQliteOpenHelper.COL_TEMP_KELVIN;
                listView.setAdapter(adapter);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putString("curColumn", curCol);
//        editor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
//        curCol = sharedPreferences.getString("curColumn","default");
//        if(!curCol.equals("default")){
//            setAdapter(curCol);
//        }
    }
}
