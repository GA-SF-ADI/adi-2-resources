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
    public static final String LIST_OF_LISTS_SERIALIZABLE_KEY = "listsSerializableKey";
    private FloatingActionButton listsFab;
    private ListView listsListView;
    private int NEW_LIST_REQUEST_CODE = 2;
    private int OPEN_LIST_REQUEST_CODE =4;

    private ArrayList<NamedList> listsArrayList;

    ArrayAdapter<NamedList> mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setVariables();
        listsListView.setAdapter(mAdapter);
        setAllOnClickListeners();





    }

    public void setVariables(){
        listsFab = (FloatingActionButton) findViewById(R.id.newListFab);
        listsListView = (ListView) findViewById(R.id.listListView);
        listsArrayList = new ArrayList<NamedList>();
        mAdapter = new ArrayAdapter<NamedList>(MainActivity.this, android.R.layout.simple_list_item_1, listsArrayList);
    }
    public void setAllOnClickListeners(){
        listsFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addListIntent = new Intent(MainActivity.this, CreateNewListActivity.class);
                startActivityForResult(addListIntent, NEW_LIST_REQUEST_CODE);

            }
        });
        listsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent openListIntent = new Intent(MainActivity.this, ViewListOfItemsActivity.class);
                openListIntent.putExtra(LIST_OF_LISTS_SERIALIZABLE_KEY, listsArrayList.get(position).getmArrayList());
                startActivityForResult(openListIntent, OPEN_LIST_REQUEST_CODE );

            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (resultCode == RESULT_OK) {
            if (requestCode == NEW_LIST_REQUEST_CODE) {
                String newListNameString = data.getStringExtra("newList");
                listsArrayList.add(new NamedList(newListNameString));
                mAdapter.notifyDataSetChanged();
            }
        }
    }
}
