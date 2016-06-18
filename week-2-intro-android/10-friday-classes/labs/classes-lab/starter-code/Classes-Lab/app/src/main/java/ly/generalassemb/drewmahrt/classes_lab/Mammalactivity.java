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
import android.widget.Toast;

import java.lang.Object;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Mammalactivity extends AppCompatActivity {
    LinkedList<String> mStringList;
    ArrayAdapter<String> mAdapter;
    EditText myEditText;
    String mammalName;
    ArrayList<String> myArray;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mammalactivity);

        final ArrayList<String> myArray = new ArrayList<String>();
        myArray.add("bear");
        myArray.add("cow");
        myArray.add("cat");
        myArray.add("dog");
        myArray.add("tiger");

        mStringList = new LinkedList<String>();

        mAdapter = new ArrayAdapter<String>(Mammalactivity.this, android.R.layout.simple_list_item_1, mStringList);

        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(mAdapter);
        myEditText = (EditText) findViewById(R.id.edit_text);

        //Complete the FloatingActionButton onClick method to add a list item
        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String myInputString = myEditText.getText().toString();

                if(myArray.contains(myInputString)) {

                    mStringList.add(myInputString);

                    mAdapter.notifyDataSetChanged();

                } else {
                    Toast.makeText(Mammalactivity.this, "That's not a mammal!", Toast.LENGTH_SHORT).show();
                }


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
