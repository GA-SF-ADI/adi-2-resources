package ly.generalassemb.drewmahrt.morefragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MyListFragment.OnPlanetSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onPlanetSelected(String selectedPlanet) {
        DetailFragment detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.detail_fragment);
        detailFragment.setPlanetText(selectedPlanet);
    }
}
