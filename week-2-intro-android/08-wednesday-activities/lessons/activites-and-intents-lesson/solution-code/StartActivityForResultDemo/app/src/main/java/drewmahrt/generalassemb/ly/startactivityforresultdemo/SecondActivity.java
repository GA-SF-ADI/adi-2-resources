package drewmahrt.generalassemb.ly.startactivityforresultdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
    Button mButton;
    EditText mFirstNumText, mSecondNumText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mFirstNumText = (EditText)findViewById(R.id.number1);
        mSecondNumText = (EditText)findViewById(R.id.number2);

        mButton = (Button)findViewById(R.id.close_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number1 = mFirstNumText.getText().toString();
                String number2 = mSecondNumText.getText().toString();
                int num1 = Integer.parseInt(number1);
                int num2 = Integer.parseInt(number2);
                Intent intent = new Intent();
                intent.putExtra("num1", num1);
                intent.putExtra("num2", num2);
                setResult(RESULT_OK, intent);
                finish();

            }
        });
    }
}
