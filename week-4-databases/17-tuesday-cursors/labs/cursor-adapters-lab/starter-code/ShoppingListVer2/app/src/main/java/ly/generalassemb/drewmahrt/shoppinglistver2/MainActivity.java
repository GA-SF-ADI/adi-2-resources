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

import java.util.List;

import ly.generalassemb.drewmahrt.shoppinglistver2.setup.DBAssetHelper;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ignore the two lines below, they are for setup
        DBAssetHelper dbSetup = new DBAssetHelper(MainActivity.this);
        dbSetup.getReadableDatabase();


        ListView listView = (ListView) findViewById(R.id.shopping_list_view);

        ShoppingSQLOpenHelper db = new ShoppingSQLOpenHelper(this);

        Cursor cursor = db.getShoppingList();

        CursorAdapter mCursorAdapter = new CursorAdapter(MainActivity.this, cursor, 0) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {

                return LayoutInflater.from(context).inflate(R.layout.single_shopping_list_item_custom_layout, parent, false);


            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {

                TextView itemTextView = (TextView) view.findViewById(R.id.textView_single_item);
                itemTextView.setText(cursor.getString(cursor.getColumnIndex(ShoppingSQLOpenHelper.COL_ITEM_NAME)));


                TextView priceTextView = (TextView) view.findViewById(R.id.textView_price_of_item);
                priceTextView.setText(cursor.getString(cursor.getColumnIndex(ShoppingSQLOpenHelper.PRICE)));

            }
        };

        listView.setAdapter(mCursorAdapter);


    }
}
