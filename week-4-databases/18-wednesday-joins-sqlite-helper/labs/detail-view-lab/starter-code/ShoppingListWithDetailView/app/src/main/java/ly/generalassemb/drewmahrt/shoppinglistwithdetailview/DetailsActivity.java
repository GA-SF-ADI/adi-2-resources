package ly.generalassemb.drewmahrt.shoppinglistwithdetailview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ShoppingSQLiteOpenHelper helper = ShoppingSQLiteOpenHelper.getInstance(DetailsActivity.this);
        int id = getIntent().getIntExtra("id",-1);

        if(id >= 0){
            String description = helper.getNameById(id);
            String price = helper.getPriceById(id);
            String type = helper.getTypeById(id);
            TextView textView = (TextView)findViewById(R.id.description_tv);
            TextView textView1 = (TextView)findViewById(R.id.price_tv);
            TextView textView2 = (TextView)findViewById(R.id.type_tv);
            textView.setText(description);
            textView1.setText(price);
            textView2.setText(type);
        }
    }
}
