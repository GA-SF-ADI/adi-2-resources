package ly.generalassemb.drewmahrt.iconlist;

import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by michaeljeffress on 6/29/16.
 */
public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        IconSQLiteOpenHelper helper = IconSQLiteOpenHelper.getInstance(DetailActivity.this);

        int id = getIntent().getIntExtra("id", -1);

        if (id >= 0) {
            String iconName = helper.getDescriptionById(id);
            TextView textView = (TextView) findViewById(R.id.icon_description);
            textView.setText(iconName);

        }
    }
}
