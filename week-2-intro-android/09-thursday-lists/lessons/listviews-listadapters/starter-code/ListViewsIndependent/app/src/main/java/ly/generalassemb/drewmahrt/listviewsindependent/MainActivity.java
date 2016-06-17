package ly.generalassemb.drewmahrt.listviewsindependent;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    LinkedList<String> mStringList;
    ArrayAdapter<String> mAdapter;
    EditText myEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Instantiate your LinkedList
        mStringList = new LinkedList<String>();
        //mStringList.add("Audrey");
        //mStringList.add("David");

        //Instantiate your adapter
        mAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, mStringList);


        //Get your ListView and set the adapter
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

        //Complete the ListView onItemLongClick code to remove list items
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                String str = myEditText.getText().toString();
                ArrayList<String> myArray = new ArrayList<String>(Arrays.asList(str));
                myArray.remove(position);

                //mAdapter.remove(myArray[position]);
                mAdapter.notifyDataSetChanged();
                return false;
                //mStringList.remove(myEditText);
            }
        });

    }
}
