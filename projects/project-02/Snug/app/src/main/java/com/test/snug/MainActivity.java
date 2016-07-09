package com.test.snug;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);


//        TODO: Set up recycler view stuff

        RecyclerView recyclerViewCardListOfHats = (RecyclerView) findViewById(R.id.cardList);
        recyclerViewCardListOfHats.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewCardListOfHats.setLayoutManager(llm);




        DatabaseHelper db = new DatabaseHelper(this);

//        TODO: Add hats below!(int id, int picture, double price, String material, int fittedOrSnap, String description, String color
        db.addHat(0, 2323, 29.99, "cotton", 1, "Plush and soft, this hat will keep you looking great!", "blue");


//        TODO: Eventually will have to fetch hat records?



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);


    }
}
