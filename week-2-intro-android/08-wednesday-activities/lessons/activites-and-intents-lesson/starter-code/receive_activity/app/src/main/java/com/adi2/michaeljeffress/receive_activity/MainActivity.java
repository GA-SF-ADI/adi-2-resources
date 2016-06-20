package com.adi2.michaeljeffress.receive_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button receiveButton1 = (Button) findViewById(R.id.button1);
        Button.OnClickListener buttonOnClickListener1 = new Button.OnClickListener() {
        }

        Button receiveButton2 = (Button) findViewById(R.id.button2);
        Button.OnClickListener buttonOnClickListener2 = new Button.OnClickListener() {
        }

    }
}
