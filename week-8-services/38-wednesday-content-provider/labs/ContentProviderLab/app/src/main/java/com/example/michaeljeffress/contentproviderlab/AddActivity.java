package com.example.michaeljeffress.contentproviderlab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by michaeljeffress on 7/27/16.
 */
public class AddActivity extends AppCompatActivity {
    private EditText mInputCompany;
    private EditText mInputStockQuantity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Button buttonAdd = (Button) findViewById(R.id.buttonAddStockSymbol);
        Button buttonCancel = (Button) findViewById(R.id.buttonCancelStockSymbol);

        mInputCompany = (EditText) findViewById(R.id.editTextSymbol);
        mInputStockQuantity = (EditText) findViewById(R.id.editTextStockQuantity);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
