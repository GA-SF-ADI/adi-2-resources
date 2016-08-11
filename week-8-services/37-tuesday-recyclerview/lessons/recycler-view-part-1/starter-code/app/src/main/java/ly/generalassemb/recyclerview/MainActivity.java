package ly.generalassemb.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    // TODO Step 3, declare variable here
    private RecyclerView recyclerView;
    private RecyclerView.Adapter rvAdapter;
    private RecyclerView.LayoutManager rvLayoutManager;
    private LinkedList<String> dataList = new LinkedList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        for (int i = 0; i < 1000; i++) {
            dataList.add("Hodor");
        }


        rvLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(rvLayoutManager);
        rvAdapter = new CustomRecyclerViewAdapter(dataList);
        recyclerView.setAdapter(rvAdapter);





    }
}
