package co.ga.helloworld;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//********************************************
        final Button blueButton = (Button) findViewById(R.id.b1);
        View.OnClickListener blueButtonOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) findViewById(R.id.txt);
                textView.setTextColor(Color.BLUE);
                textView.setText("BLUE");
            }
        };
        blueButton.setOnClickListener(blueButtonOnClickListener);
//*********************************************

        final Button pinkButton = (Button) findViewById(R.id.b2);
        View.OnClickListener pinkButtonOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) findViewById(R.id.txt);
                textView.setTextColor(Color.RED);
                textView.setText("RED");
            }
        };
        pinkButton.setOnClickListener(pinkButtonOnClickListener);
//***********************************************

        final Button greenButton = (Button) findViewById(R.id.b3);
        View.OnClickListener greenButtonOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) findViewById(R.id.txt);
                textView.setTextColor(Color.GREEN);
                textView.setText("GREEN");
            }
        };
        greenButton.setOnClickListener(greenButtonOnClickListener);
//************************************************

        final TextView txtView = (TextView) findViewById(R.id.txt);
        View.OnClickListener textViewOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtView.getText().toString().equals("BLUE")) {
                    blueButton.setBackgroundColor(Color.BLUE);
                    pinkButton.setBackgroundColor(Color.BLUE);
                    greenButton.setBackgroundColor(Color.BLUE);
                } else if (txtView.getText().toString().equals("RED")) {
                    blueButton.setBackgroundColor(Color.RED);
                    pinkButton.setBackgroundColor(Color.RED);
                    greenButton.setBackgroundColor(Color.RED);
                } else if (txtView.getText().toString().equals("GREEN")) {
                    blueButton.setBackgroundColor(Color.GREEN);
                    pinkButton.setBackgroundColor(Color.GREEN);
                    greenButton.setBackgroundColor(Color.GREEN);
                }
            }
        };
        txtView.setOnClickListener(textViewOnClickListener);
    }
}
