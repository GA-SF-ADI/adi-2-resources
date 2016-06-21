package gg.patrickcummins.todolist;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewListOfItemsActivity extends AppCompatActivity {
    private ArrayList<ListItem> currentList;
    private ListView currentListListView;
    private ArrayAdapter<ListItem> mItemAdapter;
    private FloatingActionButton addItemFab;
    private int NEW_ITEM_REQUEST_CODE=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list_of_items);
        Intent data = getIntent();
        currentList = (ArrayList) data.getSerializableExtra(MainActivity.LIST_OF_LISTS_SERIALIZABLE_KEY);
        currentListListView = (ListView) findViewById(R.id.listViewOfItems);
        mItemAdapter = new ArrayAdapter<ListItem>(ViewListOfItemsActivity.this, android.R.layout.simple_list_item_1, currentList);
        currentListListView.setAdapter(mItemAdapter);
        addItemFab = (FloatingActionButton) findViewById(R.id.newItemFab);
        addItemFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addItemIntent = new Intent(ViewListOfItemsActivity.this, AddItemActivity.class);
                startActivityForResult(addItemIntent, NEW_ITEM_REQUEST_CODE);
            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (resultCode == RESULT_OK) {
                String name = data.getStringExtra("NameString");
                String description = data.getStringExtra("DescriptionString");

                currentList.add(new ListItem(name,description));
                mItemAdapter.notifyDataSetChanged();

        }
    }
}
