package ly.generalassemb.drewmahrt.hellonamesavestate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String mName;
    private int mTimesSaved;
    private EditText mNameEditText;
    private TextView mHelloTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameEditText = (EditText)findViewById(R.id.name_edit_text);
        mHelloTextView = (TextView)findViewById(R.id.hello_message_text);

        //TODO: Restore the state here

//Sterling name goes into the bundle
        Button nameSubmitButton = (Button) findViewById(R.id.name_submit_button);
        nameSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mName = mNameEditText.getText().toString();
                if (mName.length() > 0) {
                    mTimesSaved++;
                    mHelloTextView.setText("Hello "+mName+"! You will be saved into the bundle! "+mTimesSaved+" names have been saved.");
                }
            }
        });
    }

    @Override
    //puts the number of names saved inside of the bundle.
    //shows how to "persist" data by using a bundle, very cool
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("number of names saved",mTimesSaved);
        super.onSaveInstanceState(outState);
    }
    }

