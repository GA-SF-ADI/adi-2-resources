package ly.generalassemb.drewmahrt.shoppinglistwithdetailview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activty);

        TextView textView = (TextView)findViewById(R.id.text_view_of_descriptions);
        TextView textView2 = (TextView)findViewById(R.id.text_view_2);
        TextView textViewPrice = (TextView) findViewById(R.id.text_view_price);
        TextView textViewType = (TextView) findViewById(R.id.text_view_type);

        ShoppingSQLiteOpenHelper helper = ShoppingSQLiteOpenHelper.getInstance(SecondActivty.this);

        int id = getIntent().getIntExtra("id",-1);

        if(id >= 0){
            String name = helper.getDescriptionById(id);
            textView.setText(name + ":" + " \n");

            String name2 = helper.getDescriptionById2(id);
            textView2.setText(" \n"+ name2 + "," + " \n");

            String price = helper.getPrice(id);
            textViewPrice.setText(" \n" + price + "," + " \n");

            String type = helper.getType(id);
            textViewType.setText(" \n" + type + "." + " \n");
        }
    }
}
