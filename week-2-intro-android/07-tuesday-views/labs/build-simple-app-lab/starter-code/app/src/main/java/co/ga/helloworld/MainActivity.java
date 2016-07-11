package co.ga.helloworld;

import android.graphics.Color;
import android.nfc.Tag;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button yellowButton = (Button) findViewById(R.id.buttonYellow);

        View.OnClickListener myOnClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Log.v(TAG, "We've pressed a button");
                RelativeLayout relativeLayout = (RelativeLayout) findViewById((R.id.relativeView));
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.setTextColor(Color.CYAN);
                relativeLayout.setBackgroundColor(Color.YELLOW);
            }
        };

        yellowButton.setOnClickListener(myOnClickListener);

        Button blueButton = (Button) findViewById(R.id.buttonBlue);

        View.OnClickListener mySecondOnClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                TextView textView = (TextView) findViewById(R.id.textView);
                RelativeLayout relativeLayout = (RelativeLayout) findViewById((R.id.relativeView));
                textView.setTextColor(Color.YELLOW);
                relativeLayout.setBackgroundColor(Color.BLUE);
            }
        };


        blueButton.setOnClickListener(mySecondOnClickListener);

        Button turquoiseButton = (Button) findViewById(R.id.buttonTurquoise);

        View.OnClickListener myThirdOnClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                TextView textView = (TextView) findViewById(R.id.textView);
                RelativeLayout relativeLayout = (RelativeLayout) findViewById((R.id.relativeView));
                int turquoise = ContextCompat.getColor(MainActivity.this, R.color.Turquoise);
                relativeLayout.setBackgroundColor(getResources().getColor(R.color.Turquoise));
                textView.setTextColor(Color.BLUE);

            }
        };


        turquoiseButton.setOnClickListener(myThirdOnClickListener);

    }
}


