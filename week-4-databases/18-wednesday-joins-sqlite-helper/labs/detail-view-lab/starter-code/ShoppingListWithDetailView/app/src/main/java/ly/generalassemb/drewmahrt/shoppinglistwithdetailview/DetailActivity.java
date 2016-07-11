package ly.generalassemb.drewmahrt.shoppinglistwithdetailview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by NehaRege on 6/29/16.
 */
public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        int id = getIntent().getIntExtra("id",-1);

        if(id >= 0){
            String itemName = ShoppingSQLiteOpenHelper.getInstance(DetailActivity.this).getItemNameById(id);
            String itemDescription = ShoppingSQLiteOpenHelper.getInstance(DetailActivity.this).getItemDescriptionById(id);
            String itemPrice = ShoppingSQLiteOpenHelper.getInstance(DetailActivity.this).getItemPriceById(id);
            String itemType = ShoppingSQLiteOpenHelper.getInstance(DetailActivity.this).getItemTypeById(id);

            TextView textViewName = (TextView) findViewById(R.id.text_view_name);
            textViewName.setText(itemName);

            TextView textViewDescription = (TextView) findViewById(R.id.text_view_description);
            textViewDescription.setText(itemDescription);

            TextView textViewPrice = (TextView) findViewById(R.id.text_view_price);
            textViewPrice.setText(itemPrice);

            TextView textViewType = (TextView) findViewById(R.id.text_view_type);
            textViewType.setText(itemType);

        }


    }
}
