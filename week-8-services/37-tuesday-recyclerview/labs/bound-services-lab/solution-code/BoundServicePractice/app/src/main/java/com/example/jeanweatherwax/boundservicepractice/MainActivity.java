package com.example.jeanweatherwax.boundservicepractice;


import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
    BoundService myService;
    boolean isBound = false;


    private ServiceConnection myConnection = new ServiceConnection() {

        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            Toast.makeText(MainActivity.this, "Service Connected!", Toast.LENGTH_SHORT).show();
            BoundService.MyLocalBinder binder = (BoundService.MyLocalBinder) service;
            myService = binder.getService();
            isBound = true;
        }

        public void onServiceDisconnected(ComponentName arg0) {
            //should not get here unless there is an unexpected disconnect
           Toast.makeText(MainActivity.this, "Service Disconnected!", Toast.LENGTH_SHORT).show();
            isBound = false;
        }

    };

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //button
        Button showTimeButton = (Button) findViewById(R.id.showTimeButton);

        final Intent intent = new Intent(this, BoundService.class);
        bindService(intent, myConnection, Context.BIND_AUTO_CREATE);


        showTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTime(view);
            }
        });

    }


    @Override
    public void onStop() {
        super.onStop();
        if(isBound) {
            unbindService(myConnection);
        }

    }


    public void showTime(View view)
    {
        String currentTime = myService.getCurrentTime();
        TextView myTextView = (TextView)findViewById(R.id.myTextView);
        myTextView.setText(currentTime);
    }
}
