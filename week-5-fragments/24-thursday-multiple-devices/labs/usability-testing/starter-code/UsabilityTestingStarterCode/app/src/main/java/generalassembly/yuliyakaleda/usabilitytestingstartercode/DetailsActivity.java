package generalassembly.yuliyakaleda.usabilitytestingstartercode;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class DetailsActivity extends AppCompatActivity {
  private static final String SIGN = "sign";
  
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.details_activity_layout);

    Bundle extras = getIntent().getExtras();
    String sign = " ";

    if (extras != null) {
      sign = extras.getString(SIGN);
      Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.horoscopedates.com/zodiac-signs/" + sign + "/"));
      startActivity(browserIntent);
    }
  }
}
