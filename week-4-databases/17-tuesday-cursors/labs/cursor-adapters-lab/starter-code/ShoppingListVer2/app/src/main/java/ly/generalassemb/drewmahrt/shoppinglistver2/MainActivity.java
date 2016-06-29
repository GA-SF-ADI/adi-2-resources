package ly.generalassemb.drewmahrt.shoppinglistver2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    private ListView listview;

    DataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set up listview from XML
        listview = (ListView) findViewById(R.id.shopping_list_view);

        CursorAdapter cursorAdapter = new CursorAdapter(MainActivity.this, db.getAllGroceries(), 0) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                return LayoutInflater.from(context).inflate(R.layout.customadapter, parent, false);
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                TextView name = (TextView) view.findViewById(R.id.text_view_name);
                TextView description = (TextView) view.findViewById(R.id.text_view_description);
                TextView price = (TextView) view.findViewById(R.id.text_view_price);
                TextView type = (TextView) view.findViewById(R.id.text_view_type);
                name.setText(cursor.getColumnIndex(DataBaseHelper.ITEM_NAME));
               description.setText(cursor.getColumnIndex(DataBaseHelper.DESCRIPTION));
                price.setText(cursor.getColumnIndex(DataBaseHelper.PRICE));
                type.setText(cursor.getColumnIndex(DataBaseHelper.TYPE));

            }
        };

        //setAdapter
        listview.setAdapter(cursorAdapter);

        //instance

        db = new DataBaseHelper(this);
        db.getReadableDatabase();


        //things for the table
        db.insert(1, "coffee", "wake up", "$2.00", "beverage");
        db.insert(2, "cereal", "breakfast", "$5.00", "food");
        db.insert(3, "ice cream", "dessert", "$5.50", "food");



         db = new DataBaseHelper(this);
        //create cursor
        Cursor cursor = db.getAllGroceries();


        //String [] columns = {DataBaseHelper.ITEM_NAME, DataBaseHelper.DESCRIPTION, DataBaseHelper.PRICE, DataBaseHelper.TYPE};


        //need an array of ints and look at XML file for the id that android already gave us

        //command click on simple_list_item_1 to find the id that you need

       // int[] ids= {R.id.text_view_name, R.id.text_view_description, R.id.text_view_price, R.id.text_view_type};

        //setAdapter
        listview.setAdapter(cursorAdapter);
    }
}
