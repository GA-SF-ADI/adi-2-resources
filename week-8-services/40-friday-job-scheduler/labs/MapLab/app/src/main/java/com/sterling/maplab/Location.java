package com.sterling.maplab;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Location extends MainActivity implements LocationListener {

    private TextView txtLat;
    private TextView txtLong;
    private LocationManager locationManager;
    private String provider;
    //private static final String FINE_PERMISSION = Manifest.permission.ACCESS_FINE_LOCATION;
    //private static final String COARSE_PERMISSION = Manifest.permission.ACCESS_COARSE_LOCATION;
    private static final int PERMISSION_REQUEST_CODE = 12345;





    @Override
    @TargetApi(23)
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                    PERMISSION_REQUEST_CODE);
        } else if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {


            setContentView(R.layout.location);
            txtLat = (TextView) findViewById(R.id.txtLat);
            txtLong = (TextView) findViewById(R.id.txtLong);


            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            Criteria criteria = new Criteria();
            provider = locationManager.getBestProvider(criteria, false);
            android.location.Location location = locationManager.getLastKnownLocation(provider);


            Button mapButton = (Button) findViewById(R.id.launchmapbutton);
            final double sendlat = location.getLatitude();
            final double sendlong = location.getLongitude();

            mapButton.setOnClickListener(new View.OnClickListener() {


                @Override
                @TargetApi(23)
                public void onClick(View v) {


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
    }

    // Start updates when app starts/resumes
    @Override
    @TargetApi(23)
    protected void onResume() {
        super.onResume();



            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                        PERMISSION_REQUEST_CODE);


            } else if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                locationManager.requestLocationUpdates(provider, 500, 1, this);
            }


        }

    // pause the location manager when app is paused/stopped
    @Override
    @TargetApi(23)
    protected void onPause() {
        super.onPause();
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                    PERMISSION_REQUEST_CODE);

        } else if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
        locationManager.removeUpdates(this);
    }}



    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    @Override
    public void onLocationChanged(android.location.Location location) {
        double lat = location.getLatitude();
        double lng = location.getLongitude();
        txtLat.setText(String.valueOf(lat));
        txtLong.setText(String.valueOf(lng));

    }








}
