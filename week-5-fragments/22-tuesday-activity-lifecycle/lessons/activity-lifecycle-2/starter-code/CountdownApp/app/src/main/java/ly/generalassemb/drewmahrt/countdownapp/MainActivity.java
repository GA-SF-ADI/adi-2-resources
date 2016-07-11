package ly.generalassemb.drewmahrt.countdownapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CountDownTimer mCountDownTimer;
    TextView mTimeLeftTextView;
    long mTimeLeft;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getPreferences(Context.MODE_PRIVATE);

        mTimeLeftTextView = (TextView) findViewById(R.id.time_left);

        mTimeLeft = 30000;
        //create countdown timer


        Button dialogButton = (Button) findViewById(R.id.dialog_button);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        //save to shared preferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong("timeleft", mTimeLeft);
        editor.commit();


        mCountDownTimer.cancel();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //shared preferences to save
        long tempLong = sharedPreferences.getLong("timeleft", -1);
        if(tempLong != -1){
            mTimeLeft = tempLong;
        }


        mCountDownTimer = new CountDownTimer(mTimeLeft, 1000) {
            //countdown timer is an abstract class
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeft = millisUntilFinished;
                mTimeLeftTextView.setText("I have " + millisUntilFinished / 1000 + " seconds left in the act.");
                Log.d("Main Activity", "I have " + millisUntilFinished / 1000 + " seconds left in the act.");
            }

            @Override
            public void onFinish() {
                mTimeLeftTextView.setText("Finished!");
            }
        };
        //must remember to start it!
        mCountDownTimer.start();
    }
}

//if you want to save when it rotates, ou can "onSaveInstanceState"

//now it will save even if you leave the app