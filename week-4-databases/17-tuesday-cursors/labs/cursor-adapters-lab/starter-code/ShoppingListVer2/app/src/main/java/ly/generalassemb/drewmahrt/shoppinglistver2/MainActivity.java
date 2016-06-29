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

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ignore the two lines below, they are for setup
        DBAssetHelper dbSetup = new DBAssetHelper(MainActivity.this);
        dbSetup.getReadableDatabase();
        // getting an instance of ShoppingSQLiteHelper
        ShoppingSQLiteOpenHelper db = ShoppingSQLiteOpenHelper.getInstance(this);
        //creating a cursor to retrieve data
        Cursor cursor = db.getShoppingList();
        ListView shoppingListView = (ListView) findViewById(R.id.shopping_list_view);
        CursorAdapter cursorAdapter = new CursorAdapter(MainActivity.this, cursor, 0) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                TextView nameText = (TextView) view.findViewById(R.id.name_tv);
                TextView descriptionText = (TextView) view.findViewById(R.id.description_tv);
                TextView priceText = (TextView) view.findViewById(R.id.price_tv);
                TextView typeText = (TextView) view.findViewById(R.id.type_tv);

                nameText.setText(cursor.getString(cursor.getColumnIndex(ShoppingSQLiteOpenHelper.COL_NAME)));
                descriptionText.setText(cursor.getString(cursor.getColumnIndex(ShoppingSQLiteOpenHelper.COL_DESCRIPTION)));
                priceText.setText(cursor.getString(cursor.getColumnIndex(ShoppingSQLiteOpenHelper.COL_PRICE)));
                typeText.setText(cursor.getString(cursor.getColumnIndex(ShoppingSQLiteOpenHelper.COL_TYPE)));
                //set text for all columns to textviews

            }
        };
        shoppingListView.setAdapter(cursorAdapter); //attached adapter to listview


    }
}
