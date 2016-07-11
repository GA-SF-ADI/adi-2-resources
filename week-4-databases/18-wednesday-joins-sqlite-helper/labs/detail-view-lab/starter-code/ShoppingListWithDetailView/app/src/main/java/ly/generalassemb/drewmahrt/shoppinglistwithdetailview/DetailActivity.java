package ly.generalassemb.drewmahrt.shoppinglistwithdetailview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private TextView name, description, price, type;
    ShoppingSQLiteOpenHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setUpViews();

        helper = ShoppingSQLiteOpenHelper.getInstance(DetailActivity.this);

        setViewText();


    }

    private void setViewText() {
        int id = getIntent().getIntExtra("id", -1);

        if (id>=0){
            name.setText(helper.getNameByID(id));
            description.setText(helper.getDescriptionByID(id));
            price.setText(helper.getPriceByID(id));
            type.setText(helper.getTypeByID(id));
        }

    }

    private void setUpViews() {
        name = (TextView) findViewById(R.id.nameTextView);
        description = (TextView) findViewById(R.id.DescriptionTextView);
        price = (TextView) findViewById(R.id.PriceTextView);
        type = (TextView) findViewById(R.id.typeTextView);
    }
}
