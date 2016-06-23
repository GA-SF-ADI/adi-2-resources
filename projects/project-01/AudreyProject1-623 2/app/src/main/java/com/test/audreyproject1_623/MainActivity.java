package com.test.audreyproject1_623;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 100;

    CustomBaseAdapter customBaseAdapter;
    EditText myEditText;
    ArrayList<Category> mCategoryList;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (mCategoryList == null) {
            mCategoryList = new ArrayList<>();
        }

        final ListView listView = (ListView) findViewById(R.id.list_view);
        customBaseAdapter = new CustomBaseAdapter(mCategoryList, this);
        listView.setAdapter(customBaseAdapter);

        myEditText = (EditText) findViewById(R.id.edit_text);

        final Button newList = (Button) findViewById(R.id.new_list);
        newList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String myInputString = myEditText.getText().toString();
                Category myCategory = new Category(myInputString);
                mCategoryList.add(myCategory);
                Log.d("MainActivity", mCategoryList.toString());
                customBaseAdapter.notifyDataSetChanged();

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, ItemActivity.class);
                Category myCategory = mCategoryList.get(position);
                intent.putExtra("position", position);
                intent.putExtra("category", myCategory);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                mCategoryList.remove(position);
                customBaseAdapter.notifyDataSetChanged();
                return false;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE) {
            if(resultCode == RESULT_OK) {


                Category createList = (Category) data.getSerializableExtra("category");
                // pull out position

                int pos = data.getIntExtra("position", 0);
                //int position = ; (int position = onItemClickListener of mCategoryList)..
                //Intent intent
                Toast.makeText(MainActivity.this,"position: " + pos, Toast.LENGTH_SHORT ).show();

                //mCategoryList.get(position);
                mCategoryList.set(pos, createList);
                customBaseAdapter.notifyDataSetChanged();
            }

        }


    }
}

