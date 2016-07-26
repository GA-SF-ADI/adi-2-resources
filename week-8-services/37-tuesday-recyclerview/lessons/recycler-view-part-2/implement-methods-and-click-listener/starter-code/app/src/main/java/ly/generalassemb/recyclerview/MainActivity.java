package ly.generalassemb.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CustomRecyclerViewAdapter.OnRecyclerViewItemClickListener{// TODO: Step 8e) Implement the interface you created
    private RecyclerView recyclerView;
    private RecyclerView.Adapter rvAdapter;
    private RecyclerView.LayoutManager rvLayoutManager;

    private ArrayList<String> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        dataList.add("Arizona");
        dataList.add("California");
        dataList.add("New Mexico");
        dataList.add("New York");

        rvLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(rvLayoutManager);

        // TODO: Step 8e) Create adapter, pass in data and the interface you implemented
        rvAdapter = new CustomRecyclerViewAdapter(dataList,this);
        recyclerView.setAdapter(rvAdapter);
    }

    // TODO: Step 8e) Implement your interface and make a toast of the position and or data

@Override
    public void onItemClick(int position) {
    Toast.makeText(MainActivity.this, "Clicked on " + dataList.get(position) + " at position " + position, Toast.LENGTH_SHORT).show();
}

}
