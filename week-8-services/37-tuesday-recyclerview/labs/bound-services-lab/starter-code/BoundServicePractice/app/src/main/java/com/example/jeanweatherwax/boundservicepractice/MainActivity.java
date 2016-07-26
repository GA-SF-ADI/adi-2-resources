package com.example.jeanweatherwax.boundservicepractice;


import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    BoundService mService = new BoundService();
    TextView showTimeTextView;
    boolean mBound;


    //create instance of your BoundService and set isBound to False


    //make a ServiceConnection called myConnection and implement the
    //onServiceConnected and onServiceDisconnected methods.
    // You should set isBound to the appropriate value in each method.
    // Yo should also set your binder in onServiceConnected.
    // Show a Toast in each.
    protected ServiceConnection myConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName className, IBinder service) {
          BoundService.MyLocalBinder binder = (BoundService.MyLocalBinder) service;
            mService=binder.getService();
            Toast.makeText(MainActivity.this, "onServiceConnected", Toast.LENGTH_SHORT).show();
            mBound = true;
        }

        public void onServiceDisconnected(ComponentName className) {
            //Log.e(TAG, "onServiceDisconnected");
            Toast.makeText(MainActivity.this, "onServiceDisonnected", Toast.LENGTH_SHORT).show();
            mBound = false;
        }

    };

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //button
        final Button showTimeButton = (Button) findViewById(R.id.showTimeButton);
        showTimeTextView = (TextView) findViewById(R.id.myTextView);

        final Intent intent = new Intent(this, BoundService.class);
        bindService(intent, myConnection, Context.BIND_AUTO_CREATE);

        //set an onClickListened for the button to show the time
        showTimeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
            showTime(showTimeTextView);
            }
        });
    }


    //unbind the service here in onStop
    @Override
    public void onStop() {
        super.onStop();
        Toast.makeText(MainActivity.this, "onStop", Toast.LENGTH_SHORT).show();
        if (mBound) {
            unbindService(myConnection);
            mBound = false;
        }
    }


    //in this method, get the current time using your service, and display it in the Textview.
    public void showTime(View view) {

        String time = mService.getCurrentTime();
        showTimeTextView.setText(time);
        Toast.makeText(MainActivity.this, "time", Toast.LENGTH_SHORT).show();
    }
}
