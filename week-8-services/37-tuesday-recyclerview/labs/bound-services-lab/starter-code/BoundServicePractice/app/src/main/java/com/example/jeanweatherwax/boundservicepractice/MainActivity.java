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

    //create instance of your BoundService and set isBound to False


    //make a ServiceConnection called myConnection and implement the
    //onServiceConnected and onServiceDisconnected methods.
    // You should set isBound to the appropriate value in each method.
    // Yo should also set your binder in onServiceConnected.
    // Show a Toast in each.
    private ServiceConnection myConnection = new ServiceConnection() {


    };

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //button
        Button showTimeButton = (Button) findViewById(R.id.showTimeButton);

        final Intent intent = new Intent(this, BoundService.class);
        bindService(intent, myConnection, Context.BIND_AUTO_CREATE);


        //set an onClickListened for the button to show the time


    }


    //unbind the service here in onStop
    @Override
    public void onStop() {
        super.onStop();
    }


    //in this method, get the current time using your service, and display it in the Textview.
    public void showTime(View view)
    {

    }
}
