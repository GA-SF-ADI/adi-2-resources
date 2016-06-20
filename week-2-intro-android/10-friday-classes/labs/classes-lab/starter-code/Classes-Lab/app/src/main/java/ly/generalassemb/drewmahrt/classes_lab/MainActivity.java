package ly.generalassemb.drewmahrt.classes_lab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<Animal> mList;
    ArrayAdapter<Animal> mAdapter;
    ListView mListView;
    Button mAddDog, mAddTurtle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView)findViewById(R.id.list_view);


        //Instantiate new Animal
        Animal cheetah = new Animal(4, 40, true, "cheetah");
        Mammal myMammal = new Mammal(4, 50, true, "lion", 500);
        final Dog myDOg = new Dog(4, 20, false, "dog", 25, "boston terrier");
        Reptile myReptile = new Reptile(4, 20, false, "crocodile", false);
        final Turtle myTurtle = new Turtle(4, 5, false, "sea turtle", true, 100);

        //mList.add(myDOg);
        //mList.add(myTurtle);
        mList = new ArrayList<Animal>();

        mList.add(cheetah);
        mList.add(myMammal);
        mList.add(myReptile);


        mAdapter = new ArrayAdapter<Animal>(MainActivity.this,android.R.layout.simple_list_item_1, mList);


        mListView.setAdapter(mAdapter);

        mAddDog = (Button)findViewById(R.id.add_dog);
        mAddTurtle = (Button)findViewById(R.id.add_turtle);

        View.OnClickListener addDogListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mList.add(myDOg);
                mAdapter.notifyDataSetChanged();
            }
        };

        View.OnClickListener addTurtleListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mList.add(myTurtle);
                mAdapter.notifyDataSetChanged();
            }
        };

        mAddDog.setOnClickListener(addDogListener);

        mAddTurtle.setOnClickListener(addTurtleListener);



    }
}
