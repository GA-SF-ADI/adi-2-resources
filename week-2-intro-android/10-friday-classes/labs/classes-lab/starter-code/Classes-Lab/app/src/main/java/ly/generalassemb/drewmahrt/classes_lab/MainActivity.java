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
        Animal cheetah = new Animal(4, 40, true, "cheetah");

        String name;
        int topSpeed;

        //get name and speed values using getters
        name = cheetah.getName();
        topSpeed = cheetah.getTopSpeed();

        //Set text of first TextView
        output.setText("The " + name + " has a top speed of " + topSpeed);

        //Set new name, speed, and endangered properties values using setters
        cheetah.setName("Sloth");
        cheetah.setTopSpeed(1);

        //get new values using getters
        name = cheetah.getName();
        topSpeed = cheetah.getTopSpeed();

        //Set text of second TextView
        changedOutput.setText("The " + name + " has a top speed of " + topSpeed);
    }
}
