package com.differentdevices.fishtankv9;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.List;

public class FishCategories extends ListActivity {
    //private SQLiteDatabase db;
    private Cursor cursor;


    public static final String EXTRA_CATEGORYNO = "categoryNo";
    int categoryNo;

    private List<ProductSingleton> productlist;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        categoryNo = getIntent().getIntExtra(EXTRA_CATEGORYNO, 0); //goes to fish in case something goes wrong

        productlist = Dbase.getInstance(this).getProduct();


        super.onCreate(savedInstanceState);
        ListView listFish = getListView();

        try { //query was originally here, moved to db and named fishquery()
            Dbase databaseHelper = new Dbase(FishCategories.this);

            if (categoryNo == 0) {
//                Cursor cursor;
                cursor = databaseHelper.fishQuery();
                Log.d("empty screens", cursor.getCount() + "");

                CursorAdapter listAdapter = new SimpleCursorAdapter(this,
                        android.R.layout.simple_list_item_1,
                        cursor,
                        new String[]{"NAME"},
                        new int[]{android.R.id.text1},
                        0);
                listFish.setAdapter(listAdapter);

            }

            if (categoryNo == 1) {


                cursor = databaseHelper.coralQuery();

                CursorAdapter listAdapter = new SimpleCursorAdapter(this,
                        android.R.layout.simple_list_item_1,
                        cursor,
                        new String[]{"NAME"},
                        new int[]{android.R.id.text1},
                        0);
                listFish.setAdapter(listAdapter);

            }

            if (categoryNo == 2) {


                cursor = databaseHelper.supplyQuery();

                CursorAdapter listAdapter = new SimpleCursorAdapter(this,
                        android.R.layout.simple_list_item_1,
                        cursor,
                        new String[]{"NAME"},
                        new int[]{android.R.id.text1},
                        0);
                listFish.setAdapter(listAdapter);

            }

        } catch (SQLiteException e) {
            e.printStackTrace();  //wont crash program instead print out errors in logcat.  added tuesday
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }


    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void onListItemClick(ListView listView,
                                View itemView,
                                int position,
                                long id) {


        Intent intent = new Intent(FishCategories.this, DetailsActivity.class);
        intent.putExtra(DetailsActivity.ITEM_ID, (int)id);
        startActivity(intent);


    }
}
