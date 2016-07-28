package com.test.contentproviderslab;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private EditText mStockSymbol;
    private EditText mQuantity;
    private TextView mResultTextView;
    public static final Uri CONTENT_URI = Uri.parse("com.test.contentproviderslab.MyContentProvider/quote");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Button add = (Button) findViewById(R.id.add_button);
                add.setOnClickListener(this);
                mStockSymbol = (EditText) findViewById(R.id.stock_symbol_edittext);
                mQuantity = (EditText) findViewById(R.id.quantity_edittext);
                mResultTextView = (TextView) findViewById(R.id.textview);

            }

            public void addStock () {
                ContentResolver cr = getContentResolver();
                ContentValues values = new ContentValues();
                values.put("productname",mInputName.getText().toString());
                values.put("quantity",mInputQuantity.getText().toString());
                Uri uri = cr.insert(CONTENT_URI,values);
                Log.d(MainActivity.class.getName(),uri.toString());
                mResultTextView.setText(mInputName.getText().toString()+ " has been added!");
            }


        });
    }

}
