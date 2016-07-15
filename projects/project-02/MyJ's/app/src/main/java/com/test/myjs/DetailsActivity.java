package com.test.myjs;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity {
    private Button buyButton;
    private ImageView shoeImage;
    ShoeOpenHelper helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        //add  view creation to a method
        buyButton = (Button) findViewById(R.id.buy_button);
        shoeImage = (ImageView) findViewById(R.id.detail_image);
        TextView price = (TextView) findViewById(R.id.price);
        TextView name = (TextView) findViewById(R.id.name);
        TextView year = (TextView) findViewById(R.id.year);
        TextView shoeDescription = (TextView) findViewById(R.id.details_item_description);
        helper = ShoeOpenHelper.getInstance(getApplicationContext());

        //rec intent from MainActivity containing shoeSelected position
        Intent intent = getIntent();
        final long shoePosition = intent.getLongExtra("Shoe Id", -1);

        //using getShoeById to get shoeItem
        final Cursor cursor = helper.getInstance(DetailsActivity.this).getShoeById(shoePosition);
        cursor.moveToFirst();

        //Setting views with selected shoe properties
        shoeImage.setImageResource(cursor.getInt(cursor.getColumnIndex(ShoeOpenHelper.DataEntryShoes.COL_IMG_ID)));
        name.setText(cursor.getString(cursor.getColumnIndex(ShoeOpenHelper.DataEntryShoes.COL_NAME)));
        price.setText(cursor.getString(cursor.getColumnIndex(ShoeOpenHelper.DataEntryShoes.COL_PRICE)));
        year.setText(cursor.getString(cursor.getColumnIndex(ShoeOpenHelper.DataEntryShoes.COL_YEAR)));
        shoeDescription.setText(cursor.getString(cursor.getColumnIndex(ShoeOpenHelper.DataEntryShoes.COL_DESCRIPTION)));

        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                helper = ShoeOpenHelper.getInstance(DetailsActivity.this);
                helper.insertRowShoppingCart(cursor.getString(cursor.getColumnIndex(ShoeOpenHelper.DataEntryShoes.COL_NAME)), cursor.getDouble(cursor.getColumnIndex(ShoeOpenHelper.DataEntryShoes.COL_PRICE)), cursor.getInt(cursor.getColumnIndex(ShoeOpenHelper.DataEntryShoes.COL_IMG_ID)), cursor.getInt(cursor.getColumnIndex(ShoeOpenHelper.DataEntryShoes.COL_YEAR)),cursor.getString(cursor.getColumnIndex(ShoeOpenHelper.DataEntryShoes.COL_DESCRIPTION)));
                // toast letting user know that cart is added
                Toast.makeText(DetailsActivity.this,"Added item to cart",Toast.LENGTH_SHORT).show();

            }
        });

    }
}
