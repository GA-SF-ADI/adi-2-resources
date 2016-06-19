package com.test.project1todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> mStringList;
    ArrayAdapter<String> mAdapter;
    EditText myEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStringList= new ArrayList<String>();
        mAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, mStringList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(mAdapter);
        myEditText = (EditText) findViewById(R.id.edit_text);


        Button newList = (Button) findViewById(R.id.new_list);
        newList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String myInputString = myEditText.getText().toString();

                mStringList.add(myInputString);

                mAdapter.notifyDataSetChanged();
            }
        });


        }
    }
