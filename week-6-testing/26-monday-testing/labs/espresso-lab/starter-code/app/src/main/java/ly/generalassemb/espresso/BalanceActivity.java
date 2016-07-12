package ly.generalassemb.espresso;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class BalanceActivity extends AppCompatActivity {

    TextView mBalanceTextView;
    ListView mTransactionsListView;
    RelativeLayout mBalanceContainer;
    FloatingActionButton mNewTransactionButton;

    List<Transaction> mTransactions;
    TransactionAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance);

        mBalanceContainer = (RelativeLayout) findViewById(R.id.balanceRelativeLayout);
        mTransactionsListView = (ListView) findViewById(R.id.transactionsListView);
        mBalanceTextView = (TextView) findViewById(R.id.balanceTextView);
        mNewTransactionButton = (FloatingActionButton) findViewById(R.id.newTransactionButton);

        mTransactions = new ArrayList<>();

        mTransactionsListView.setEmptyView(findViewById(R.id.emptyView));

        mAdapter = new TransactionAdapter();
        mAdapter.setTransactions(mTransactions);
        mTransactionsListView.setAdapter(mAdapter);

        updateBalance();

        mNewTransactionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BalanceActivity.this, NewTransactionActivity.class);
                startActivityForResult(intent, 0);
            }
        });
    }

    private void updateBalance(){
        NumberFormat format = NumberFormat.getCurrencyInstance();
        float total = 0;

        for (Transaction transaction : mTransactions) {
            total += transaction.getAmount();
        }

        mBalanceTextView.setText(format.format(total));
    }

    private void addTransaction(Transaction transaction){
        if (transaction != null) {
            mTransactions.add(transaction);
            mAdapter.setTransactions(mTransactions);
            updateBalance();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK){
            Transaction transaction = (Transaction) data.getSerializableExtra(Transaction.class.getName());
            addTransaction(transaction);
        }
    }
}
