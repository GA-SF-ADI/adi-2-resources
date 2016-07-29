package ly.generalassemb.firebasegcm;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener, GoogleApiClient.ConnectionCallbacks {
    private static final int REQUEST_CODE_LOCATION = 10;
    private static final String TAG = "MainActivity";

    private Button locationButton, mapsButton;
    private TextView locationTextView;

    private FirebaseAnalytics firebaseAnalytics;

    // Need Google Client to get location. Location variable to actually hold the location
    private GoogleApiClient mGoogleApiClient;
    private Location lastLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAnalytics = FirebaseAnalytics.getInstance(this);
        setupViews();
        setupGoogleClient();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        // The Google API client is connected!
        Log.i(TAG, "onConnected: ");
        Toast.makeText(this,"Connected...",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onConnectionSuspended(int i) {
        // Google Client connection suspended with flag i
        Log.i(TAG, "onConnectionSuspended: ");
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        // An unresolvable error has occurred and a connection to Google Client APIs
        // could not be established. Display an error message, or handle
        // the failure silently
        Log.i(TAG, "onConnectionFailed: ");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode){
            case REQUEST_CODE_LOCATION:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // location-related task you need to do.
                    saveLocation();
                    printLocation();
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                break;
            default:
                break;
        }
    }

    private void setupViews(){
        locationButton = (Button) findViewById(R.id.location_button);
        mapsButton = (Button) findViewById(R.id.maps_button);
        locationTextView = (TextView) findViewById(R.id.location_text_view);

        locationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveLocation();
                printLocation();
            }
        });

        mapsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMaps();
            }
        });
    }

    private void setupGoogleClient(){
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this /* AppCompatActivity */,
                        this /* OnConnectionFailedListener */)
                .addApi(LocationServices.API) // Access LocationServices API!
                .build();
    }

    private void saveLocation(){
        // Request location permission if we don't have it
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION},
                    REQUEST_CODE_LOCATION);
            return;
        }

        // We have location permission, lets grab the current location and save it
        lastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
    }

    private void printLocation(){
        if (lastLocation == null) {
            // We don't have location, notify user and exit
            Toast.makeText(this,"Can't find location",Toast.LENGTH_LONG).show();
            return;
        }

        // We have location, lets grab the latitude and longitude values
        double lat = lastLocation.getLatitude();
        double lon = lastLocation.getLongitude();

        String locationString = "Your latitude is: " + lat + "\nYour longitude is: " + lon;
        locationTextView.setText(locationString);

        // sends location to FireBase Analytics
        trackLocationAnalytics(locationString);

    }

    private void openMaps(){
        if (lastLocation == null){
            // We don't have location so ask the user to get it first
            Toast.makeText(this, "Please get location first!", Toast.LENGTH_SHORT).show();
            return;
        }
        // We have location, lets grab the latitude and longitude values
        double lat = lastLocation.getLatitude();
        double lon = lastLocation.getLongitude();

        Uri gmmIntentUri = Uri.parse("google.streetview:cbll=" + lat + "," + lon +"\"");

        // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        // Make the Intent explicit by setting the Google Maps package
        mapIntent.setPackage("com.google.android.apps.maps");

        // Attempt to start an activity that can handle the Intent
        startActivity(mapIntent);
    }

    private void trackLocationAnalytics(String location){
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "10"); // id of this analytic, you choose value
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, location); // this analytic, we choose to send up the string
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "location"); // type of analytic so we can search later by this time on the firebase console
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
    }
}
