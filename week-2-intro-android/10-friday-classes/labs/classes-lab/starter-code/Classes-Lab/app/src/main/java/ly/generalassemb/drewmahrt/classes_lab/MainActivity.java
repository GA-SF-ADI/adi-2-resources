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

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);


        //Get output TextViews
        TextView output = (TextView) findViewById(R.id.output_text);
        TextView changedOutput = (TextView) findViewById(R.id.changed_output_text);


        Button addMammalButton = (Button) findViewById(R.id.mammal_button);
        Button addReptileButton = (Button) findViewById(R.id.reptile_button);


        final EditText mammalName = (EditText) findViewById(R.id.mammal_name);
        final EditText numOfMammalOffSpring = (EditText) findViewById(R.id.number_of_offspring);
        final EditText reptileName = (EditText) findViewById(R.id.reptile_name);
        final EditText numOfReptileScales = (EditText) findViewById(R.id.number_of_scales);





        final String enteredMammalType = mammalName.getText().toString();
        final String enteredReptileType = reptileName.getText().toString();


        final ArrayList<String> listOfAnimals = new ArrayList<>();

        ListView animalListView = (ListView) findViewById(R.id.listView_of_animals);

        final ArrayAdapter mAdapterForAnimalDataToListView = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, listOfAnimals);

        animalListView.setAdapter(mAdapterForAnimalDataToListView);


                addMammalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer mammalBirthNum = Integer.parseInt(numOfMammalOffSpring.getText().toString());

                listOfAnimals.add(enteredMammalType);
                listOfAnimals.add(mammalBirthNum.toString());

                mAdapterForAnimalDataToListView.notifyDataSetChanged();


            }
        });


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
