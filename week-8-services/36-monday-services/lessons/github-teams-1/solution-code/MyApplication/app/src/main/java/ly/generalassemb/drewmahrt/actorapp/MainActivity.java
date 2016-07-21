package ly.generalassemb.drewmahrt.actorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Actor> mActors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mActors = new ArrayList<>();
        mActors.add(new Actor("Leonardo DiCaprio", "November 11, 1974", 1));
        mActors.add(new Actor("Matt Damon","October 8, 1970",1));
        mActors.add(new Actor("Jennifer Lawrence","August 15, 1990",1));

        ListView listView = (ListView) findViewById(R.id.actor_list);
        listView.setAdapter(new ActorArrayAdapter(this,R.layout.actor_item,mActors));
    }
}
