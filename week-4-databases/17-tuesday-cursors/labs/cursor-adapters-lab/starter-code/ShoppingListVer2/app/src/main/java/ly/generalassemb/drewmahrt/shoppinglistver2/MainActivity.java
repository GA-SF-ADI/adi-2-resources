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

        DatabaseHelper db = new DatabaseHelper(MainActivity.this);

        Cursor cursor = db.getList();

        ListView shoppingListView = (ListView) findViewById(R.id.shopping_list_view);

        CursorAdapter myCursorAdapter = new CursorAdapter(MainActivity.this, cursor, 0) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                return LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                TextView nameTextView =(TextView) view.findViewById(R.id.nameText);
                TextView priceTextView = (TextView) view.findViewById(R.id.priceText);
                TextView descripTextView = (TextView) view.findViewById(R.id.descriptionText);
                TextView typeTextView = (TextView) view.findViewById(R.id.typeText);

                nameTextView.setText("Name: " + cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_NAME)));
                priceTextView.setText("Price: $" +cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_PRICE)));
                descripTextView.setText("Description: " +cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_DESCRIPTION)));
                typeTextView.setText("Type: " + cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_TYPE)));
            }
        };
        shoppingListView.setAdapter(myCursorAdapter);

    }
}
