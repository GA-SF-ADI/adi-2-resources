package ly.generalassemb.dynamicfragment;

import android.os.Bundle;
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

        // TODO: setup fragment manager and transaction
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // TODO: create dailyForecast fragment
        DailyForecastFragment dailyForecastFragment = new DailyForecastFragment();

        // TODO: add the daily forecast fragment to the container and commit the change
        fragmentTransaction.add(R.id.fragment_container, dailyForecastFragment);
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

        switch (v.getId()){
            case R.id.daily_button:
                // todo replace with dailyWeather fragment

                DailyForecastFragment dailyForecastFragment = new DailyForecastFragment();

                fragmentTransaction.add(R.id.fragment_container, dailyForecastFragment);
                fragmentTransaction.commit();
                break;

            case R.id.weekly_button:
                // todo replace with weeklyWeather fragment
                WeeklyForecastFragment weeklyForecastFragment = new WeeklyForecastFragment();

                fragmentTransaction.add(R.id.fragment_container, weeklyForecastFragment);
                fragmentTransaction.commit();
                break;

            default:
                break;
        }

    }

}
