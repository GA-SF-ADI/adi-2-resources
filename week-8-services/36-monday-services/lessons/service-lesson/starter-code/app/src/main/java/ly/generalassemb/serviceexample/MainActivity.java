package ly.generalassemb.serviceexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    protected String INTENT_KEY_SERVICE = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setViews();
    }

    @Override
    protected void onStop() {
        super.onStop();
        /**
         * TODO NOTE:
         *
         * Make sure to destroy any running services or they will run indefinitely
         * because we did not bind to them but started them!
         *
         * Think what happens if we close the app or activity but never pressed the
         * stop service buttons.
         */
    }

    private void setViews() {
        setServiceViews();
        //setIntentServiceViews();
    }

    private void setServiceViews() {
        Button startButton = (Button) findViewById(R.id.button_start);
        Button stopButton = (Button) findViewById(R.id.button_stop);
        Button activityButton =(Button) findViewById(R.id.button_activity_two);
        Button activityButtonThree =(Button) findViewById(R.id.button_activity_three);
        Button activityButtonFour =(Button) findViewById(R.id.button_activity_four);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CustomService.class);
                intent.putExtra(INTENT_KEY_SERVICE, "Starting this service from MainActivity!");
                startService(intent);
                // TODO START your CustomService here

            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO STOP your CustomService here
                Intent intent = new Intent(MainActivity.this, CustomService.class);
                stopService(intent);

            }
        });
        activityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
        activityButtonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
        activityButtonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, FourthActivity.class);
                startActivity(intent);
            }
        });


    }

//    private void setIntentServiceViews() {
//        Button startButton = (Button) findViewById(R.id.button_start_intent_service);
//        Button stopButton = (Button) findViewById(R.id.button_stop_intent_service);
//
//        startButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // TODO START your CustomIntentService here
//
//            }
//        });
//
//        stopButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // TODO STOP your CustomIntentService here
//
//            }
//        });
//}
}
