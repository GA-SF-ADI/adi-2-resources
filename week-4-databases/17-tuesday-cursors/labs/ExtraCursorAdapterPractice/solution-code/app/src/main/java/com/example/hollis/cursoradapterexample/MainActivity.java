package com.example.hollis.cursoradapterexample;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    AnimalSqlOpenHelper db;
    ListView listView;
    Button button;
    EditText nameEditText;
    EditText descriptionEditText;
    EditText soundEditText;
    CursorAdapter cursorAdapter;
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
    private void setAdapter(){
        db = AnimalSqlOpenHelper.getInstance(this);
        cursorAdapter = new CursorAdapter(MainActivity.this, db.getAnimals(), 0){
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                return LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false);
            }

            @Override
                String sound = soundEditText.getText().toString();
                String description = descriptionEditText.getText().toString();
                Animal newAnimal = new Animal(name, sound, description);
                db.addAnimal(newAnimal);
                cursorAdapter.swapCursor(db.getAnimals());
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                db.removeAnimal((int)id);
                cursorAdapter.swapCursor(db.getAnimals());
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
        db = AnimalSqlOpenHelper.getInstance(this);
        cursorAdapter = new CursorAdapter(MainActivity.this, db.getAnimals(), 0){
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                return LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false);
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                TextView textView = (TextView) view.findViewById(android.R.id.text1);
                textView.setText(cursor.getString(cursor.getColumnIndex(AnimalSqlOpenHelper.COL_ANIMAL_NAME)));
            }
        };
        listView.setAdapter(cursorAdapter);

    }
}
