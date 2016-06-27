package ly.generalassemb.project2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.zip.Inflater;

import ly.generalassemb.project2.database.MyDatabase;
import ly.generalassemb.project2.database.contracts.ProductsDatabaseContract;

public class ProductListActivity extends AppCompatActivity {

    MyDatabase mDatabase;

    ListView mListView;
    ProductCursorAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_list);

        mDatabase = new MyDatabase(this);
        mListView = (ListView) findViewById(R.id.product_list_listView);

        mAdapter = new ProductCursorAdapter(this, mDatabase.getAllProducts());

        mListView.setAdapter(mAdapter);

        View headerView = getLayoutInflater().inflate(R.layout.product_list_header, mListView, false);
        mListView.addHeaderView(headerView);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    long _id = ((long) view.getTag());
                    Intent intent = new Intent(ProductListActivity.this, ProductDetailActivity.class);
                    intent.putExtra(ProductsDatabaseContract._ID, _id);
                    startActivity(intent);
                } catch (Throwable thr){
                    thr.printStackTrace();
                }
            }
        });
    }
}
