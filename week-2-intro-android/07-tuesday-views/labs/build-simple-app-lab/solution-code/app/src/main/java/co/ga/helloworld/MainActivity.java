package co.ga.helloworld;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create references to the views inside of activity_main

        Button blueButton = (Button) findViewById(R.id.blue_button);
        Button purpleButton = (Button) findViewById(R.id.purple_button);
        Button grayButton = (Button) findViewById(R.id.gray_button);

        // Set three OnClickListeners to the three buttons

        blueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) findViewById(R.id.textView);

                textView.setText("Blue");
                textView.setTextColor(Color.BLUE);
            }
        });

        purpleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) findViewById(R.id.textView);

                textView.setText("Purple");
                textView.setTextColor(Color.MAGENTA);
            }
        });

        grayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) findViewById(R.id.textView);

                textView.setText("Gray");
                textView.setTextColor(Color.GRAY);
            }
        });

    }
}
