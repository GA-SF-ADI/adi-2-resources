package ly.generalassemb.drewmahrt.subclassinglab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final int ADD_LION = 100;
    public static final int ADD_SNAKE = 200;
    public static final int ADD_REPTILE = 300;
    public static final int ADD_MAMMAL = 400;

    public static final String REQUEST_CODE = "requestCode";

    //ArrayList<Animal> mAnimalArrayList;
    ArrayAdapter<Animal> mAdapter;
    Button mAddLionButton, mAddSnakeButton, mAddReptileButton, mAddMammalButton, mListAnimals;
    ListView mAnimalListView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAddLionButton = (Button)findViewById(R.id.add_lion_button);
        mAddSnakeButton = (Button)findViewById(R.id.add_snake_button);
        mAddReptileButton = (Button) findViewById(R.id.add_reptile_button);
        mAddMammalButton = (Button) findViewById(R.id.add_mammal_button);

        mAdapter = new ArrayAdapter<Animal>(MainActivity.this, android.R.layout.simple_list_item_1, Zoo.getInstance().getAnimals());
        //Did not remember this and had to look it up... confused about what should go here
        mAnimalListView = (ListView)findViewById(R.id.animal_list_view);
        mAnimalListView.setAdapter(mAdapter);

        final Zoo myZoo = new Zoo();

        // add animals here
       // myZoo.addAnimal(Lion);
       // myZoo.addAnimal(Snake);
       // myZoo.addAnimal(Reptile);
       // myZoo.addAnimal(Mammal);

        //if(myZoo == null) {
           // myZoo = new ArrayList<>();
        //}


        mAddLionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CreateAnimalActivity.class);
                intent.putExtra(REQUEST_CODE, ADD_LION);
                startActivityForResult(intent, ADD_LION);
            }
        });

        mAddSnakeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CreateAnimalActivity.class);
                intent.putExtra(REQUEST_CODE, ADD_SNAKE);
                startActivityForResult(intent, ADD_SNAKE);
            }
        });


        mAddReptileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CreateAnimalActivity.class);
                intent.putExtra(REQUEST_CODE, ADD_REPTILE);
                startActivityForResult(intent, ADD_REPTILE);
            }
        });

        mAddMammalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CreateAnimalActivity.class);
                intent.putExtra(REQUEST_CODE, ADD_MAMMAL);
                startActivityForResult(intent, ADD_MAMMAL);
            }
        });


        mListAnimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SeeMyList.class);
                startActivity(intent);
            }
        });
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK){
            Animal createdAnimal = (Animal)data.getSerializableExtra(CreateAnimalActivity.ANIMAL_SERIALIZABLE_KEY);
            Zoo.getInstance().addAnimal(createdAnimal);
            //had to look here as well. I thought I had to create my own zoo within the main...
            mAdapter.notifyDataSetChanged();
        }
    }
}
