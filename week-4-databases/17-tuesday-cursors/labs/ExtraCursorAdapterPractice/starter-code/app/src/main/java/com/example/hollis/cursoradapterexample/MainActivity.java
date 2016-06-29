package com.example.hollis.cursoradapterexample;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    ListView listView;
    Button button;
    EditText nameEditText;
    EditText descriptionEditText;
    EditText soundEditText;
    ArrayList<Animal> animalList;
    ArrayAdapter animalAdapter;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
        db.insert("dog", "woof", "furry");
        db.insert("turtle", "silent", "swimmer");
        db.insert("lion", "roar", "endangered");

        final CursorAdapter cursorAdapter = new CursorAdapter(MainActivity.this, cursor, 0) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                return LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false);
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                TextView textView = (TextView) view.findViewById(R.id.custom_text_view);
                textView.setText(cursor.getColumnIndex(DatabaseHelper.COL_ANI_NAME));
                TextView textView2 = (TextView) view.findViewById(R.id.custom_text_view_2);
                textView.setText(cursor.getColumnIndex(DatabaseHelper.COL_ANI_SOUND));
                TextView textView3 = (TextView) view.findViewById(R.id.custom_text_view_3);
                textView.setText(cursor.getColumnIndex(DatabaseHelper.COL_ANI_DES));

            }
        };


        setViews();
        animalList = new ArrayList<>();
        listView.setAdapter(cursorAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String sound = soundEditText.getText().toString();
                String description = descriptionEditText.getText().toString();
                Animal newAnimal = new Animal(name, sound, description);
                //add edit text and data
                animalList.add(newAnimal);
                //How does this work? Had to look this up
                cursorAdapter.swapCursor(db.getAllAnimals());


            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //remove edit text and data
                animalList.remove(position);
                //How does this work? Had to look this up
                cursorAdapter.swapCursor(db.getAllAnimals());
            }
        });
    }

    private void setViews() {
        listView = (ListView) findViewById(R.id.list_view);
        button = (Button) findViewById(R.id.animal_button);
        nameEditText = (EditText) findViewById(R.id.animal_name);
        descriptionEditText = (EditText) findViewById(R.id.animal_description);
        soundEditText = (EditText) findViewById(R.id.animal_sound);
    }
}
