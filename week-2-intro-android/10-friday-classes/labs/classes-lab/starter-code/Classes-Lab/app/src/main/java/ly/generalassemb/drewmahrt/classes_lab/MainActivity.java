package ly.generalassemb.drewmahrt.classes_lab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
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

        //Instantiate new Animal
        Animal animal = new Animal(4, 25, true, "Elephant");


        String name;
        int topSpeed;

        //get name and speed values using getters
        name = animal.getName();

        topSpeed = animal.getTopSpeed();

        //Set text of first TextView
        output.setText("The " + name + " has a top speed of " + topSpeed + " mph");

        //Set new name, speed, and endangered properties values using setters
        animal.setName("Lion");
        animal.setTopSpeed(50);
        animal.setIsEndangered(false);

        //get new values using getters
        name = animal.getName();
        topSpeed = animal.getTopSpeed();

        //Set text of second TextView
        changedOutput.setText("The " + name + " has a top speed of " + topSpeed + " mph");

        Button addMammalButton = (Button) findViewById(R.id.mammal_button);
        Button addReptileButton = (Button) findViewById(R.id.reptile_button);


//        mammal, offspring, reptile name, scales


        EditText mammalName = (EditText) findViewById(R.id.mammal_name);
        Integer numOfMammalOffSpring = (Integer) findViewById(R.id.number_of_offspring);
        EditText reptileName = (EditText) findViewById(R.id.reptile_name);
        Integer numOfReptileScales = (Integer) findViewById(R.id.number_of_scales);

        Integer reptileScaleNum = parseInt(numOfReptileScales)

        addMammalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Mammal button clicked", Toast.LENGTH_SHORT).show();

            }
        });


        addReptileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Reptile button clicked", Toast.LENGTH_SHORT).show();


            }
        });


    }
}
