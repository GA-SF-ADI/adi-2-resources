package com.test.snug;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);



//        TODO: Set up recycler view stuff


        SQLiteOpenHelper db = new SQLiteOpenHelper(this);

//        TODO: Add hats below!(int id, int picture, double price, String material, int fittedOrSnap, String description, String color
        db.addHat(0, 2323, 29.99, "cotton", 1, "Plush and soft, this hat will keep you looking great!", "blue");


//        TODO: Eventually will have to fetch hat records?


        Button goToSingleHat = (Button) findViewById(R.id.go_to_hat_button);

        goToSingleHat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SingleHatViewActivity.class);
                startActivity(intent);

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.search_hats:

                break;

            case R.id.view_cart:

                Intent intent = new Intent(MainActivity.this, ShoppingCartActivity.class);
                startActivity(intent);

                break;
        }


        return super.onOptionsItemSelected(item);
    }
}

