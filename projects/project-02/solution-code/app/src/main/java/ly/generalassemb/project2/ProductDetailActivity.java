package ly.generalassemb.project2;

import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.text.NumberFormat;

import ly.generalassemb.project2.database.MyDatabase;
import ly.generalassemb.project2.database.contracts.ProductsDatabaseContract;
import ly.generalassemb.project2.database.contracts.PurchasedDatabaseContract;

public class ProductDetailActivity extends AppCompatActivity {

    private ImageView mImageView;
    private TextView mNameTextView;
    private TextView mDescriptionTextView;
    private Button mBuyButton;

    private long mProductId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        mImageView = (ImageView) findViewById(R.id.product_detail_imageView);
        mNameTextView = (TextView) findViewById(R.id.product_detail_name);
        mDescriptionTextView = (TextView) findViewById(R.id.product_detail_description);
        mBuyButton = (Button) findViewById(R.id.buyButton);

        Intent callingIntent = getIntent();
        mProductId = callingIntent.getLongExtra(ProductsDatabaseContract._ID, -1);

        if (mProductId < 0){
            Toast.makeText(ProductDetailActivity.this, "Something went wrong! :(", Toast.LENGTH_SHORT).show();
            finish();
        }

        MyDatabase database = new MyDatabase(this);
        Cursor cursor = database.getProductById(mProductId);

        Picasso.with(this).load(getStringFromCursor(cursor, ProductsDatabaseContract.COLUMN_NAME_PICTURE_URL))
                .into(mImageView);

        mNameTextView.setText(getStringFromCursor(cursor, ProductsDatabaseContract.COLUMN_NAME_PRODUCT_NAME));
        mDescriptionTextView.setText(getStringFromCursor(cursor, ProductsDatabaseContract.COLUMN_NAME_DESCRIPTION));

        NumberFormat format = NumberFormat.getCurrencyInstance();
        mBuyButton.setText(format.format(cursor.getInt(cursor.getColumnIndex(ProductsDatabaseContract.COLUMN_NAME_PRICE))));

        mBuyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(findViewById(R.id.product_detail_imageView), "Added to cart!", Snackbar.LENGTH_LONG)
                        .setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ShoppingCart.getInstance().addProduct(mProductId);
                            }
                        })
                        .setActionTextColor(getResources().getColor(R.color.colorAccent))
                        .show();
            }
        });
    }

    private String getStringFromCursor(Cursor cursor, String columnName) {
        return cursor.getString(cursor.getColumnIndex(columnName));
    }
}
