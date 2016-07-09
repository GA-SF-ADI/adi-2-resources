package gg.patrickcummins.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class JerseyActivity extends AppCompatActivity {
    TextView jerseyColor1, jerseyColor2, jerseyColor3;
    ImageView jerseyImageView;
    //TODO: Alot of shit, connect to db

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jersey);

        setViews();
        setOnClickListeners();
    }

    private void setOnClickListeners() {
        setColorOnClick(jerseyColor1, R.drawable.klay_thompson_blue );
        setColorOnClick(jerseyColor2, R.drawable.klay_thompson_white );
        setColorOnClick(jerseyColor3, R.drawable.klay_thompson_slate );
    }

    private void setColorOnClick(TextView textView, final int jerseyDrawable) {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jerseyImageView.setImageResource(jerseyDrawable);
            }
        });
    }

    private void setViews() {
        jerseyColor1 = (TextView) findViewById(R.id.jersey1);
        jerseyColor2 = (TextView) findViewById(R.id.jersey2);
        jerseyColor3 = (TextView) findViewById(R.id.jersey3);
        jerseyImageView = (ImageView) findViewById(R.id.jerseyImageView);
    }
}
