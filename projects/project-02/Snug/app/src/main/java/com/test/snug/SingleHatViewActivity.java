package com.test.snug;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SingleHatViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_hat_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_activity_main_toolbar);
        setSupportActionBar(toolbar);


        final ImageView selectedHatImage = (ImageView) findViewById(R.id.imageview_single_hat);
        final TextView selectedHatTitle = (TextView) findViewById(R.id.textView_single_hat_title);
        final TextView selectedHatPrice = (TextView) findViewById(R.id.textView_single_hat_price);
        final TextView selectedHatDescription = (TextView) findViewById(R.id.textview_single_hat_static_description_with_colon);
        final TextView selectedHatBack = (TextView) findViewById(R.id.textview_single_hat_static_back);
        final TextView selectedHatMaterial = (TextView) findViewById(R.id.textview_single_hat_static_material_with_colon);


//        TODO:Add hat ID and color too, for passing on to cart?

        selectedHatImage.setBackgroundResource(R.drawable.dodgers);
        selectedHatTitle.setText("");
        selectedHatPrice.setText("");
        selectedHatDescription.setText("");
        selectedHatBack.setText("");
        selectedHatMaterial.setText("");

        FloatingActionButton addToCartButton = (FloatingActionButton) findViewById(R.id.fab);
        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(SingleHatViewActivity.this, "Hat added to cart", Toast.LENGTH_LONG).show();


                Context context = getApplicationContext();
                HatsSQLiteOpenHelper db = new HatsSQLiteOpenHelper(context);

//                TODO: Figure out to add particular hat to the cart



//                Cursor cursor = db.addHatToCart();

                Intent intent = new Intent(SingleHatViewActivity.this, MainActivity.class);

                startActivity(intent);


            }
        });
    }

}
