package com.gradecodeschool.pandoratoolbarpractice;

        import android.view.Menu;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.Toolbar;
        import android.view.MenuInflater;
        import android.view.MenuItem;
        import android.widget.Toast;

public class Podcasts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_podcasts);

        Toolbar toolbar = (Toolbar) findViewById(R.id.podcast_toolbar);
        setSupportActionBar(toolbar);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.podcasts_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(), "You clicked the plus button", Toast.LENGTH_LONG).show();
                return true;

            case R.id.action_share:
                Toast.makeText(getApplicationContext(), "You decided to share the podcast!", Toast.LENGTH_LONG).show();

                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
