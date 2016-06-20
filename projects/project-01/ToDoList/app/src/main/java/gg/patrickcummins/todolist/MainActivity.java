package gg.patrickcummins.todolist;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static android.R.attr.data;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton listsFab;
    private ListView listsListView;
    private static final int REQUEST_CODE = 2;
    private static ArrayList<NamedList> listsArrayList;

    ArrayAdapter<NamedList> mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listsFab = (FloatingActionButton) findViewById(R.id.newListFab);
        listsListView = (ListView) findViewById(R.id.listListView);
        listsArrayList = new ArrayList<NamedList>();
        mAdapter = new ArrayAdapter<NamedList>(MainActivity.this, android.R.layout.simple_list_item_1, listsArrayList);
        listsListView.setAdapter(mAdapter);





        listsFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addListIntent = new Intent(MainActivity.this, CreateNewListActivity.class);
                startActivityForResult(addListIntent, REQUEST_CODE);

            }
        });
        listsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent openListIntent = new Intent(MainActivity.this, ViewStringListActivity.class);
                openListIntent.putExtra("currentList", listsArrayList.get(position));
                st
            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (resultCode == RESULT_OK) {
            String newListNameString = data.getStringExtra("newList");
            listsArrayList.add(new NamedList(newListNameString));
            mAdapter.notifyDataSetChanged();
        }
    }
}
