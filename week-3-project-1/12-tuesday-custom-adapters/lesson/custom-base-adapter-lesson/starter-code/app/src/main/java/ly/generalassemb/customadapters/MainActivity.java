package ly.generalassemb.customadapters;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<Animal> animalList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find list view in main activity layout
        listView = (ListView) findViewById(R.id.list_view);

        // add some data to our animalList
        animalList = new ArrayList<>();
        animalList.add(new Animal("cow", "moo"));
        animalList.add(new Animal("cat", "meow"));
        animalList.add(new Animal("dog", "woof"));

        // add 100 fake animals to the list
        for (int i = 0; i < 100; i++){
            String iString = String.valueOf(i);
            animalList.add(new Animal(iString, iString + iString));
        }

        // create an instance of our CustomBaseAdapter class, passing in context and data list
        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(MainActivity.this, animalList);

        // set custom adapter on our list view
        listView.setAdapter(customBaseAdapter);
    }
}
