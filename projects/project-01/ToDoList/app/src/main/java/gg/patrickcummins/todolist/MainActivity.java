package gg.patrickcummins.todolist;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String LIST_OF_LISTS_SERIALIZABLE_KEY = "listsSerializableKey";
    private FloatingActionButton listsFab;
    private ListView listsListView;
    private int NEW_LIST_REQUEST_CODE = 2;
    private int OPEN_LIST_REQUEST_CODE = 4;
    public static final String PREFS_NAME = "MyPrefsFile";

    private ArrayList<NamedList> listsArrayList;

    private CustomListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("To Do List");

        setVariables();
        setAllOnClickListeners();


    }

    private void setVariables() {
        listsFab = (FloatingActionButton) findViewById(R.id.newListFab);
        listsListView = (ListView) findViewById(R.id.listListView);
        listsArrayList = new ArrayList<NamedList>();
        mAdapter = new CustomListAdapter(MainActivity.this, listsArrayList);
        listsListView.setAdapter(mAdapter);
    }

    private void setAllOnClickListeners() {
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
                openListIntent.putExtra("listPosition", position);
                openListIntent.putExtra("name", listsArrayList.get(position).getmName());
                startActivityForResult(openListIntent, OPEN_LIST_REQUEST_CODE);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == NEW_LIST_REQUEST_CODE) {
                String newListNameString = data.getStringExtra("newList");
                String color = data.getStringExtra("color");
                listsArrayList.add(new NamedList(newListNameString, color));
                mAdapter.notifyDataSetChanged();
            } else if (requestCode == OPEN_LIST_REQUEST_CODE) {
                int position = data.getIntExtra("listPosition", -1);
                listsArrayList.get(position).setmArrayList((ArrayList) data.getSerializableExtra(ViewListOfItemsActivity.REPLACE_LIST_SERIALIZABLE_KEY));

            }
        }

    }


}
