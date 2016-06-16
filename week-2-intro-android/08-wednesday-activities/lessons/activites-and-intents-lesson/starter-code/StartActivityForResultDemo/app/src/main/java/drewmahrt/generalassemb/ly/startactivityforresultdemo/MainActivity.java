package drewmahrt.generalassemb.ly.startactivityforresultdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    private Button mButton;
    private TextView mText;
    public static int REQUEST_CODE = 27;
    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mText = (TextView)findViewById(R.id.text);

        mButton = (Button)findViewById(R.id.button);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(myIntent, REQUEST_CODE);
            }
        });
    }

    @Override

    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
                                     if(requestCode == REQUEST_CODE){
                                         if (resultCode == RESULT_OK) {
                                             String firstName = data.getStringExtra("firstName");
                                             String lastName = data.getStringExtra("lastName");
                                             mText.setText(firstName + " " + lastName);

                                         }

            }
        }
    }