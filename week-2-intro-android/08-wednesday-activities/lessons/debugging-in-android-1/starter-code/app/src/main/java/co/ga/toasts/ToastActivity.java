package co.ga.toasts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ToastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        final Button buyButton1 = (Button) findViewById(R.id.buyButton);
        Button saveButton1 = (Button) findViewById(R.id.saveButton);
        Button sendButton1 = (Button) findViewById(R.id.sendButton);
        Button likeButton1 = (Button) findViewById(R.id.likeButton);

        View.OnClickListener myOnClickListener1 = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                buyButton1.makeText(ToastActivity.this, "Bought Something", Toast.LENGTH_SHORT);
                buyButton1.show();



            }
        };



    }
}
