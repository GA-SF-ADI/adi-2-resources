package ly.generalassemb.drewmahrt.classes_lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Animal> mAnimalList;
    ArrayAdapter<Animal> mAdapter;
    int REQUEST_CODE_BEAR = 45;
    int REQUEST_CODE_SNAKE = 56;
    int REQUEST_CODE_DOG = 67;
    int REQUEST_CODE_CAT = 78;
    Bear bear;
    Snake snake;
    Dog dog;
    Cat cat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //link XML to JAVA
        Button buttonBear = (Button)findViewById(R.id.bear);
        Button buttonSnake = (Button)findViewById(R.id.snake);
        Button buttonDog = (Button)findViewById(R.id.dog);
        Button buttonCat = (Button)findViewById(R.id.cat);

        ListView animalList = (ListView) findViewById(R.id.list_of_animals);

        //Instantiate list
        mAnimalList = new ArrayList<>();

        //Instantiate adapter
        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mAnimalList);

        animalList.setAdapter(mAdapter);

        //set OnClickListenr for buttons
        buttonBear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BearResultActivity.class);
                startActivityForResult(intent, REQUEST_CODE_BEAR);

            }
        });

        buttonSnake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SnakeResultActivity.class);
                startActivityForResult(intent, REQUEST_CODE_SNAKE);

            }
        });

        buttonDog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DogResultActivity.class);
                startActivityForResult(intent, REQUEST_CODE_DOG);

            }
        });

        buttonCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CatResultActivity.class);
                startActivityForResult(intent, REQUEST_CODE_CAT);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == REQUEST_CODE_BEAR) {
            if (resultCode == RESULT_OK) {
                String name = data.getStringExtra("name");
                int speed = data.getIntExtra("top speed", 0);
                boolean isEndangered;
                if (data.getStringExtra("is endangered").equals("Y")) {
                    isEndangered = true;
                } else isEndangered = false;
                String color = data.getStringExtra("color");
                boolean carnivorous;
                if (data.getStringExtra("carnivorous").equals("Y")) {
                    carnivorous = true;
                } else carnivorous = false;
                int bite = data.getIntExtra("bite force", 0);

                bear = new Bear(speed, isEndangered, name, color, carnivorous, bite);

                mAnimalList.add(bear);
            }
        }

        if(requestCode == REQUEST_CODE_SNAKE){
            if(resultCode == RESULT_OK){
                String name = data.getStringExtra("name");
                int speed = data.getIntExtra("top speed", 0);
                boolean isEndangered;
                if(data.getStringExtra("is endangered").equals("Y")){
                    isEndangered = true;
                } else isEndangered = false;
                boolean ugly;
                if(data.getStringExtra("ugly").equals("Y")){
                    ugly = true;
                } else ugly = false;
                boolean venom;
                if(data.getStringExtra("venom").equals("Y")){
                    venom = true;
                } else venom = false;
                boolean kill;
                if(data.getStringExtra("kill").equals("Y")){
                    kill = true;
                } else kill = false;

                snake = new Snake(speed, isEndangered, name, ugly, venom, kill);

                mAnimalList.add(snake);
            }

        }

        if(requestCode == REQUEST_CODE_DOG){
            if(resultCode == RESULT_OK){
                String name = data.getStringExtra("name");
                int speed = data.getIntExtra("top speed", 0);
                String color = data.getStringExtra("color");
                boolean guard;
                if(data.getStringExtra("guard").equals("Y")){
                    guard = true;
                } else guard = false;
                String size = data.getStringExtra("fetch");
                boolean fetch;
                if(data.getStringExtra("fetch").equals("Y")){
                    fetch = true;
                } else fetch = false;

                dog = new Dog(speed, name, color, guard, size, fetch);

                mAnimalList.add(dog);
            }

        }

        if(requestCode == REQUEST_CODE_CAT){
            if(resultCode == RESULT_OK){
                String name = data.getStringExtra("name");
                int speed = data.getIntExtra("top speed", 0);
                String color = data.getStringExtra("color");
                int numLives = data.getIntExtra("num lives", 0);

                cat = new Cat(speed, name, color, numLives);

                mAnimalList.add(cat);
            }

        }

        mAdapter.notifyDataSetChanged();
    }
}
