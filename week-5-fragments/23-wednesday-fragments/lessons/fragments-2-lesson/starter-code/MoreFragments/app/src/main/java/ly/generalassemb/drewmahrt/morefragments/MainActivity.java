package ly.generalassemb.drewmahrt.morefragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements  MyListFragment.OnPlanetSelectedListener { // TODO: 1. implement your Interface

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // TODO: 2. Implement the interface method
    // TODO: 2a. Grab DetailFragment from FragmentManager
    // TODO: 2b. Use your DetailFragment's instance and pass selectedPlanet to the helper method

    @Override
    public void onPlanetSelected(String selectedPlanet) {
        DetailFragment detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.detail_fragment);
        detailFragment.setPlanetText(selectedPlanet);
    }

}
