package ly.generalassemb.espresso;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * James Davis (General Assembly NYC)
 * Created on 4/25/16.
 */
public class TransactionAdapter extends BaseAdapter {
    private List<Transaction> mTransactions;

    public TransactionAdapter() {
        this.mTransactions = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return mTransactions.size();
    }

    @Override
    public Transaction getItem(int position) {
        return mTransactions.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Transaction transaction = getItem(position);

        if (view == null){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.balance_listview_item, parent, false);
        }

        TextView amountTextView = (TextView) view.findViewById(R.id.balance_item_amount);
        TextView descriptiontextView = (TextView) view.findViewById(R.id.balance_item_description);

        amountTextView.setText(transaction.getFormattedAmount());
        descriptiontextView.setText(transaction.getDescription());

        if (transaction.getAmount() > 0){
            amountTextView.setTextColor(parent.getResources().getColor(R.color.accent_material_light));
        } else {
            amountTextView.setTextColor(parent.getResources().getColor(android.R.color.holo_red_dark));
        }

        return view;
    }

    public void setTransactions(List<Transaction> transactions) {
        mTransactions.clear();
        this.mTransactions.addAll(transactions);

        notifyDataSetChanged();
    }
}
