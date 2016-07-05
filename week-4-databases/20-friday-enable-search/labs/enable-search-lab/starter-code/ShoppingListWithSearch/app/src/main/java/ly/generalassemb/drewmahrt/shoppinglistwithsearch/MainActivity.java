package ly.generalassemb.drewmahrt.shoppinglistwithsearch;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import ly.generalassemb.drewmahrt.shoppinglistwithsearch.setup.DBAssetHelper;

public class MainActivity extends AppCompatActivity {
    private ListView mShoppingListView;
    private CursorAdapter mCursorAdapter;
    private ShoppingSQLiteOpenHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ignore the two lines below, they are for setup
        DBAssetHelper dbSetup = new DBAssetHelper(MainActivity.this);
        dbSetup.getReadableDatabase();

        mShoppingListView = (ListView)findViewById(R.id.shopping_list_view);

        helper = new ShoppingSQLiteOpenHelper(MainActivity.this);
        Cursor cursor = helper.getShoppingList();

        mCursorAdapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_1,cursor,new String[]{ShoppingSQLiteOpenHelper.COL_ITEM_NAME},new int[]{android.R.id.text1},0);
        mShoppingListView.setAdapter(mCursorAdapter);

        handleIntent(getIntent());
    }


    @Override public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        // Find searchManager and searchableInfo
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchableInfo searchableInfo = searchManager.getSearchableInfo(getComponentName());

        // Associate searchable info with the SearchView
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchableInfo);

        return true;
    }
    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            Cursor cursor = helper.shoppingList(query);
            mCursorAdapter.changeCursor(cursor);
            mCursorAdapter.notifyDataSetChanged();

            Toast.makeText(MainActivity.this, query,Toast.LENGTH_SHORT).show();
        }
    }
}
