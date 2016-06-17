package ly.generalassemb.drewmahrt.classes_lab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Instantiate new Animal
        Animal kangaroo = new Animal (4 ,20, false, "Kangaroo", "Australia");
        Animal bear = new Animal (4 ,50, true, "Bear", "the woods");
        Mammals polarBear = new Mammals (4, 60, true, "Polar Bear", "arctic", "fur");
        Reptile snake = new Reptile(0, 30, false, "Snake", "jungle", "scales");
        SeaOtter myCuteSeaOtter = new SeaOtter(4, 45, true, "Sea Otter", "ocean", "fur", "webbed feet");
        Chameleon myChameleon = new Chameleon(4, 10, true, "Chameleon", "trees", "scales" , true);

        final Button mammalButton = (Button) findViewById(R.id.mammal_button);
        mammalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mammalIntent = new Intent (MainActivity.this, Mammalactivity.class);
                startActivity(mammalIntent);
            }
        });

        final Button reptileButton = (Button) findViewById(R.id.reptile_button);
        reptileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reptileIntent = new Intent (MainActivity.this, Mammalactivity.class);
                startActivity(reptileIntent);
            }
        });
    }
}
