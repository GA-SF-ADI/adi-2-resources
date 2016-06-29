package ly.generalassemb.drewmahrt.iconlist.setup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import ly.generalassemb.drewmahrt.iconlist.IconSQLiteOpenHelper;
import ly.generalassemb.drewmahrt.iconlist.R;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        IconSQLiteOpenHelper helper = IconSQLiteOpenHelper.getInstance(SecondActivity.this);

        int id = getIntent().getIntExtra("id",-1);

        if(id>=0){
            String name = helper.getIconName(id);
            TextView textView = (TextView)findViewById(R.id.text_view);
            textView.setText(name);
        }

    }
}
