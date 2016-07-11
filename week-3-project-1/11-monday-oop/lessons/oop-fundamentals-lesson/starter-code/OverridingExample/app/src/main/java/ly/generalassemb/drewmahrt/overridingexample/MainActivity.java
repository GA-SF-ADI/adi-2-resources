package ly.generalassemb.drewmahrt.overridingexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CharSequence text = "Toast Test";

        Toast toast = MyCustomToast.makeText(MainActivity.this,text, Toast.LENGTH_SHORT);
        toast.show();
    }
}


