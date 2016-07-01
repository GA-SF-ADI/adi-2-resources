package ly.generalassemb.project2;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.zip.Inflater;

import ly.generalassemb.project2.database.contracts.ProductsDatabaseContract;

/**
 * James Davis (General Assembly NYC)
 * Created on 4/20/16.
 */
public class ProductCursorAdapter extends CursorAdapter {


    public ProductCursorAdapter(Context context, Cursor c) {
        super(context, c, true);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);

        return inflater.inflate(R.layout.product_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView titleTextView = (TextView) view.findViewById(R.id.product_item_title_textview);
        TextView priceTextView = (TextView) view.findViewById(R.id.product_item_price_textview);
        ImageView imageView = (ImageView) view.findViewById(R.id.product_item_imageView);

        titleTextView.setText(cursor.getString(cursor.getColumnIndex(ProductsDatabaseContract.COLUMN_NAME_PRODUCT_NAME)));
        priceTextView.setText(getformattedPrice(cursor));

        Picasso.with(context)
                    .load(cursor.getString(cursor.getColumnIndex(ProductsDatabaseContract.COLUMN_NAME_PICTURE_URL)))
                    .into(imageView);

        view.setTag(cursor.getLong(cursor.getColumnIndex(ProductsDatabaseContract._ID)));
    }

    private String getformattedPrice(Cursor cursor) {
        NumberFormat format = NumberFormat.getCurrencyInstance();
        float price = cursor.getFloat(cursor.getColumnIndex(ProductsDatabaseContract.COLUMN_NAME_PRICE));
        return format.format(price);
    }
}
