package ly.generalassemb.drewmahrt.shoppinglistver2;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import ly.generalassemb.drewmahrt.shoppinglistver2.setup.DBAssetHelper;
import ly.generalassemb.drewmahrt.shoppinglistver2.setup.GrocerySQLiteOpenHelper;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ignore the two lines below, they are for setup
        DBAssetHelper dbSetup = new DBAssetHelper(MainActivity.this);
        dbSetup.getReadableDatabase();

        GrocerySQLiteOpenHelper db = GrocerySQLiteOpenHelper.getInstance(this);

        ListView listView = (ListView) findViewById(R.id.shopping_list_view);

        Cursor cursor = db.getGroceryList();

        CursorAdapter cursorAdapter = new CursorAdapter(MainActivity.this, cursor, 0) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                TextView name = (TextView) view.findViewById(R.id.list_item_name);
                TextView description = (TextView) view.findViewById(R.id.list_item_description);
                TextView price = (TextView) view.findViewById(R.id.list_item_price);
                TextView type = (TextView) view.findViewById(R.id.list_item_type);

                name.setText(cursor.getString(cursor.getColumnIndex(GrocerySQLiteOpenHelper.COL_NAME)));
                description.setText(cursor.getString(cursor.getColumnIndex(GrocerySQLiteOpenHelper.COL_DESCRIPTION)));
                price.setText("$ " + String.valueOf(cursor.getInt(cursor.getColumnIndex(GrocerySQLiteOpenHelper.COL_PRICE))));
                type.setText(cursor.getString(cursor.getColumnIndex(GrocerySQLiteOpenHelper.COL_TYPE)));

            }
        };

        listView.setAdapter(cursorAdapter);
    }
}
