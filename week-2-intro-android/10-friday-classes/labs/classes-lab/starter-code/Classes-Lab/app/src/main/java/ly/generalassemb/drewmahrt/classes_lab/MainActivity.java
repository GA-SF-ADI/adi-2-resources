package ly.generalassemb.drewmahrt.classes_lab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> animal_list = new ArrayList<>();
    Mammal1 mam1;
    Mammal2 mam2;
    Reptile1 rep1;
    Reptile2 rep2;
    EditText m1;
    EditText m2;
    EditText r1;
    EditText r2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get output TextViews
        TextView output = (TextView)findViewById(R.id.output_text);
        TextView changedOutput = (TextView)findViewById(R.id.changed_output_text);
        TextView bonusOutput = (TextView) findViewById(R.id.bonus_output_text);

        m1 = (EditText) findViewById(R.id.m1);
        m2 = (EditText) findViewById(R.id.m2);
        r1 = (EditText) findViewById(R.id.r1);
        r2 = (EditText) findViewById(R.id.r2);

        //Instantiate new Animal
        final Animal animal = new Animal(4,20,false,"elephant");

        String name;
        int topSpeed;

        //get name and speed values using getters
        name = animal.getName();
        topSpeed = animal.getTopSpeed() ;

        //Set text of first TextView
        output.setText("The "+name+" has a top speed of "+topSpeed+" mph");

        //Set new name, speed, and endangered properties values using setters
        animal.setName("lion");
        animal.setTopSpeed(50);
        animal.setIsEndangered(false);

        //get new values using getters
        name = animal.getName();
        topSpeed = animal.getTopSpeed() ;

        //Set text of second TextView
        changedOutput.setText("The "+name+" has a top speed of "+topSpeed+" mph");

        //bonus exercise

        bonusOutput.setText(animal.printMyAnimalProperties(animal));

// ***********************************************2nd lab_Classes and Subclasses**************************************************************

        ListView listView = (ListView) findViewById(R.id.listView);

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,animal_list);
        listView.setAdapter(arrayAdapter);

        Button button = (Button) findViewById(R.id.b);

        View.OnClickListener buttonOnClickListener = new View.OnClickListener(){
            @Override
          public void onClick(View v){

                mam1 = new Mammal1(4,40,true,m1.getText().toString(),20);

                mam2 = new Mammal2(4,40,true,m2.getText().toString(),20,50);

                rep1 = new Reptile1(4,40,true,r1.getText().toString(),"black");

                rep2 = new Reptile2(4,40,true,r2.getText().toString(),"grey",80);

                animal_list.add(mam1.getName());
                animal_list.add(mam2.getName());
                animal_list.add(rep1.getName());
                animal_list.add(rep2.getName());

                arrayAdapter.notifyDataSetChanged();
            }
        };

        button.setOnClickListener(buttonOnClickListener);


    }
}