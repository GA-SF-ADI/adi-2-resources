package generalassembly.yuliyakaleda.usabilitytestinglabsolutioncode;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements OnSignClickedListener{

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Create a new SignListFragment that we have to add to our container! So we could see it.
    SignListFragment signListFragment = new SignListFragment();

    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

    // Add created SignListFragment to the container then commit the change
    fragmentTransaction.add(R.id.fragment_container, signListFragment);
    fragmentTransaction.commit();
  }

  /**
   * We are implementing OnSignClickedListener by overriding the onSignClick()
   * of the interface and making it do something.
   *
   * @param sign
     */
  @Override
  public void onSignClick(String sign) {
    // Activity received 'String sign' from SignListFragment!

    // Create fragment manager to be used in both cases of if/else clause
    FragmentManager fragmentManager = getSupportFragmentManager();

    // Looking for details Fragment. It exists on large layouts ( land and port ) but not on phone layouts
    // Use fragment manager to find our Details Fragment and store it into a variable
    DetailsFragment detailsFragment = (DetailsFragment) fragmentManager.findFragmentById(R.id.details_fragment);


    if (detailsFragment == null){
      // Phone layout, we need to create a Details Fragment. Then we need to replace
      // current fragment with newly created Details Fragment. Then pass `String sign`
      // to details fragment

      // Since detailsFragment is null ( doesn't exist yet ), we need to create one first
      detailsFragment = new DetailsFragment();

      FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
      fragmentTransaction.replace(R.id.fragment_container, detailsFragment);

      // We add this transaction to back stack so that we could use the back button to undo this replace
      fragmentTransaction.addToBackStack(DetailsFragment.class.getSimpleName());

      // commit the transaction
      fragmentTransaction.commit();

      // pass the `sign` String to details fragment so the webview loads new url
      detailsFragment.updateContent(sign);

    } else {
      // Tablet layout, pass the `String sign` to Details fragment since it exists!

      // pass the `sign` String to details fragment so the webview loads new url
      detailsFragment.updateContent(sign);
    }
  }
}

