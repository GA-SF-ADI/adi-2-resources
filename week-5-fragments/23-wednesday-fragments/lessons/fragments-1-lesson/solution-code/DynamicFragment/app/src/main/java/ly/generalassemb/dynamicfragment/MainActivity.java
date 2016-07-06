package ly.generalassemb.dynamicfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button dailyWeather, weeklyWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupButtons();

        // setup fragment manager and transaction
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // create dailyForecast fragment
        DailyForecast dailyForecast = new DailyForecast();

        // add the daily forecast fragment to the container and commit the change
        fragmentTransaction.add(R.id.weather_fragment_container, dailyForecast);
        fragmentTransaction.commit();
    }

    private void setupButtons(){
        dailyWeather = (Button) findViewById(R.id.daily_button);
        weeklyWeather = (Button) findViewById(R.id.weekly_button);

        dailyWeather.setOnClickListener(this);
        weeklyWeather.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // create fragment for code re-use. We don't want to repeat code.
        Fragment fragment = null;
        switch (v.getId()){
            case R.id.daily_button:
                fragment = new DailyForecast();
                break;
            case R.id.weekly_button:
                fragment = new WeekForecast();
                break;
            default:
                break;
        }

        // only need to replace and commit if the fragment was created
        if (fragment != null){
            fragmentTransaction.replace(R.id.weather_fragment_container, fragment);
            fragmentTransaction.commit();
        }
    }

}
