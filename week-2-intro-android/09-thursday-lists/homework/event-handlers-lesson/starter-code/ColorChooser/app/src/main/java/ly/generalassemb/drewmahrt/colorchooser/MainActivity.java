package ly.generalassemb.drewmahrt.colorchooser;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView sampleText = (TextView) findViewById(R.id.sample_text);

        Button blackTextButton = (Button) findViewById(R.id.black_text);
        Button greenTextButton = (Button) findViewById(R.id.green_text);
        Button redTextButton = (Button) findViewById(R.id.red_text);
        Button whiteTextButton = (Button) findViewById(R.id.white_text);

        Button blackBackButton = (Button) findViewById(R.id.black_back);
        Button greenBackButton = (Button) findViewById(R.id.green_back);
        Button redBackButton = (Button) findViewById(R.id.red_back);
        Button whiteBackButton = (Button) findViewById(R.id.white_back);

        //TODO: Implement the listener for the TextView to reset all to black text and white background
        sampleText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sampleText.setTextColor(Color.BLACK);
                sampleText.setBackgroundColor(Color.WHITE);
            }
        });


        //Implement all of the button listeners
        blackTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sampleText.setTextColor(Color.BLACK);
            }
        });

        blackBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sampleText.setBackgroundColor(Color.BLACK);
            }
        });

        greenBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sampleText.setBackgroundColor(Color.GREEN);
            }
        });
        greenTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sampleText.setTextColor(Color.GREEN);
            }
        });
        redBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sampleText.setBackgroundColor(Color.RED);
            }
        });
        redTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sampleText.setTextColor(Color.RED);
            }
        });
        whiteBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sampleText.setBackgroundColor(Color.WHITE);
            }
        });
        whiteTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sampleText.setTextColor(Color.WHITE);
            }
        });


        // TODO handle the rest of the colors


    }
}
