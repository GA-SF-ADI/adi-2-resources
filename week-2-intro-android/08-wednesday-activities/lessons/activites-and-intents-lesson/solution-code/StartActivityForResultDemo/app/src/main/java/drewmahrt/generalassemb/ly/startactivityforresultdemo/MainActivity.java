package drewmahrt.generalassemb.ly.startactivityforresultdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button mButton;
    private TextView mText;
    private Button button;
    public static int ADD_REQUEST_CODE = 27;
    public static int SUBTRACT_REQUEST_CODE = 23;
    private int total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mText = (TextView) findViewById(R.id.text);
        mButton = (Button) findViewById(R.id.add);
        button = (Button) findViewById(R.id.subtract);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(intent, ADD_REQUEST_CODE);
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(intent, SUBTRACT_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == ADD_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                int num1 = data.getIntExtra("num1", -1);
                int num2 = data.getIntExtra("num2", -1);
                total += num1 + num2;
                mText.setText(total + "");
            }
        }
        if (requestCode == SUBTRACT_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                int num1 = data.getIntExtra("num1", -1);
                int num2 = data.getIntExtra("num2", -1);
                total -= num1 - num2;
                mText.setText(total + "");
            }
        }
    }
}
