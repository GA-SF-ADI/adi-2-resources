package ly.generalassemb.drewmahrt.buttonenabling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

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

    }
}
