package ly.generalassemb.drewmahrt.searchviewdemo;

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
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import ly.generalassemb.drewmahrt.searchviewdemo.setup.DBAssetHelper;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ignore the two lines below
        DBAssetHelper dbAssetHelper = new DBAssetHelper(MainActivity.this);
        dbAssetHelper.getReadableDatabase();
        textView=(TextView)findViewById(R.id.count_text_view);
        handleIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchableInfo searchableInfo = searchManager.getSearchableInfo(getComponentName());

        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchableInfo);

        return true;
    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            Toast.makeText(MainActivity.this,"Searching for: " + query, Toast.LENGTH_LONG).show();

            Cursor cursor = NumbersSQLiteHelper.getInstance(this).searchNumbers(query);

            textView.setText("we saw "+query+ ", "+ cursor.getCount()+"amount of times." );

        }
    }
}
