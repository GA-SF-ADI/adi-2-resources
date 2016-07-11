package co.ga.toasts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ToastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        Button button1=(Button) findViewById(R.id.buyButton);
        final View.OnClickListener b1OnClickListener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(ToastActivity.this, "Something bought!",Toast.LENGTH_SHORT).show();
            }
        };
        button1.setOnClickListener(b1OnClickListener);

        Button button2=(Button) findViewById(R.id.saveButton);
        final View.OnClickListener b2OnClickListener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(ToastActivity.this, "saved",Toast.LENGTH_SHORT).show();
            }
        };
        button2.setOnClickListener(b2OnClickListener);

        Button button3=(Button) findViewById(R.id.sendButton);
        final View.OnClickListener b3OnClickListener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(ToastActivity.this, "sent",Toast.LENGTH_SHORT).show();
            }
        };
        button3.setOnClickListener(b3OnClickListener);

        Button button4=(Button) findViewById(R.id.likeButton);
        final View.OnClickListener b4OnClickListener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(ToastActivity.this, "liked",Toast.LENGTH_SHORT).show();
            }
        };
        button4.setOnClickListener(b4OnClickListener);

    }
}
