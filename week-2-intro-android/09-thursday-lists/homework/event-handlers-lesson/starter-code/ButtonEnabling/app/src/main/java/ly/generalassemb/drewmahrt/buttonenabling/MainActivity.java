package ly.generalassemb.drewmahrt.buttonenabling;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {
    CheckBox mAgreeCheckBox;
    Button mAgreeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAgreeCheckBox = (CheckBox)findViewById(R.id.agree_check_box);
        mAgreeButton = (Button)findViewById(R.id.agree_button);

        //Call setOnCheckedChangeListener on the mAgreeCheckBox, and complete the listener
        /**
         * Call setOnCheckedChangeListener on the mAgreeCheckBox, and complete the listener
         *
         * In the handler, disable the button using setEnabled(false). Pass in true to re-enable.
         */
        mAgreeCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            // we handle when we detect a change in checked state. Boolean isChecked tells us whether checkbox is checked or not.
            @Override
            public void onCheckedChanged(CompoundButton checkButton, boolean checkIt) {
                // based on whether checkbox is checked or not, we enable/disable the button
                if(checkIt) {
                    mAgreeButton.setEnabled(true);
                } else {
                    mAgreeButton.setEnabled(false);
                }
            }
        });
    }
}


