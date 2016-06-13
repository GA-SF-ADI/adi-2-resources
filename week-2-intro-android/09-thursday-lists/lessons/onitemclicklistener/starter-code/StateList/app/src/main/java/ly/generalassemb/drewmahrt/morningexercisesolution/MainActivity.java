package ly.generalassemb.drewmahrt.morningexercisesolution;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ListView mListView;
    ArrayAdapter<String> mArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView)findViewById(R.id.list);

        Button abbrevButton = (Button)findViewById(R.id.abbreviation_button);
        Button fullButton = (Button)findViewById(R.id.fullname_button);

        final ArrayList<String> abbreviationsList = new ArrayList<>(Arrays.asList("AL","AK","AZ","AR","CA","CO","CT","DE","FL","GA","HI","ID","IL","IN","IA","KS","KY","LA","ME","MD"));
        final ArrayList<String> fullNamesList = new ArrayList<>(Arrays.asList("Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Main","Maryland"));

        mArrayAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,new ArrayList<String>(abbreviationsList));
        mListView.setAdapter(mArrayAdapter);

        abbrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mArrayAdapter.clear();
                mArrayAdapter.addAll(abbreviationsList);
                mArrayAdapter.notifyDataSetChanged();
            }
        });

        fullButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mArrayAdapter.clear();
                mArrayAdapter.addAll(fullNamesList);
                mArrayAdapter.notifyDataSetChanged();
            }
        });
    }
}
