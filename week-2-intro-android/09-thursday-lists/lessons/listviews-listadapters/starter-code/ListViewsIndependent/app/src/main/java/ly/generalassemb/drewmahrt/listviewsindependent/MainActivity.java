package ly.generalassemb.drewmahrt.listviewsindependent;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    LinkedList<String> mStringList;
    ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,exampleList);

        listView.setAdapter(arrayAdapter);

        //Instantiate your LinkedList
        mStringList = LinkedList<String> mStringList = new LinkedList<String>();

        mStringList.add("item1");
        mStringList.add("item2");
        mStringList.add("item3");
        mStringList.add("item3");

        //Instantiate your adapter
       mAdapter sMAdapter = new mAdapter<mStringList>(this.mAdapter,);

        )

        //Get your ListView and set the adapter
        ListView listView = new (ListView) findViewById(R.id.ListView1xml);
        )

        //Complete the FloatingActionButton onClick method to add a list item
        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //Complete the ListView onItemLongClick code to remove list items
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                m
                return true;
            }
        });

    }
}
