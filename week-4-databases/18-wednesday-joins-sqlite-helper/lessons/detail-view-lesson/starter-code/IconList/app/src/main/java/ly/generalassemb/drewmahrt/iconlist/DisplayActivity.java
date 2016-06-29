package ly.generalassemb.drewmahrt.iconlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        IconSQLiteOpenHelper helper = IconSQLiteOpenHelper.getInstance(DisplayActivity.this);

        int id = getIntent().getIntExtra("id",-1);

        if(id >= 0){
            String description = helper.getNameById(id);
            TextView textView = (TextView)findViewById(R.id.icon_name_text_view);
            textView.setText(description);
        }
    }
}
