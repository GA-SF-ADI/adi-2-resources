package ly.generalassemb.drewmahrt.countdownapp;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CountDownTimer mCountDownTimer;
    TextView mTimeLeftTextView;
    long mTimeLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTimeLeftTextView = (TextView)findViewById(R.id.time_left);

        mTimeLeft = 30000;

        Button dialogButton = (Button)findViewById(R.id.dialog_button);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(i);
            }
        });
    }
}
