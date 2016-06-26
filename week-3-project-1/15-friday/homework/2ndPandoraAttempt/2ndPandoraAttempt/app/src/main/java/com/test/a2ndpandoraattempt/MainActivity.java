package com.test.a2ndpandoraattempt;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Random ran = new Random();
        int randomNum = ran.nextInt(2016 - 2010) + 2010;

        Station stationObject = new Station("Prince", 2015);


        stationObject.setYearWhenListenedTo(randomNum);

        CustomStationAdapter stationAdapter

    }
}
