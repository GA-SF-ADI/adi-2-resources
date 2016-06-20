package ly.generalassemb.drewmahrt.buttonenabling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox mAgreeCheckBox;
    Button mAgreeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAgreeCheckBox = (CheckBox) findViewById(R.id.agree_check_box);
        mAgreeButton = (Button) findViewById(R.id.agree_button);

        //Call setOnCheckedChangeListener on the mAgreeCheckBox, and complete the listener
        /**
         * Call setOnCheckedChangeListener on the mAgreeCheckBox, and complete the listener
         *
         * In the handler, disable the button using setEnabled(false). Pass in true to re-enable.
         */

        mAgreeCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    mAgreeButton.setEnabled(true);
                    Toast.makeText(MainActivity.this, "Registration now available!", Toast.LENGTH_SHORT).show();

                } else {
                    mAgreeButton.setEnabled(false);
                    Toast.makeText(MainActivity.this, "We're sorry, but registration is no longer available :(", Toast.LENGTH_SHORT).show();


                }


            }


        });

    }

}