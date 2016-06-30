package ly.generalassemb.drewmahrt.iconlist;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class secondactivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_secondactivity);


        IconSQLiteOpenHelper helper = IconSQLiteOpenHelper.getInstance(secondactivity.this);

        int id = getIntent().getIntExtra("id",-1);

        if(id >= 0){
            String name = IconSQLiteOpenHelper.getInstance(secondactivity.this).getDescriptionById(id);
            TextView textView = (TextView)findViewById(R.id.second_icon_name_text_view);
            textView.setText(name);
        }
    }

}