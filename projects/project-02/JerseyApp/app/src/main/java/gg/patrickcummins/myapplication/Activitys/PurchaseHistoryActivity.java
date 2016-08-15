package gg.patrickcummins.myapplication.Activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import gg.patrickcummins.myapplication.DatabaseHelper;
import gg.patrickcummins.myapplication.Adapters.PurchaseHistoryListAdapter;
import gg.patrickcummins.myapplication.R;
import gg.patrickcummins.myapplication.models.PurchaseHistoryItem;

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


            for (int i = 0; i <= helper.getLastHistoryID(); i++) {
                String currentDate = helper.getDateFromHistoryID(i);
                double currentPrice = helper.getPriceFromHistoryID(i);
                purchaseHistoryArrayList.add(new PurchaseHistoryItem(i, currentPrice, currentDate));
            }

            PurchaseHistoryListAdapter purchaseHistoryAdapter = new PurchaseHistoryListAdapter(purchaseHistoryArrayList, this);

            purchaseHistoryListView.setAdapter(purchaseHistoryAdapter);
        }


    }
}
