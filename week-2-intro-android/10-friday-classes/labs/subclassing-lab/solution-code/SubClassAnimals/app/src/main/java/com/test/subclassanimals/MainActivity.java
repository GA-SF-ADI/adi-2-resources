package com.test.subclassanimals;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Serializable{
    private static final long serialVersionUID = 7526472295622776147L;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView lv= (ListView) findViewById(R.id.listView);
        //instantiate array adapter object

        ArrayList species = new ArrayList();
        species.add(new Animals("Mammals", R.drawable.mammals));
        species.add(new Animals("Reptiles", R.drawable.reptiles));
        species.add(new SubAnimals("tapir", R.drawable.tapir));
        species.add(new SubAnimals("lizard", R.drawable.lizard));

        ArrayAdapter<Animals> animalsArrayAdapter= new ArrayAdapter<Animals>(this, android.R.layout.simple_list_item_1,species);
        //connect listview to Adapter
        lv.setAdapter(animalsArrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i= new Intent(MainActivity.this,Animals.class);
                i.putExtra("ImageId",id);
                startActivity(i);
            }
        });
}}