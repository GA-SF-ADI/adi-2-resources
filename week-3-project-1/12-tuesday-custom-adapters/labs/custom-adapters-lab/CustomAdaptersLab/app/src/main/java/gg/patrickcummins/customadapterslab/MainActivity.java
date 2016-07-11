package gg.patrickcummins.customadapterslab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import static android.R.id.list;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<Forecast> forecastArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.weatherListView);
        forecastArrayList = new ArrayList<Forecast>();

        forecastArrayList.add(new Forecast("80", "70", "Sunny"));
        forecastArrayList.add(new Forecast("80", "70", "Sunny"));
        forecastArrayList.add(new Forecast("68", "60", "Raining"));
        forecastArrayList.add(new Forecast("40", "20", "Snowy"));
        forecastArrayList.add(new Forecast("120", "120", "Dead"));

        CustomAdapter customAdapter = new CustomAdapter(MainActivity.this, forecastArrayList);

        listView.setAdapter(customAdapter);

    }
}
