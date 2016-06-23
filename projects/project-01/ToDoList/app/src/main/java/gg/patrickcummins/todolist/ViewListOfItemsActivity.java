package gg.patrickcummins.todolist;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.data;

public class ViewListOfItemsActivity extends AppCompatActivity {
    private ArrayList<ListItem> currentList;
    private ListView currentListListView;
    private CustomItemAdapter mItemAdapter;
    private FloatingActionButton addItemFab;
    private int NEW_ITEM_REQUEST_CODE = 1;
    private int EDIT_ITEM_REQUEST_CODE =2;
    private int currentListPosition;
    public static final String REPLACE_LIST_SERIALIZABLE_KEY = "replacelistSerializableKey";
    public static final String EDIT_ITEM_SERIALIZABLE_KEY = "editItemKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list_of_items);

        setVariables();

        addItemFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addItemIntent = new Intent(ViewListOfItemsActivity.this, AddItemActivity.class);
                startActivityForResult(addItemIntent, NEW_ITEM_REQUEST_CODE);
            }
        });
        currentListListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("Button Clicked", "Clicked an item");
                Intent editItemIntent = new Intent(ViewListOfItemsActivity.this, EditItemActivity.class);
                editItemIntent.putExtra(EDIT_ITEM_SERIALIZABLE_KEY, currentList.get(position));
                editItemIntent.putExtra("position", position);
                startActivityForResult(editItemIntent, EDIT_ITEM_REQUEST_CODE);
            }
        });


    }

    private void setVariables() {
        Intent data = getIntent();
        currentListPosition = data.getIntExtra("listPosition", -1);
        currentList = (ArrayList) data.getSerializableExtra(MainActivity.LIST_OF_LISTS_SERIALIZABLE_KEY);
        currentListListView = (ListView) findViewById(R.id.listViewOfItems);
        mItemAdapter = new CustomItemAdapter(ViewListOfItemsActivity.this, currentList);
        currentListListView.setAdapter(mItemAdapter);
        addItemFab = (FloatingActionButton) findViewById(R.id.newItemFab);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == NEW_ITEM_REQUEST_CODE ) {
                String name = data.getStringExtra("NameString");
                String description = data.getStringExtra("DescriptionString");
                String color = data.getStringExtra("color");
                currentList.add(new ListItem(name, description, color));

                mItemAdapter.notifyDataSetChanged();
            }else if (requestCode == EDIT_ITEM_REQUEST_CODE){
                ListItem currentEditedListItem = (ListItem) data.getSerializableExtra(EditItemActivity.ITEM_EDITED_SERIALIZABLE_KEY);
                int currentListItemEditedPosition = data.getIntExtra("position", -1);
                currentList.set(currentListItemEditedPosition, currentEditedListItem);
                mItemAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void onBackPressed() {
        Intent backPressedIntent = new Intent();
        backPressedIntent.putExtra("listPosition", currentListPosition);
        backPressedIntent.putExtra(REPLACE_LIST_SERIALIZABLE_KEY, currentList);
        setResult(RESULT_OK, backPressedIntent);
        finish();

    }
}
