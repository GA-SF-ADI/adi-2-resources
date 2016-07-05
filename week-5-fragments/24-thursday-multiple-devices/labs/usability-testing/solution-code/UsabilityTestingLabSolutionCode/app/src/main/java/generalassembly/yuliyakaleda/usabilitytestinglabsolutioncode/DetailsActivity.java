package generalassembly.yuliyakaleda.usabilitytestinglabsolutioncode;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailsActivity extends AppCompatActivity {

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.details_activity_layout);

    Bundle extras = getIntent().getExtras();
    String sign = " ";

    if (extras != null) {
      sign = extras.getString("sign");
      Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.
          parse("http://www.horoscopedates.com/zodiac-signs/" + sign + "/"));
      startActivity(browserIntent);   
    }
  }
}
