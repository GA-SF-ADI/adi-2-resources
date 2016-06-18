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
        mAdapter = new ArrayAdapter<Animal>(this, android.R.layout.simple_list_item_1, mAnimalList);

        animalList.setAdapter(mAdapter);

        //set OnClickListenr for buttons
        buttonBear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BearResultActivity.class);
                startActivityForResult(intent, REQUEST_CODE_BEAR);
            }
        });

    }
}
