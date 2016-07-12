package gg.patrickcummins.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class PurchaseHistoryActivity extends AppCompatActivity {
    DatabaseHelper helper;
    ArrayList<PurchaseHistoryItem> purchaseHistoryArrayList;
    ListView purchaseHistoryListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_history);

        helper = DatabaseHelper.getInstance(PurchaseHistoryActivity.this);
        purchaseHistoryArrayList = new ArrayList<>();
        purchaseHistoryListView = (ListView) findViewById(R.id.purchaseHistoryList);

        if (!helper.isPurchaseHistoryEmpty()) {


            for (int i = 0; i < helper.getLastHistoryID(); i++) {
                String currentDate = helper.getDateFromHistoryID(i);
                double currentPrice = helper.getPriceFromHistoryID(i);
                purchaseHistoryArrayList.add(new PurchaseHistoryItem(i, currentPrice, currentDate));
            }

            ArrayAdapter<PurchaseHistoryItem> purchaseHistoryAdapter = new ArrayAdapter<PurchaseHistoryItem>(this, android.R.layout.simple_list_item_1, purchaseHistoryArrayList);

            purchaseHistoryListView.setAdapter(purchaseHistoryAdapter);
        }


    }
}
