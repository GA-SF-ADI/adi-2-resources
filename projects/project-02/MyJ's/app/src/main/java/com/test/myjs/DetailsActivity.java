package com.test.myjs;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    Button backButton;
    Button buyButton;
    ImageView randImage;
    ShoeOpenHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        //add all view creation to a method
        backButton = (Button)findViewById(R.id.back_button);
        buyButton= (Button)findViewById(R.id.buy_button);
        randImage = (ImageView) findViewById(R.id.detail_image);
        TextView price =(TextView)findViewById(R.id.price);
        TextView name = (TextView)findViewById(R.id.name);
        TextView description = (TextView)findViewById(R.id.description);
        helper= ShoeOpenHelper.getInstance(getApplicationContext());

        Intent intent = getIntent();
       int randShoePosition= intent.getIntExtra("Position",-1);
        Cursor cursor = helper.getInstance(DetailsActivity.this).getShoeById(randShoePosition);
        //cursor.moveToFirst();
        //cursor.move(randShoePosition);
        randImage.setImageResource(cursor.getInt(cursor.getColumnIndex(ShoeOpenHelper.DataEntryShoes.COL_IMG_ID)));
        name.setText(cursor.getString(cursor.getColumnIndex(ShoeOpenHelper.DataEntryShoes.COL_NAME)));
        price.setText(cursor.getString(cursor.getColumnIndex(ShoeOpenHelper.DataEntryShoes.COL_PRICE)));
        description.setText(cursor.getString(cursor.getColumnIndex(ShoeOpenHelper.DataEntryShoes.COL_YEAR)));




    }
}
