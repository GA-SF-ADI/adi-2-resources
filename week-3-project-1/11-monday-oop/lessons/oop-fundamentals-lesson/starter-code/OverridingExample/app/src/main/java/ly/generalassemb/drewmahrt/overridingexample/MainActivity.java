package ly.generalassemb.drewmahrt.overridingexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyCustomToast.makeText(MainActivity.this,"Hello World", Toast.LENGTH_SHORT).show();


    }
}
