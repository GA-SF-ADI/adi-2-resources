package com.example.jeanweatherwax.boundservicepractice;


import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    //create instance of your BoundService and set isBound to False
    BoundService mService;
    boolean isBound = false;

    //make a ServiceConnection called myConnection and implement the
    //onServiceConnected and onServiceDisconnected methods.
    // You should set isBound to the appropriate value in each method.
    // Yo should also set your binder in onServiceConnected.
    // Show a Toast in each.
    private ServiceConnection myConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder service) {
            Intent intent = new Intent(MainActivity.this, BoundService.class);
            bindService(intent, myConnection, Context.BIND_AUTO_CREATE);

            BoundService.MyLocalBinder binder = (BoundService.MyLocalBinder) service;
            mService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            isBound = false;
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //button
        final Button showTimeButton = (Button) findViewById(R.id.showTimeButton);

        final Intent intent = new Intent(this, BoundService.class);
        bindService(intent, myConnection, Context.BIND_AUTO_CREATE);


        //set an onClickListened for the button to show the time
        showTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTime(view);
            }
        });

    }


    //unbind the service here in onStop
    @Override
    public void onStop() {
        super.onStop();

        if (isBound) {
            unbindService(myConnection);
            isBound = false;
        }
    }


    //in this method, get the current time using your service, and display it in the Textview.
    public void showTime(View view) {
        TextView myTextView = (TextView)findViewById(R.id.myTextView);
        myTextView.setText(mService.getCurrentTime());
    }
}
