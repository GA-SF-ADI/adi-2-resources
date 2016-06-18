package ly.generalassemb.drewmahrt.classes_lab;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class animalactivity extends AppCompatActivity {

    ArrayList<String> mStringList;
    ArrayAdapter<String> mAdapter;
    EditText myEditText;
    String animalName;
    ArrayList<String> myArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animalactivity);

        final ArrayList<String> myArray = new ArrayList<String>();
        myArray.add("bear");
        myArray.add("cow");
        myArray.add("fish");
        myArray.add("dog");
        myArray.add("rabbit");

            mStringList = new ArrayList<String>();

            mAdapter = new ArrayAdapter<String>(animalactivity.this, android.R.layout.simple_list_item_1, mStringList);

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
                        Toast.makeText(animalactivity.this, "That's not an animal!", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            Button goBackButton = (Button) findViewById(R.id.go_back);
            goBackButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    Intent animalIntent = new Intent (animalactivity.this, MainActivity.class);
                    // put extra
                    //pass back the names of the things to display and display a list
                    setResult(0, animalIntent);

                    finish();
                }

            });
        }
    }






