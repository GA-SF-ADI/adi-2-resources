package ly.generalassemb.drewmahrt.saveactivitycreationtime;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    String mTimeStarted;
    SharedPreferences sharedPreferences;
    public static String TIME_KEY = "time key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //GET SHARED PREFERENCES
        sharedPreferences = getSharedPreferences("MainActivity", Context.MODE_PRIVATE);
        //GET time from shared preferences
        mTimeStarted = sharedPreferences.getString(TIME_KEY, "no time started");

        //if there is a saved instance state "timeStarted"
        // will create a saved instance state
        // if(savedInstanceState != null) {
        //checking if we already loaded mTimeStarted
        //if not equals "no time started" we know we got a good time
        //otherwise, we need to get the time
        if (!mTimeStarted.equals("no time started")) {
            // mTimeStarted = savedInstanceState.getString("timeStarted");
            TextView textView = (TextView) findViewById(R.id.text);
            textView.setText(mTimeStarted);
        } else

        {
            mTimeStarted = Calendar.getInstance().getTime().toString();
            //create editor for shared preferences
            SharedPreferences.Editor editor = sharedPreferences.edit();

            //put string into editor
            editor.putString(TIME_KEY, mTimeStarted);


            TextView textView = (TextView) findViewById(R.id.text);
            textView.setText(mTimeStarted);

            //commit changes
            editor.commit();

        }
    }
}

// we saved an instance state
//"timeStarted" is the key
//mTimeStarted is the value
/*
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("timeStarted",mTimeStarted);
        super.onSaveInstanceState(outState);
    }
    */

