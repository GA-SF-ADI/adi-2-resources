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

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Serializable {

    public ArrayList<String> listOfAnimals;
    public ArrayAdapter<String> mAdapterForAnimalDataToListView;
    public Button addBearButton, addSnakeButton;
    public ListView animalListView;
    private static final long serialVersionUID = 7526472295622776147L;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Hide keyboard upon onCreate

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);


//        handling null

        if (listOfAnimals == null) {
            listOfAnimals = new ArrayList<>();
        }

//        Link mammal and reptile button views

        Button addBearButton = (Button) findViewById(R.id.bear_button);
        Button addSnakeButton = (Button) findViewById(R.id.snake_button);

//        Create adapter

        final ArrayAdapter<String> mAdapterForAnimalDataToListView = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1, listOfAnimals);


//        Link EdiText views


        final EditText bearName = (EditText) findViewById(R.id.bear_name);
        final EditText numOfCubs = (EditText) findViewById(R.id.number_of_cubs);
        final EditText snakeName = (EditText) findViewById(R.id.snake_name);
        final EditText numOfSnakeScales = (EditText) findViewById(R.id.number_of_scales);

//        Linking ListView view

        final ListView animalListView = (ListView) findViewById(R.id.listView_of_animals);


//        Creating bear object

        final Bear bear = new Bear(0, 20, false, "Black Bear", 4, "sweet", "course", "ferocious");

//        Making new snake object and its methods to just practice. Not really sure how to make it
//        a part of my app...

        final Snake snake = new Snake(0, 12, true, "Rattlesnake", true, 500, true, true);

        snake.setTongueFlick(false);


//        Set adapter

        animalListView.setAdapter(mAdapterForAnimalDataToListView);


//        Mammal button's onClickListener


        addBearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

                Integer bearCubNum = Integer.parseInt(numOfCubs.getText().toString());
                final String enteredBearType = bearName.getText().toString();

                listOfAnimals.add("The " + enteredBearType + " bear has " + numOfCubs + "cubs and "
                        + "has " + bear.getClaws() + " claws. It also has " + bear.getMilk() +
                        " milk" + " and " + bear.getFur() + " fur");


                mAdapterForAnimalDataToListView.notifyDataSetChanged();


            }
        });

//      Reptile button's onClickListener

        addSnakeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

                Integer reptileScaleNum = Integer.parseInt(numOfSnakeScales.getText().toString());

                final String enteredSnakeType = snakeName.getText().toString();

                listOfAnimals.add("The " + enteredSnakeType + " snake is lined with " +
                        numOfSnakeScales + " all over its body. Did you know that the "
                        + enteredSnakeType + " usually pops out in an average year?");


                mAdapterForAnimalDataToListView.notifyDataSetChanged();


            }
        });


    }
}
