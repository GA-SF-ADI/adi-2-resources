package ly.generalassemb.drewmahrt.saveactivitycreationtime;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    String mTimeStarted;

    @Override
    //check to see if anything has been saved into the bundle
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null) {
            mTimeStarted = savedInstanceState.getString("timeStarted");
            TextView textView = (TextView)findViewById(R.id.text);
            textView.setText(mTimeStarted);
        } else {
            //calendar built into android.  will want to use if we include the time in our apps
            mTimeStarted = Calendar.getInstance().getTime().toString();
        }

        TextView textView = (TextView)findViewById(R.id.text);
        textView.setText(mTimeStarted);

    }

    @Override
    //take value and save it into the bundle.  save time into the bundle
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("timeStarted",mTimeStarted);
        super.onSaveInstanceState(outState);
    }
}
