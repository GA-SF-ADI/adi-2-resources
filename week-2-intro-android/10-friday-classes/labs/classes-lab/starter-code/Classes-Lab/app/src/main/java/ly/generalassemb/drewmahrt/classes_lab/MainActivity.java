package ly.generalassemb.drewmahrt.classes_lab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    ArrayList <Animal>animals;
    ArrayAdapter mAdapter;
    Button mammalsBttn;
    Button reptileBttn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mammalsBttn = (Button) findViewById(R.id.mammalBtton);
        reptileBttn = (Button) findViewById(R.id.reptileBtton);
        mAdapter= new ArrayAdapter<Animal>(MainActivity.this,android.R.layout.simple_list_item_1, animals);

        ListView animalListView= (ListView)findViewById(R.id.animalListView);
        animalListView.setAdapter(mAdapter);

        //Get output TextViews
        TextView output = (TextView)findViewById(R.id.output_text);
        TextView changedOutput = (TextView)findViewById(R.id.changed_output_text);

        //Instantiate new Animal
        Animal animal =  new Animal(4,60,false,"Tiger");
        Mammal mammal = new Mammal(4,20,false,"Mammal",true);
        Reptile reptile = new Reptile(0,10,false,"Reptile","I am a reptile",true,true);
        Snake snake1 = new Snake (0,10,false,"Snake","I am a snake",true,true,5,true);
        Bear bear1 = new Bear (4,20,false,"Bear",true,true,"California");


        animals.add(snake1);
        animals.add(bear1);
        String name;
        int topSpeed;

        //get name and speed values using getters
        topSpeed=animal.getTopSpeed();
        name =animal.getName();

        //Set text of first TextView
        output.setText("The "+name+" has a top speed of "+ topSpeed);

        //Set new name, speed, and endangered properties values using setters
        animal.setName("dog");
        animal.setTopSpeed(33);
        animal.setisEndangered(true);

        //get new values using getters
        name =animal.getName();
        topSpeed=animal.getTopSpeed();

        //Set text of second TextView
        changedOutput.setText("The "+name+" has a top speed of "+ topSpeed);
        mammalsBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
        reptileBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}
