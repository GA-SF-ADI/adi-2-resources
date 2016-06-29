package ly.generalassemb.drewmahrt.shoppinglistwithdetailview.setup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import ly.generalassemb.drewmahrt.shoppinglistwithdetailview.R;
import ly.generalassemb.drewmahrt.shoppinglistwithdetailview.ShoppingSQLiteOpenHelper;

public class SecondActivity extends AppCompatActivity {
    private ShoppingSQLiteOpenHelper mHelper;
    TextView textView1, textView2, textView3, textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        int id = getIntent().getIntExtra("id",-1);

        mHelper = new ShoppingSQLiteOpenHelper(SecondActivity.this);

        getViews();


        if(id>=0){
            String name = mHelper.getColItemName(id);
            String price = mHelper.getColItemPrice(id);
            String description = mHelper.getColItemDescription(id);
            String type = mHelper.getColItemType(id);

            textView1.setText(name);
            textView2.setText(price);
            textView3.setText(description);
            textView4.setText(type);
        }
    }

    protected void getViews(){
        textView1=(TextView)findViewById(R.id.gtext1);
        textView2=(TextView)findViewById(R.id.gtext2);
        textView3=(TextView)findViewById(R.id.gtext3);
        textView4=(TextView)findViewById(R.id.gtext4);

    }
}
