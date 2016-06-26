package com.test.a2ndpandoraattempt;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addStationButton = (Button) findViewById(R.id.button_add_station);

        ListView listOfStations = (ListView) findViewById(R.id.listView_list_of_stations);

        ArrayList<Station> arrayOfStations = new ArrayList<>();

        Random ran = new Random();
        int randomNum = ran.nextInt(2016 - 2010) + 2010;

        Station stationObject = new Station("Prince", 2015);

        stationObject.setYearWhenListenedTo(randomNum);

        CustomStationAdapter stationAdapter = new CustomStationAdapter(MainActivity.this, )

    }
}
