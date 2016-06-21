package com.test.onitempractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView myListView;
    ArrayAdapter<String> myArrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myListView = (ListView) findViewById(R.id.list_view);

        final ArrayList<String> myFamily = new ArrayList<>(Arrays.asList("Audrey", "Jeff", "Liz"));
        final ArrayList<String> abbrevFamily = new ArrayList<>(Arrays.asList("AS", "JB", "LS"));

        final ArrayList<String> thirdList = new ArrayList<>(abbrevFamily);

        myArrayAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1, thirdList);
        myListView.setAdapter(myArrayAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String currentString = myArrayAdapter.getItem(position);
                if (currentString.equals(abbrevFamily.get(position))){
                    currentString = myFamily.get(position);
                } else if (currentString.equals(myFamily.get(position))){
                    currentString = abbrevFamily.get(position);
                }
                // update the string at the current position that was clicked
               thirdList.set(position, currentString);

                // make sure we reflect the change in the list by notifying adapter to redraw
                myArrayAdapter.notifyDataSetChanged();
            }
        });
    }
}
