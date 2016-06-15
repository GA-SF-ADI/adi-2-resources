package co.ga.toasts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ToastActivity extends AppCompatActivity {

    Button button = (Button) findViewById(R.id.buyButton);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        View.OnClickListener buyOnClickListener = new View.OnClickListener(){

            public void onClick(View v){

             Toast.makeText(ToastActivity.this, "Toast.", Toast.LENGTH_LONG)
                     .show();
            }



        };
    }
}
