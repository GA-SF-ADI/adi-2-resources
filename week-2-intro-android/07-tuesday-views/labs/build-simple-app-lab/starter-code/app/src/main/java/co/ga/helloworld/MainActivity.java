package co.ga.helloworld;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button myButton1 = (Button) findViewById(R.id.button1);
        Button myButton2 = (Button) findViewById(R.id.button2);
        Button myButton3 = (Button) findViewById(R.id.button3);
        TextView colorChange = (TextView) findViewById(R.id.textView);

        View.OnClickListener myOnClickListener1 = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.setTextColor(Color.BLUE);
                textView.setText("Blue");
                RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
                relativeLayout.setBackgroundColor(Color.YELLOW);
            }
        };

        myButton1.setOnClickListener(myOnClickListener1);

        View.OnClickListener myOnClickListener2 = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.setTextColor(Color.MAGENTA);
                textView.setText("Purple");
                RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
                relativeLayout.setBackgroundColor(Color.GREEN);
            }
        };

        myButton2.setOnClickListener(myOnClickListener2);

        View.OnClickListener myOnClickListener3 = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.setTextColor(Color.GRAY);
                textView.setText("Gray");
                RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
                relativeLayout.setBackgroundColor(Color.DKGRAY);
            }
        };

        myButton3.setOnClickListener(myOnClickListener3);

        /*View.OnClickListener myOnClickListener4 = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if()
                myButton1.setBackgroundColor(Color.GRAY);
            }

        };

        colorChange.setOnClickListener(myOnClickListener4);*/

    }
}
