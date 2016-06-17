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
       Animal kangaroo = new Animal (4 ,20, false, "Kangaroo");
        Animal bear = new Animal (4 ,50, true, "Bear");


        //get name and speed values using getters

        //Set text of first TextView
        output.setText("Your animal is " + kangaroo.getName() + " " + "and its mph is" + " " +kangaroo.getTopSpeed() + ".");

        //Set new name, speed, and endangered properties values using setters

        

        //get new values using getters

        //topSpeed = 50;

        //Set text of second TextView
        changedOutput.setText("Your animal is " + bear.getName() + " " + "and its mph is" + " " +bear.getTopSpeed() + ".");
    }
}
