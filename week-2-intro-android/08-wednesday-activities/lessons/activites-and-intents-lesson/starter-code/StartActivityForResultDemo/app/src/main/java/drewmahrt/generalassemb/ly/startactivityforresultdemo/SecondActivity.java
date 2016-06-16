package drewmahrt.generalassemb.ly.startactivityforresultdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
    Button mButton;
    EditText mFirstNameText, mLastNameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mFirstNameText = (EditText)findViewById(R.id.first_name);
        mLastNameText = (EditText)findViewById(R.id.last_name);

        mButton = (Button)findViewById(R.id.close_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String firstName = mFirstNameText.getText().toString();
                String lastName = mLastNameText.getText().toString();
                Intent results = new Intent();
                // We need this intent to pass data between 2 activities
                results.putExtra("firstName", firstName);
                //these are key value pairs
                results.putExtra("lastName", lastName);
                setResult(RESULT_OK, results);
                //gets us ready to go back to the acitvity
                finish();
                //that means it goes back to the activity that you just came from
            }
        });
    }
}
