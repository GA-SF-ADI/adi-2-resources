package ly.generalassemb.drewmahrt.classes_lab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get output TextViews
        TextView output = (TextView)findViewById(R.id.output_text);
        TextView changedOutput = (TextView)findViewById(R.id.changed_output_text);
        TextView bonusOutput = (TextView) findViewById(R.id.bonus_output_text);

        //Instantiate new Animal
        Animal animal = new Animal(4,20,false,"elephant");

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
    }
}