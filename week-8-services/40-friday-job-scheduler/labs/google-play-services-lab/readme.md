---
title: Implementing Play Services Lab
type: lab
duration: "1:25"
creator:
    name: Drew Mahrt
    city: NYC
---
# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Implementing Play Services Lab

## Introduction


We covered implementing FireBase Analytics during the lesson along with FireBase Notifications, both extremely useful in their own right.

There are many other services, though, and one of the most popular is the **location service**.

In this lab, you will be creating an app that uses the location service to get the user's current location and prints the latitude and longitude values inside of a text view. You will also add a button that will pass this location information to Google Maps App!

## Exercise

#### Requirements

- Have a button to that will grab location and put it into a text view
- Have a button that will pass the user latitude and longitude to the Maps Application!
- Use the [location API](http://developer.android.com/training/location/retrieve-current.html) to get the user's current location
- Open [Google Maps](https://developers.google.com/maps/documentation/android-api/intents) to show the user's current location

**Bonus:**
- Display the map inside of your app rather than opening the Google Maps app

#### Starter code

No starter code!

**You should use your solutions form the independent practice exercise**. Location services requires the use of `google-services.json` file which we generated in the lesson to get FireBase Notifications and Analytics working. Re-using that code we don't have to generate another `google-services.json` file!

#### Deliverable

A working app that meets the requirements above.


#### Hints 

Please refrain from using these hints **unless you are truly stuck and spent a lot of time reading the documentation**.
These are here to keep you from spending all day on the lab.

<details>
  <summary>What to include in app gradle file</summary>
```
compile 'com.google.android.gms:play-services-location:9.2.1'
```
</details>

<details>
  <summary>What to include in AndroidManifest.xml</summary>
```xml
<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"/>
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
```
</details>

<details>
  <summary>How to setup GoogleApiClient</summary>
```java
GoogleApiClient googleApiClient = new GoogleApiClient.Builder(this) // this is the AppCompatActivity context
            .enableAutoManage(this /* AppCompatActivity contenxt instance */,
            this /* Must implement OnConnectionFailedListener */)
            .addApi(LocationServices.API) // Access LocationServices API!
            .build();
```
</details>

<details>
  <summary>How to get user's location</summary>
```java

/**
 * This assumes you have a Location lastLocation global variable in the activity.
 */
private void saveLocation(){
        // Request location permission if we don't have it. Remember you have to override onRequestPermissionResult() as well
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION},
                    REQUEST_CODE_LOCATION);
            return;
        }

        // We have location permission, lets grab the current location and save it
        lastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
    }
```
</details>


<details>
  <summary>How to handle location permission results</summary>
```java
@Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode){
            case REQUEST_CODE_LOCATION:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // location-related task you need to do.
                    saveLocation(); // save location in variable
                    printLocation(); // print the location
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                break;
            default:
                break;
        }
    }
```
</details>

<details>
  <summary>How to send latitude and longitude to Google Maps App</summary>
```java
private void openMaps(){
        if (lastLocation == null){
            // We don't have location so ask the user to get it first
            Toast.makeText(this, "Please get location first!", Toast.LENGTH_SHORT).show();
            return;
        }
        // We have location, lets grab the latitude and longitude values
        double lat = lastLocation.getLatitude();
        double lon = lastLocation.getLongitude();

        // concatenate the lat and long variables in the required format. Refer to docs.
        Uri gmmIntentUri = Uri.parse("google.streetview:cbll=" + lat + "," + lon +"\"");

        // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        
        // Make the Intent explicit by setting the Google Maps package
        mapIntent.setPackage("com.google.android.apps.maps");

        // Attempt to start an activity that can handle the Intent
        startActivity(mapIntent);
    }
```
</details>

## Additional Resources

- [Using the locations service](http://developer.android.com/training/location/retrieve-current.html)
- [Requesting Permissions](http://developer.android.com/training/permissions/requesting.html)
- [Google Maps Intent](https://developers.google.com/maps/documentation/android-api/intents)
