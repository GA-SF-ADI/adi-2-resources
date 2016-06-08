package ly.generalassemb.drewmahrt.iconlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        int id = getIntent().getIntExtra("id",-1);

        if(id >= 0){
            String iconName = IconSQLiteOpenHelper.getInstance(DetailActivity.this).getIconNameById(id);
            TextView textView = (TextView)findViewById(R.id.icon_description);
            textView.setText(iconName);
        }
    }
}
