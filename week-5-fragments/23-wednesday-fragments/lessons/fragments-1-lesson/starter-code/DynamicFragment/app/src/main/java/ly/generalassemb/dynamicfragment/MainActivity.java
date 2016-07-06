package ly.generalassemb.dynamicfragment;

import android.os.Bundle;
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

        // TODO: create dailyForecast fragment

        // TODO: add the daily forecast fragment to the container and commit the change

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
                break;
            case R.id.weekly_button:
                // todo replace with weeklyWeather fragment
                break;
            default:
                break;
        }

    }

}
