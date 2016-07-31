package ly.generalassemb.serviceexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter rvAdapter;
    //To use regular linear layout-->
    //private RecyclerView.LayoutManager rvLayoutManager;
    private GridLayoutManager gridLayoutManager;
    private ArrayList<String> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        dataList.add("Audrey");
        dataList.add("Liz");
        dataList.add("Idaho");
        dataList.add("Peking Duck");
        dataList.add("coffee");
        dataList.add("tea");


        gridLayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(gridLayoutManager);

        rvAdapter = new CustomRecyclerAdapter(dataList);
        recyclerView.setAdapter(rvAdapter);

    }

}
