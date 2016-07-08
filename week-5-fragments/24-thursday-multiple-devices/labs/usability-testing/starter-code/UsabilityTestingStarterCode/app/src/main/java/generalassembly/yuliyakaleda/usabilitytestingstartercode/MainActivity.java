package generalassembly.yuliyakaleda.usabilitytestingstartercode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //TODO: Create a separate layout xml file for tablet devices.

        View view = findViewById(R.id.web_view);
          if (view == null){
            //this is a phone
              view
          }
          else {
            //this is a tablet
          }
  }
}
