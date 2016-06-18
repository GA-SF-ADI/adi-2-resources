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

        Button addMammalButton = (Button) findViewById(R.id.mammal_button);
        Button addReptileButton = (Button) findViewById(R.id.reptile_button);

//        Link EdiText views


        final EditText mammalName = (EditText) findViewById(R.id.mammal_name);
        final EditText numOfMammalOffSpring = (EditText) findViewById(R.id.number_of_offspring);
        final EditText reptileName = (EditText) findViewById(R.id.reptile_name);
        final EditText numOfReptileScales = (EditText) findViewById(R.id.number_of_scales);

//        Convert entered mammal and reptile names to Strings


        final String enteredMammalType = mammalName.getText().toString();
        final String enteredReptileType = reptileName.getText().toString();

//        Create ArrayList

        final ArrayList<String> listOfAnimals = new ArrayList<>();

//        Create ListView

        ListView animalListView = (ListView) findViewById(R.id.listView_of_animals);

//        Create adapter

        final ArrayAdapter mAdapterForAnimalDataToListView = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, listOfAnimals);

//        Set adapter

        animalListView.setAdapter(mAdapterForAnimalDataToListView);

//        Mammal button's onClickListener

        addMammalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer mammalBirthNum = Integer.parseInt(numOfMammalOffSpring.getText().toString());

                listOfAnimals.add(enteredMammalType);
                listOfAnimals.add(mammalBirthNum.toString());

                mAdapterForAnimalDataToListView.notifyDataSetChanged();


            }
        });

//      Reptile button's onClickListener

        addReptileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Integer reptileScaleNum = Integer.parseInt(numOfReptileScales.getText().toString());

                listOfAnimals.add(enteredReptileType);

                mAdapterForAnimalDataToListView.notifyDataSetChanged();


            }
        });


    }
}
