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
    TextView textView1, textView2, textView3;
    DatabaseHelper db;
    CursorAdapter cursorAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();
        db = new DatabaseHelper(this);
        final Cursor cursor = db.getAnimalList();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String sound = soundEditText.getText().toString();
                String description = descriptionEditText.getText().toString();
                Animal animal = new Animal(name,sound,description);
                nameEditText.setText("");
                soundEditText.setText("");
                descriptionEditText.setText("");

                db.insert(animal);

                Cursor cursor1 = db.getAnimalList();
                // crashes when line below runs.
                cursorAdapter.changeCursor(cursor1);

            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //db.delete(position+1);<--- will this work?
                db.delete((int)id);
                Cursor cursor1 = db.getAnimalList();
                cursorAdapter.changeCursor(cursor1);

            }
        });


        final CursorAdapter cursorAdapter = new CursorAdapter(this, cursor,0) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                return LayoutInflater.from(context).inflate(R.layout.item_view,parent,false);
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                textView1=(TextView)view.findViewById(R.id.animaltext1);
                textView2=(TextView)view.findViewById(R.id.animaltext2);
                textView3=(TextView)view.findViewById(R.id.animaltext3);

                textView1.setText(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_NAME)));
                textView2.setText(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_SOUND)));
                textView3.setText(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_DESCRIPTION)));

            }
        };
        listView.setAdapter(cursorAdapter);

    }

    private void setViews(){
        listView = (ListView) findViewById(R.id.list_view);
         button = (Button) findViewById(R.id.animal_button);
         nameEditText = (EditText) findViewById(R.id.animal_name);
         descriptionEditText = (EditText) findViewById(R.id.animal_description);
         soundEditText = (EditText) findViewById(R.id.animal_sound);
    }
}
