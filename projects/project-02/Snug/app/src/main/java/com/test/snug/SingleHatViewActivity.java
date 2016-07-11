package com.test.snug;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class SingleHatViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_hat_view);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar2);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayShowTitleEnabled(false);


        ImageView mImageView = (ImageView) findViewById(R.id.imageview_single_hat);


        int[] images = new int[]{

                R.drawable.a_s_america,
                R.drawable.a_s_america2,
                R.drawable.backs,
                R.drawable.beantown,
                R.drawable.brew_america,
                R.drawable.dodgers,
                R.drawable.florida,
                R.drawable.giants,
                R.drawable.marlins_america,
                R.drawable.padres,
                R.drawable.phils_america,
                R.drawable.red_sox_america,
                R.drawable.rockies_america,
                R.drawable.rsox,
                R.drawable.sgiants,
                R.drawable.tb,
                R.drawable.texas_america,
                R.drawable.wsox,
                R.drawable.yankees,
                R.drawable.yanks};


        // Get a random between 0 and images.length-1
        int imageId = (int) (Math.random() * images.length);


        // Set the image
        mImageView.setBackgroundResource(images[imageId]);


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
