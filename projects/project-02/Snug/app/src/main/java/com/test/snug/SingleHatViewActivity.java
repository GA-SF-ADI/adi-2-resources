package com.test.snug;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SingleHatViewActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_hat_view);

        //Setting up views, toolbars, and binding data

        Toolbar toolbar = (Toolbar) findViewById(R.id.main_activity_main_toolbar);//TODO: Ask why this doesn't work! I had to copy all of the menu items to this activity's layout file!
        setSupportActionBar(toolbar);

        ImageButton cartButtonInToolbar = (ImageButton) findViewById(R.id.button_in_toolbar_to_view_cart);
        ImageButton searchButtonInToolbar = (ImageButton) findViewById(R.id.button_in_toolbar_to_search_for_hats);


        final ImageView selectedHatImage = (ImageView) findViewById(R.id.imageview_single_hat);
        final TextView selectedHatTitle = (TextView) findViewById(R.id.textView_single_hat_title);
        final TextView selectedHatPrice = (TextView) findViewById(R.id.textView_single_hat_price);
        final TextView selectedHatDescription = (TextView) findViewById(R.id.textview_single_hat_static_description_with_colon);
        final TextView selectedHatBack = (TextView) findViewById(R.id.textview_single_hat_static_back);
        final TextView selectedHatMaterial = (TextView) findViewById(R.id.textview_single_hat_static_material_with_colon);


//        Receiving table position about the specific hat that was clicked on

        Intent intent = getIntent();

        int selectedHatPosition = intent.getIntExtra("hatPosition",-1);

//        TODO: Pull required info from table for specific hat

        HatsSQLiteOpenHelper hatDatabase = HatsSQLiteOpenHelper.getInstance(SingleHatViewActivity.this);


        Cursor cursor = hatDatabase.getSpecificHat(selectedHatPosition);


//        TODO:Add hat ID and color too, for passing on to cart?

        //Setting the passed through data for the single hat being viewed
        cursor.moveToFirst(); //<–TODO: Need to do more than just .moveToNext()? Close it?

            selectedHatImage.setBackgroundResource(cursor.getInt(cursor.getColumnIndex(HatsSQLiteOpenHelper.HAT_COLUMN_PICTUREID)));
            selectedHatTitle.setText(cursor.getString(cursor.getColumnIndex(HatsSQLiteOpenHelper.HAT_COLUMN_HATNAME)));
            selectedHatPrice.setText(cursor.getString(cursor.getColumnIndex(HatsSQLiteOpenHelper.HAT_COLUMN_PRICE)));
            selectedHatDescription.setText(cursor.getString(cursor.getColumnIndex(HatsSQLiteOpenHelper.HAT_COLUMN_DESCRIPTION)));
            selectedHatBack.setText(cursor.getString(cursor.getColumnIndex(HatsSQLiteOpenHelper.HAT_COLUMN_FittedOrSnap)));
            selectedHatMaterial.setText(cursor.getString(cursor.getColumnIndex(HatsSQLiteOpenHelper.HAT_COLUMN_MATERIAL)));



        cursor.close();

        Log.d("SingleHatViewActivity", "Cursor closed");


        //FAB for adding hat to cart
        FloatingActionButton addToCartButton = (FloatingActionButton) findViewById(R.id.fab);
        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(SingleHatViewActivity.this, "Hat added to cart", Toast.LENGTH_SHORT).show();


                Context context = getApplicationContext();
                HatsSQLiteOpenHelper db = new HatsSQLiteOpenHelper(context);

//                TODO: Figure out to add particular hat to the cart

//                Cursor cursor = db.addHatToCart();

                Intent intent = new Intent(SingleHatViewActivity.this, MainActivity.class);

                startActivity(intent);
            }
        });



        /*//Menu image button click listeners
        cartButtonInToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SingleHatViewActivity.this, ShoppingCartActivity.class);
                startActivity(intent);

            }
        });
*/
      /*  searchButtonInToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SingleHatViewActivity.this, SearchActivity.class);
                startActivity(intent);

            }
        });*/


    }


}
