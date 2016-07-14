package com.test.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView detailAlcName,detailAlcDes,detailAlcAbv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_detail);
        detailAlcName = (TextView)findViewById(R.id.dialog_alc_name);

        Intent i = getIntent();
        Alcohol selectedAlcohol = (Alcohol)i.getSerializableExtra("alc");
        detailAlcName.setText(selectedAlcohol.getAlcName());


    }
}
