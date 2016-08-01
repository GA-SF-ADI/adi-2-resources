package com.sterling.maplab;

import android.content.Intent;
import android.os.Bundle;
import android.content.Context;
import android.location.Criteria;
import android.location.LocationListener;
import android.location.LocationManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Location implements LocationListener {

    private TextView txtLat;
    private TextView txtLong;
    private LocationManager locationManager;
    private String provider;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location);
        txtLat = (TextView) findViewById(R.id.txtLat);
        txtLong = (TextView) findViewById(R.id.txtLong);


        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);


        Criteria criteria = new Criteria();
        provider = locationManager.getBestProvider(criteria, false);
        android.location.Location location = locationManager.getLastKnownLocation(provider);



        Button mapButton = (Button) findViewById(R.id.launchmapbutton);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double sendlat = location.getLatitude();
                double sendlong = location.getLongitude();

                Intent i = new Intent(Location.this, MapsActivity.class);

               //sending coordinates to map activity
                Bundle params = new Bundle();
                params.putDouble("lat", sendlat);
                params.putDouble("long", sendlong);
                i.putExtras(params);
                startActivity(i);



            }

        });
    }

    // Start updates when app starts/resumes
    @Override
    protected void onResume() {
        super.onResume();

        locationManager.requestLocationUpdates(provider, 500, 1, this);
    }

    // pause the location manager when app is paused/stopped
    @Override
    protected void onPause() {
        super.onPause();
        locationManager.removeUpdates(this);
    }

    @Override
    public void onLocationChanged(android.location.Location location) {
        double lat = location.getLatitude();
        double lng = location.getLongitude();
        txtLat.setText(String.valueOf(lat));
        txtLong.setText(String.valueOf(lng));

    }

}
