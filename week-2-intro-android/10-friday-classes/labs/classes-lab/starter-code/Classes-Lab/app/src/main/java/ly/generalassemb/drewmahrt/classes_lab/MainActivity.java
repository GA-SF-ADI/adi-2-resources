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

        //Instantiate new Animal
        Animal animal = new Animal(2, 20, true, "Mike");

        String name;
        int topSpeed;
        int numlegs;
        boolean isEndangered;

        //get name and speed values using getters
        name = animal.getName();
        topSpeed = animal.topSpeed;
        numlegs = animal.getNumLegs();
        isEndangered = animal.getisEndangered();

        //Set text of first TextView
        output.setText("The " + name + " has a top speed of " + topSpeed + " mph with " + numlegs + " legs!");

        //Set new name, speed, and endangered properties values using setters
        animal.setName("Jamey");
        animal.setTopSpeed(30);
        animal.setNumLegs(2);
        animal.setisEndangered(true);

        //get new values using getters
        name = animal.getName();
        topSpeed = animal.getTopSpeed();
        numlegs = animal.getNumLegs();
        animal.getisEndangered();

        //Set text of second TextView
        if (animal.isEndangered == true){
            changedOutput.setText("The " + name + " has a top speed of " + topSpeed + " mph with " + numlegs + " legs and is endangered!");
        }
        else {
            changedOutput.setText("The " + name + " has a top speed of " + topSpeed + " mph with " + numlegs + " legs! and is not endangered!");
        }
    }
}
