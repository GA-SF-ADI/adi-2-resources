package ly.generalassemb.drewmahrt.classes_lab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<Animal> mList;
    ArrayAdapter<Animal> mAdapter;
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAdapter = new ArrayAdapter<Animal>(MainActivity.this,android.R.layout.simple_list_item_1, mList);
        mListView = (ListView)findViewById(R.id.list_view);


        //Instantiate new Animal
        Animal cheetah = new Animal(4, 40, true, "cheetah");
        Mammal myMammal = new Mammal(4, 50, true, "lion", 500);
        Dog myDOg = new Dog(4, 20, false, "dog", 25, "boston terrier");
        Reptile myReptile = new Reptile(4, 20, false, "crocodile", false);
        Turtle myTurtle = new Turtle(4, 5, false, "sea turtle", true, 100);

        //mList.add(myDOg);
        //mList.add(myTurtle);
        ArrayList mList = new ArrayList<Animal>();

        mList.add(cheetah);
        mList.add(myMammal);
        mList.add(myReptile);

        mListView.setAdapter(mAdapter);



    }
}
