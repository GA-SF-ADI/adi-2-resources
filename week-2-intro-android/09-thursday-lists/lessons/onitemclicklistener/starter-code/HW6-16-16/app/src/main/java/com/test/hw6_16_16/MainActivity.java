package com.test.hw6_16_16;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ToggleButton;
import java.lang.Object;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//I was experimenting with the checkbox and toggle buttons... it looks like they do similar things?


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ToggleButton toggleButton;
        //final CheckBox checkBox;
        final ToggleButton toggleButtonn = (ToggleButton) findViewById(R.id.toggle_button);
        //final CheckBox checkBoxButton = (CheckBox) findViewById(R.id.checkbox);



       toggleButtonn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (toggleButtonn.isChecked()) {
                    Toast.makeText(MainActivity.this, "ENABLED", Toast.LENGTH_SHORT).show();
                } else  {
                    Toast.makeText(MainActivity.this, "DISABLED", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}