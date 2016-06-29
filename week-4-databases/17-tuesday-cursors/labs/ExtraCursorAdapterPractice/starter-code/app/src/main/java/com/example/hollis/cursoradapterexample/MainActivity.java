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
//    ArrayList<Animal> animalList;

    CursorAdapter cursorAdapter;

    DataBaseHelper db;

//    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();


        db = DataBaseHelper.getInstance(this);  // Becuz there should only be only database instance *** vvimp ***

        Cursor cursor = db.getAllAnimals();

        cursorAdapter = new CursorAdapter(this,cursor,0) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                return LayoutInflater.from(context).inflate(R.layout.layout_list_view,parent,false);
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {

                TextView nameTextView = (TextView)view.findViewById(R.id.text_view);

                nameTextView.setText(cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_NAME)));

            }
        };

        listView.setAdapter(cursorAdapter);






//
//        animalList = new ArrayList<>();
//        animalAdapter = new CursorAdapter(this, android.R.layout.simple_list_item_1,animalList);




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = nameEditText.getText().toString();
                String sound = soundEditText.getText().toString();
                String description = descriptionEditText.getText().toString();

                Animal currentAnimal = new Animal(name, sound, description);
                db.addAnimal(currentAnimal);
                cursorAdapter.changeCursor(db.getAllAnimals());


//                animalList.add(newAnimal);

//                animalAdapter.notifyDataSetChanged();

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                db.removeAnimal(id);
                cursorAdapter.changeCursor(db.getAllAnimals());

//                animalList.remove(position);
//                animalAdapter.notifyDataSetChanged();
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
