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
    ListView listView;
    Button button;
    EditText nameEditText;
    EditText descriptionEditText;
    EditText soundEditText;
    CursorAdapter cursorAdapter;
    AnimalSQLiteOpenHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setViews();
        setAdapter();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String sound = soundEditText.getText().toString();
                String description = descriptionEditText.getText().toString();
                Animal newAnimal = new Animal(name, sound, description);
                db.addItem(newAnimal);
                cursorAdapter.changeCursor(db.getAnimals()); //Letting db know that there is a new animal.
                //db.close();

            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                db.deleteItem((int)id);
                cursorAdapter.changeCursor(db.getAnimals());
                //db.close();
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

    private void setAdapter(){
        db = AnimalSQLiteOpenHelper.getInstance(this);
        cursorAdapter = new CursorAdapter(MainActivity.this, db.getAnimals(), 0){
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                return LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false);
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                TextView textView = (TextView) view.findViewById(android.R.id.text1);
                textView.setText(cursor.getString(cursor.getColumnIndex(AnimalSQLiteOpenHelper.COL_NAME)));
            }
        };
        listView.setAdapter(cursorAdapter);

    }

}

