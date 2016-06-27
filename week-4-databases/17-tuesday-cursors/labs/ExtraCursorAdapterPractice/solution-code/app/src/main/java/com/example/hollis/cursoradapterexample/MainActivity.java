package com.example.hollis.cursoradapterexample;

import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    AnimalSqlOpenHelper db;
    ListView listView;
    Button button;
    EditText nameEditText;
    EditText descriptionEditText;
    EditText soundEditText;
     SimpleCursorAdapter cursorAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = AnimalSqlOpenHelper.getInstance(this);
        setViews();
        cursorAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1,db.getAnimals(),new String[]{AnimalSqlOpenHelper.COL_ANIMAL_NAME}, new int[]{android.R.id.text1},0);
        listView.setAdapter(cursorAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
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
}
