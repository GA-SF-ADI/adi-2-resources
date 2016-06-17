package ly.generalassemb.drewmahrt.classes_lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static android.media.CamcorderProfile.get;

public class MainActivity extends AppCompatActivity {
    public static int REQUEST_CODE;
    ArrayList<Animal> animalList;
    ArrayAdapter<Animal> mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animalList = new ArrayList<>();

        animalList.add(new Animal(4,20, false, "Dog"));
        animalList.add(new Animal(4, 5, false, "Cat"));
        animalList.add(new Animal(2, 6, false, "Penguin"));





        mAdapter = new ArrayAdapter<Animal>(this, android.R.layout.simple_list_item_1, animalList);

        ListView mListView = (ListView) findViewById(R.id.myListView);

        mListView.setAdapter(mAdapter);
        final Button addAnimal = (Button) findViewById(R.id.addAnimal);
        Button addDoggo = (Button) findViewById(R.id.addDoggo);
        Button addTurtle = (Button) findViewById(R.id.addTurtle);
        addAnimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                REQUEST_CODE=1;
                Intent addAnimalIntent = new Intent(MainActivity.this, AddAnimal.class);
                addAnimalIntent.putExtra("RequestCode", REQUEST_CODE);
                startActivityForResult(addAnimalIntent, REQUEST_CODE);
            }
        });
        addDoggo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                REQUEST_CODE=2;
                Intent addAnimalIntent = new Intent(MainActivity.this, AddAnimal.class);
                addAnimalIntent.putExtra("RequestCode", REQUEST_CODE);
                startActivityForResult(addAnimalIntent, REQUEST_CODE);

            }
        });
        addTurtle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                REQUEST_CODE=3;
                Intent addAnimalIntent = new Intent(MainActivity.this, AddAnimal.class);
                addAnimalIntent.putExtra("RequestCode", REQUEST_CODE);
                startActivityForResult(addAnimalIntent, REQUEST_CODE);

            }
        });




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


            if(resultCode ==RESULT_OK){
                String name = data.getStringExtra("AnimalName");
                int numLegs = data.getIntExtra("AnimalLegs", -1);
                int topSpeed = data.getIntExtra("AnimalTopSpeed", -1);
                boolean isEndangered = data.getBooleanExtra("AnimalIsEndangered", false);
                if (requestCode==1) {
                    animalList.add(new Animal(numLegs, topSpeed, isEndangered, name));
                } else if(requestCode == 2){
                    String doggo = data.getStringExtra("Doggo");
                    animalList.add(new Doggo(numLegs,topSpeed,isEndangered,name,doggo));
                }else if (requestCode ==3){
                    String turtle = data.getStringExtra("Turtle");
                    animalList.add(new Turtle(numLegs,topSpeed,isEndangered,name,turtle));
                }
                mAdapter.notifyDataSetChanged();

            }

    }
}
