package com.test.networkinginandroidpractice;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static String weatherUrl = "";
    EditText editText;
    Button cityButton;
    TextView cityView, weatherDescriptionView, humidityView, pressureView, temperatureView;
    String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.edit_user);
        cityButton = (Button) findViewById(R.id.city_button);

        cityView = (TextView) findViewById(R.id.city_name);
        weatherDescriptionView = (TextView) findViewById(R.id.weather_descrip);
        humidityView = (TextView) findViewById(R.id.humidity);
        pressureView = (TextView) findViewById(R.id.pressure);
        temperatureView = (TextView) findViewById(R.id.temperature);

       cityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userName = editText.getText().toString();
                //getUserInfo(userName);
            }
        });
    }

    public void getWeather(String weatherInfo) {

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            // the connection is available
        } else {
            Toast.makeText(MainActivity.this, "Connect to WIFI", Toast.LENGTH_SHORT).show();
        }

    }
}
