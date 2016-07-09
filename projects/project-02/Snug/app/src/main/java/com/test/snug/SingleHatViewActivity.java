package com.test.snug;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class SingleHatViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_hat_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton addToCartButton = (FloatingActionButton) findViewById(R.id.fab);
        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(SingleHatViewActivity.this, "Hat added to cart", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(SingleHatViewActivity.this, MainActivity.class);
                startActivity(intent);


            }
        });
    }

}
