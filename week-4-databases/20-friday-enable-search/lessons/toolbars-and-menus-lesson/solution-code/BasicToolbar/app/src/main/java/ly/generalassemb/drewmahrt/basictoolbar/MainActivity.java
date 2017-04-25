package ly.generalassemb.drewmahrt.basictoolbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declare a Toolbar and link to xml Resource
        Toolbar toolbar = (Toolbar)findViewById(R.id.my_toolbar);
        //Set support action bar for our Toolbar
        setSupportActionBar(toolbar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //we are gathering out menu items and inflating the options
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        //returning our menu after inflation
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:

                return true;

            case R.id.action_share:

                Toast.makeText(MainActivity.this, "Share!", Toast.LENGTH_LONG).show();
                return true;

            case R.id.action_security:

                Toast.makeText(MainActivity.this, "Security", Toast.LENGTH_LONG).show();
                return true;

            case R.id.action_press:

                Toast.makeText(MainActivity.this, "Play", Toast.LENGTH_LONG).show();

                return true;

            case R.id.action_fast:

                Toast.makeText(MainActivity.this, "Say Cheese", Toast.LENGTH_LONG).show();

                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
