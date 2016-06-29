package com.example.hollis.cursoradapterexample;

import android.database.Cursor;
import android.provider.Contacts;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    Button button;
    EditText nameEditText;
    EditText descriptionEditText;
    EditText soundEditText;
    ArrayList<AnimalSQLOpenHelper> animalList;
    ArrayAdapter animalAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();

        animalList = new ArrayList<>();


        String[] columns = new String[]{R.id.}


        int[] to = new int[]{R.id.itemTextView};

        SimpleCursorAdapter simpleAdapter = new SimpleCursorAdapter(getApplicationContext(), R.layout.listitemlayout, c, from, to);

        ListView lv = (ListView) findViewById(R.id.list_view);

        lv.setAdapter(simpleAdapter);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String sound = soundEditText.getText().toString();
                String description = descriptionEditText.getText().toString();
                AnimalSQLOpenHelper newAnimal = new AnimalSQLOpenHelper(name, sound, description);
                animalList.add(newAnimal);
                animalAdapter.notifyDataSetChanged();

            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                animalList.remove(position);
                animalAdapter.notifyDataSetChanged();
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
