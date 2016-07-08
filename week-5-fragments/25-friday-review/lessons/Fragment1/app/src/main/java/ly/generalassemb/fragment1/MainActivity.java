package ly.generalassemb.fragment1;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.main_button);
        editText = (EditText) findViewById(R.id.main_edit_text);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                passDataToFragment(text);

                editText.setText("");
            }
        });
    }

    private void passDataToFragment(String text){
        // get manager to find our STATIC fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        DetailFragment detailFragment = (DetailFragment) fragmentManager.findFragmentById(R.id.fragment_container);

        detailFragment.setText(text);

    }
}
