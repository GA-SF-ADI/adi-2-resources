package ly.generalassemb.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CustomAdapter.OnRecyclerViewItemClickListener {
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

        rvAdapter = new CustomAdapter(dataList, this);
        recyclerView.setAdapter(rvAdapter);

    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(MainActivity.this, "Clicked on " + dataList.get(position) + " at position " + position, Toast.LENGTH_SHORT).show();
    }
}
