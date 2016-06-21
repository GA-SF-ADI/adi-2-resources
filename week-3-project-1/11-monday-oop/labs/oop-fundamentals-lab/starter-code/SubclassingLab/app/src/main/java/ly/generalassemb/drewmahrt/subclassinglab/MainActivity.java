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
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final int ADD_LION = 100;
    public static final int ADD_SNAKE = 200;

    public static final String REQUEST_CODE = "requestCode";

    ArrayList<Animal> mAnimalArrayList;
    ArrayAdapter<Animal> mAdapter;
    Button mAddLionButton, mAddSnakeButton;
    ListView mAnimalListView;
    Zoo zoo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(mAnimalArrayList == null){
            mAnimalArrayList = new ArrayList<>();
        }

        //mAddLionButton = (Button)findViewById(R.id.add_lion_button);
        //mAddSnakeButton = (Button)findViewById(R.id.add_snake_button);

        zoo = Zoo.getInstance();

        Lion simba = new Lion(true);
        Snake rattleSnake = new Snake(true);
        Mammal dog = new Mammal(4, 30, false, "Dog");

        zoo.addAnimal(simba);
        zoo.addAnimal(rattleSnake);
        zoo.addAnimal(dog);

        mAnimalArrayList=zoo.getAnimals();

        mAdapter = new ArrayAdapter<Animal>(MainActivity.this, android.R.layout.simple_list_item_1, mAnimalArrayList);

        mAnimalListView = (ListView)findViewById(R.id.animal_list_view);
        mAnimalListView.setAdapter(mAdapter);

        mAnimalListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int myPosition = position;
                makeNoise(myPosition);

            }
        });






    }

    protected void makeNoise(int position){
        if(position==0){
            Toast.makeText(MainActivity.this,"Lion goes ROAR",Toast.LENGTH_SHORT).show();
        }else if(position==1){
            Toast.makeText(MainActivity.this,"Snake goes HISS",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MainActivity.this,"Dog goes WOOF",Toast.LENGTH_SHORT).show();
        }

    }


}
