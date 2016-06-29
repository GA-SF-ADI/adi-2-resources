package com.example.hollis.cursoradapterexample;

import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    Button button;
    EditText nameEditText;
    EditText descriptionEditText;
    EditText soundEditText;
    ArrayList<Animal> animalList;
    CursorAdapter cursorAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();
        animalList = new ArrayList<>();
        Cursor cursor = db.query(ANIMAL_TABLE_NAME, ANIMAL_COLUMNS, null, null, null, null, null);
        final CursorAdapter cursorAdapter = new CursorAdapter(MainActivity.this,cursor,0));
        listView.setAdapter(cursorAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String sound = soundEditText.getText().toString();
                String description = descriptionEditText.getText().toString();
                Animal newAnimal = new Animal(name, sound, description);
                animalList.add(newAnimal);
                cursorAdapter.notifyDataSetChanged();

            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                animalList.remove(position);
                cursorAdapter.notifyDataSetChanged();
            }
        });
    }

    private void setViews(){
        listView = (ListView) findViewById(R.id.list_view);
         button = (Button) findViewById(R.id.animal_button);
         nameEditText = (EditText) findViewById(R.id.animal_name);
         descriptionEditText = (EditText) findViewById(R.id.animal_description);
         soundEditText = (EditText) findViewById(R.id.animal_sound);
    }
}
