package com.test.animallabsecondtry;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class AnimalActivity extends AppCompatActivity {

    ArrayList<String> mStringList;
    ArrayAdapter<String> mAdapter;
    EditText myEditText;
    String animalName;
    ArrayList<String> myArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);
        final ArrayList<String> myArray = new ArrayList<String>();
        myArray.add("bear");
        myArray.add("cow");
        //Animal myAnimal = new Animal("animal");
        //System.out.println (myAnimal.getAnimalName("bear"));
        //myAnimal.getAnimalName("unicorn");

        mStringList = new ArrayList<String>();

        mAdapter = new ArrayAdapter<String>(AnimalActivity.this, android.R.layout.simple_list_item_1, mStringList);

        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(mAdapter);
        myEditText = (EditText) findViewById(R.id.edit_text);



        //Complete the FloatingActionButton onClick method to add a list item
        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String myInputString = myEditText.getText().toString();
                //IF THE USER INPUT EQUALS an ITEM FROM MY ARRAYLIST.... let them add to it....
                if(myArray.contains(myInputString)) {
                    mStringList.add(myInputString);
                    mAdapter.notifyDataSetChanged();
                }

            }
        });

    }

}

