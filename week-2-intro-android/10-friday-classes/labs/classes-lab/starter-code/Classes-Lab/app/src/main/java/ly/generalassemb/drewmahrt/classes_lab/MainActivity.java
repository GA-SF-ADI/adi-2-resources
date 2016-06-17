package ly.generalassemb.drewmahrt.classes_lab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Animal> animalList = new ArrayList<>();
        animalList.add(new Animal(4,20, false, "Dog"));
        animalList.add(new Animal(4, 5, false, "Cat"));
        animalList.add(new Animal(2, 6, false, "Penguin"));
        ArrayList<String> animalString = new ArrayList<>();
        for (int i = 0; i < animalList.size(); i++) {
            animalString.add(animalList.get(i).getAnimalNameandSpeedPrint());

        }

        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, animalString);

        ListView mListView = (ListView) findViewById(R.id.myListView);

        mListView.setAdapter(mAdapter);


    }
}
