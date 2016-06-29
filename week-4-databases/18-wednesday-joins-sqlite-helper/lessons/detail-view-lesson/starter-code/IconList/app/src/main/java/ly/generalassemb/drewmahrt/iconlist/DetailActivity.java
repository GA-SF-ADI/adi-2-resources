package ly.generalassemb.drewmahrt.iconlist;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.os.Bundle;

/**
 * Created by NehaRege on 6/29/16.
 */
public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

//        setContentView(android.R.layout.simple_list_item_1);

        IconSQLiteOpenHelper helper = IconSQLiteOpenHelper.getInstance(this);

        int id = getIntent().getIntExtra("id",-1);

        if (id >= 0){
            String description = helper.getDescriptionById(id);
            TextView textView = (TextView) findViewById(R.id.text_view);
            textView.setText(description);
        }

    }


}



