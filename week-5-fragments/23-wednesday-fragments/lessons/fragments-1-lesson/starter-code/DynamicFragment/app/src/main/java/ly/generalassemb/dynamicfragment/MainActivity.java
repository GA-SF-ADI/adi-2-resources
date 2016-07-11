package ly.generalassemb.dynamicfragment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button dailyWeather, weeklyWeather;
    FragmentManager fragmentManager;
    DailyWeatherFragment dailyFragment;
    WeeklyWeatherFragment weeklyFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupButtons();

        // TODO: setup fragment manager and transaction
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // TODO: create dailyForecast fragment
        dailyFragment = new DailyWeatherFragment();
        weeklyFragment = new WeeklyWeatherFragment();

        // TODO: add the daily forecast fragment to the container and commit the change
        fragmentTransaction.add(R.id.fragment_container,dailyFragment);

    }

    private void setupButtons(){
        dailyWeather = (Button) findViewById(R.id.daily_button);
        weeklyWeather = (Button) findViewById(R.id.weekly_button);

        dailyWeather.setOnClickListener(this);
        weeklyWeather.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.daily_button:
                // todo replace with dailyWeather fragment
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container,dailyFragment);
                fragmentTransaction.commit();

                break;
            case R.id.weekly_button:
                // todo replace with weeklyWeather fragment
                FragmentTransaction fragmentTransactionWeekly = fragmentManager.beginTransaction();
                fragmentTransactionWeekly.replace(R.id.fragment_container,weeklyFragment);
                fragmentTransactionWeekly.commit();
                break;
            default:
                break;
        }

    }

}
