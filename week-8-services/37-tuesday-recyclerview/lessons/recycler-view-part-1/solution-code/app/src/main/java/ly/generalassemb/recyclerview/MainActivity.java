package ly.generalassemb.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter rvAdapter;
    private RecyclerView.LayoutManager rvLayoutManager;

    private LinkedList<String> dataList = new LinkedList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find recycler view
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        // add data to our list
        dataList.add("Arizona");
        dataList.add("California");
        dataList.add("New Mexico");
        dataList.add("New York");

        // linear layout manager for lists
        rvLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(rvLayoutManager);

        // create the custom adapter with our data and set it on the recyclerView
        rvAdapter = new CustomRecyclerViewAdapter(dataList);
        recyclerView.setAdapter(rvAdapter);
    }
}
