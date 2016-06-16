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

        // we set a new onCheckedChange listener on our checkbox
        mAgreeCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            // we handle when we detect a change in checked state. Boolean isChecked tells us whether checkbox is checked or not.
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // based on whether checkbox is checked or not, we enable/disable the button
                if(isChecked) {
                    mAgreeButton.setEnabled(true);
                } else {
                    mAgreeButton.setEnabled(false);
                }
            }
        });
    }
}
