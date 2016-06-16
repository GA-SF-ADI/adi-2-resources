package ly.generalassemb.drewmahrt.morningexercisesolution;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    ListView mListView;
    ArrayAdapter<String> mArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView)findViewById(R.id.list);

        final ArrayList<String> abbreviationsList = new ArrayList<>(Arrays.asList("AL","AK","AZ","AR","CA","CO","CT","DE","FL","GA","HI","ID","IL","IN","IA","KS","KY","LA","ME","MD"));
        final ArrayList<String> fullNamesList = new ArrayList<>(Arrays.asList("Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Main","Maryland"));

        /**
         * Third list holding either an abbreviation or full name of a state
         *
         * We can do this because all positions of abbreviationsList and fullNamesList match.
         *
         * For example:
         * - Position 0 either holds AL or Alabama
         * - Position 3 either holds AR or Arkansas
         */
        final ArrayList<String> states = new ArrayList<>(abbreviationsList);

        mArrayAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1, states);
        mListView.setAdapter(mArrayAdapter);

        /**
         * Using the third list as our set of data in the adapter, we can compare the value in the
         * adapter again the value in:
         * - Abbreviations list
         * - Full name list
         *
         * If we find a match we change the string to be the value of the other list. So if I detect 'CA'
         * I will reassign that string to now be "California".
         *
         * Remember that positions of both lists are synced to each other. Index 0 is for AL and Alabama.
         */
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String currentString = mArrayAdapter.getItem(position);
                if (currentString.equals(abbreviationsList.get(position))){
                    currentString = fullNamesList.get(position);
                } else if (currentString.equals(fullNamesList.get(position))){
                    currentString = abbreviationsList.get(position);
                }
                // update the string at the current position that was clicked
                states.set(position, currentString);

                // make sure we reflect the change in the list by notifying adapter to redraw
                mArrayAdapter.notifyDataSetChanged();
            }
        });
    }
}
