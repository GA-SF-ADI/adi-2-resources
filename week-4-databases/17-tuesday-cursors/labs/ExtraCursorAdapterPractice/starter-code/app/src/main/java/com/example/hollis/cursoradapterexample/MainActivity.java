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
    //ArrayList<Animal> animalList;
    //ArrayAdapter animalAdapter;
    AnimalSQLiteOpenHelper db;
    CursorAdapter cursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();

        db = AnimalSQLiteOpenHelper.getInstance(this);;

        final Cursor cursor = db.getAnimalList();
        cursorAdapter = new CursorAdapter(MainActivity.this, cursor, 0) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                return LayoutInflater.from(context).inflate(R.layout.animal_list_item, parent, false);
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                TextView name = (TextView) view.findViewById(R.id.animal_list_item_name);
                TextView sound = (TextView) view.findViewById(R.id.animal_list_item_sound);
                TextView description = (TextView) view.findViewById(R.id.animal_list_item_description);

                name.setText(cursor.getString(cursor.getColumnIndex(AnimalSQLiteOpenHelper.COL_NAME)));
                sound.setText(cursor.getString(cursor.getColumnIndex(AnimalSQLiteOpenHelper.COL_SOUND)));
                description.setText(cursor.getString(cursor.getColumnIndex(AnimalSQLiteOpenHelper.COL_DESCRIPTION)));
            }
        };

        listView.setAdapter(cursorAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String sound = soundEditText.getText().toString();
                String description = descriptionEditText.getText().toString();
                Animal newAnimal = new Animal(name, sound, description);
                db.addAnimal(newAnimal);
                cursorAdapter.changeCursor(db.getAnimalList());

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                db.removeAnimal((int)id);
                cursorAdapter.changeCursor(db.getAnimalList());
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
