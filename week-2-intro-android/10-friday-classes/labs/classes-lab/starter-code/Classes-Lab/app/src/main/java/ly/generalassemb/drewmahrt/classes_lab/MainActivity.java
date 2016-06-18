package ly.generalassemb.drewmahrt.classes_lab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.Serializable;


import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Hide keyboard upon onCreate

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

//        Link mammal and reptile button views

        Button addMammalButton = (Button) findViewById(R.id.bear_button);
        Button addReptileButton = (Button) findViewById(R.id.snake_button);

//        Link EdiText views


        final EditText bearName = (EditText) findViewById(R.id.bear_name);
        final EditText numOfCubs = (EditText) findViewById(R.id.number_of_cubs);
        final EditText snakeName = (EditText) findViewById(R.id.snake_name);
        final EditText numOfSnakeScales = (EditText) findViewById(R.id.number_of_scales);

//        Convert entered mammal and reptile names to Strings


        final String enteredBearType = bearName.getText().toString();
        final String enteredSnakeType = snakeName.getText().toString();

//        Create ArrayList

        final ArrayList<String> listOfAnimals = new ArrayList<>();

//        Create ListView

        final ListView animalListView = (ListView) findViewById(R.id.listView_of_animals);

//        Create adapter

        final ArrayAdapter mAdapterForAnimalDataToListView = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, listOfAnimals);

//        Set adapter

        animalListView.setAdapter(mAdapterForAnimalDataToListView);

//        Mammal button's onClickListener

        addMammalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

                listOfAnimals.add(enteredBearType);
                listOfAnimals.add(numOfCubs.toString());

                Integer bearCubNum = Integer.parseInt(numOfCubs.getText().toString());


                mAdapterForAnimalDataToListView.notifyDataSetChanged();


            }
        });

//      Reptile button's onClickListener

        addReptileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

                Integer reptileScaleNum = Integer.parseInt(numOfSnakeScales.getText().toString());

                listOfAnimals.add(enteredSnakeType);
                listOfAnimals.add(numOfSnakeScales.toString());


                mAdapterForAnimalDataToListView.notifyDataSetChanged();


            }
        });


    }
}
