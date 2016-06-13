package ly.generalassemb.drewmahrt.classeslesson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView)findViewById(R.id.example_listview);

        //Ignore the two lines below
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,new String[]{"item 1","item 2","item 3","item 4","item 5"});
        listView.setAdapter(adapter);

        //Set your OnItemClickListener here for the listView above
        
    }
}
