package ly.generalassemb.drewmahrt.saveactivitycreationtime;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.SharedPreferences.Editor;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    String mTimeStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        TextView textView = (TextView)findViewById(R.id.text);
        textView.setText(mTimeStarted);
    }
}
