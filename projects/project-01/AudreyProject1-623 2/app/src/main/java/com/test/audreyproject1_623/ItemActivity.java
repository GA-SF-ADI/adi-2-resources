package com.test.audreyproject1_623;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;

public class ItemActivity extends AppCompatActivity {

    EditText myEditText;
    SecondCustomBaseAdapter secondCustomBaseAdapter;
    Category myCategory;
    ArrayList<String> myList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        final Intent receivedIntent = getIntent();
        myCategory = (Category) getIntent().getSerializableExtra("category");
        myList = myCategory.getItems();


        if (myList == null) {
            myList = new ArrayList<>();
        }

        final ListView listView =(ListView) findViewById(R.id.list_view_for_items);

        secondCustomBaseAdapter = new SecondCustomBaseAdapter(myList, this);
        listView.setAdapter(secondCustomBaseAdapter);
        myEditText = (EditText) findViewById(R.id.edit_text);




        Button newList = (Button) findViewById(R.id.new_list_button);
        newList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String myInputString = myEditText.getText().toString();
                myList.add(myInputString);
                Log.d("MainActivity", myList.toString());
                secondCustomBaseAdapter.notifyDataSetChanged();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                myList.remove(position);
                secondCustomBaseAdapter.notifyDataSetChanged();
                return false;
            }
        });

        Button goBack =(Button) findViewById(R.id.go_back);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentResult = getIntent();

                myCategory.setItems(myList);
                intentResult.putExtra("category", myCategory);

                setResult(RESULT_OK, intentResult);

                finish();
            }
        });

    }

}
