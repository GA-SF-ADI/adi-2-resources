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

    public static final String REQUEST_CODE = "requestCode";

    ArrayList<Animal> mAnimalArrayList;
    ArrayAdapter<Animal> mAdapter;
    Button mAddLionButton, mAddSnakeButton;
    ListView mAnimalListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(mAnimalArrayList == null){
            mAnimalArrayList = new ArrayList<>();
        }

        mAddLionButton = (Button)findViewById(R.id.add_lion_button);
        mAddSnakeButton = (Button)findViewById(R.id.add_snake_button);

        mAdapter = new ArrayAdapter<Animal>(MainActivity.this, android.R.layout.simple_list_item_1, mAnimalArrayList);

        mAnimalListView = (ListView)findViewById(R.id.animal_list_view);
        mAnimalListView.setAdapter(mAdapter);

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
                public class MainActivity extends AppCompatActivity {

                    @Override
                    protected void onCreate(Bundle savedInstanceState) {
                        super.onCreate(savedInstanceState);
                        setContentView(R.layout.activity_main);

                        //Get output TextViews
                        TextView output = (TextView)findViewById(R.id.output_text);
                        TextView changedOutput = (TextView)findViewById(R.id.changed_output_text);

                        //Instantiate new Animal
                        Animal animal = new Animal(4,30,true,"cheetah");

                        String name;
                        int topSpeed;

                        //get name and speed values using getters
                        name = animal.getName();
                        topSpeed = animal.getTopSpeed();

                        //Set text of first TextView
                        output.setText("The " + name + " has a top speed of " + topSpeed + "mph");

                        //Set new name, speed, and endangered properties values using setters
                        animal.setName("Kangaroo");
                        animal.setTopSpeed(13);
                        animal.setIsEndangered(false);

                        //get new values using getters
                        name = animal.getName();
                        topSpeed = animal.getTopSpeed();



                        //Set text of second TextView
                        changedOutput.setText("The new animal is a " + name + " it has a top speed of " + topSpeed + "mph");
                    }
                }        intent.putExtra(REQUEST_CODE, ADD_SNAKE);
                startActivityForResult(intent, ADD_SNAKE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK){
            Animal createdAnimal = (Animal)data.getSerializableExtra(CreateAnimalActivity.ANIMAL_SERIALIZABLE_KEY);
            mAnimalArrayList.add(createdAnimal);
            mAdapter.notifyDataSetChanged();
        }
    }
}
