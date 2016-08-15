package co.ga.toasts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;

public class ToastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        Button buySomething = (Button) findViewById(R.id.buyButton);
        View.OnClickListener myOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(ToastActivity.this, "Here is a toast.", Toast.LENGTH_LONG).show();
            }

        };

        buySomething.setOnClickListener(myOnClickListener);

        Button saveButton = (Button) findViewById(R.id.saveButton);
        View.OnClickListener myOnClickListener2 = new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(ToastActivity.this, "Save button.", Toast.LENGTH_LONG).show();
            }
        };

        saveButton.setOnClickListener(myOnClickListener2);

    }

}