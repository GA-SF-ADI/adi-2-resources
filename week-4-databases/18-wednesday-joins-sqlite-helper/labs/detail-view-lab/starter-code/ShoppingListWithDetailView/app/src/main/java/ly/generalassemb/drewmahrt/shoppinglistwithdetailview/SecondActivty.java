package ly.generalassemb.drewmahrt.shoppinglistwithdetailview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activty);

        ShoppingSQLiteOpenHelper helper = ShoppingSQLiteOpenHelper.getInstance(SecondActivty.this);

        int id = getIntent().getIntExtra("id",-1);

        if(id >= 0){
            String name = helper.getDescriptionById(id);
            TextView textView = (TextView)findViewById(R.id.text_view_of_descriptions);
            textView.setText(name);

            String name2 = helper.getDescriptionById2(id);
            TextView textView2 = (TextView)findViewById(R.id.text_view_2);
            textView.setText(name2);


        }
    }
}
