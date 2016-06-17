package ly.generalassemb.drewmahrt.classes_lab;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.lang.Object;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Reptileactivity extends AppCompatActivity {
    LinkedList<String> mStringList;
    ArrayAdapter<String> mAdapter;
    EditText myEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reptileactivity);

        mStringList = new LinkedList<String>();

        mAdapter = new ArrayAdapter<String>(Reptileactivity.this, android.R.layout.simple_list_item_1, mStringList);

        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(mAdapter);
        myEditText = (EditText) findViewById(R.id.edit_text);

        //Complete the FloatingActionButton onClick method to add a list item
        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String myInputString = myEditText.getText().toString();
                mStringList.add(myInputString);

                mAdapter.notifyDataSetChanged();


            }
        });

        Button goBackButton = (Button) findViewById(R.id.go_back);
        goBackButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                finish();
            }

        });
    }
}




