package ly.generalassemb.drewmahrt.subclassinglab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final int ADD_LION = 100;
    public static final int ADD_SNAKE = 200;

    public static final String REQUEST_CODE = "requestCode";

    Zoo zoo;
    //ArrayList<Animal> mAnimalArrayList;
    ArrayAdapter<Animal> mAdapter;
    Button mAddLionButton, mAddSnakeButton, mRemoveLastButton;
    ListView mAnimalListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        if(mAnimalArrayList == null){
            mAnimalArrayList = new ArrayList<>();
        }*/

        if(zoo == null) {
            zoo = Zoo.getInstance();
        }

        mAddLionButton = (Button)findViewById(R.id.add_lion_button);
        mAddSnakeButton = (Button)findViewById(R.id.add_snake_button);
        mRemoveLastButton = (Button)findViewById(R.id.remove);

        mAdapter = new ArrayAdapter<Animal>(MainActivity.this, android.R.layout.simple_list_item_1, zoo.getAnimalList());

        mAnimalListView = (ListView)findViewById(R.id.animal_list_view);
        mAnimalListView.setAdapter(mAdapter);

        mAddLionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CreateAnimalActivity.class);
                intent.putExtra(REQUEST_CODE, ADD_LION);
                startActivityForResult(intent, ADD_LION);
            }
        });

        mAddSnakeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CreateAnimalActivity.class);
                intent.putExtra(REQUEST_CODE, ADD_SNAKE);
                startActivityForResult(intent, ADD_SNAKE);
            }
        });

        mRemoveLastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(zoo.getAnimalList().size()>0) {
                    zoo.removeAnimal();
                    mAdapter.notifyDataSetChanged();
                }  else Toast.makeText(MainActivity.this, "Nothing to remove!", Toast.LENGTH_SHORT).show();
            }
        });

        mAnimalListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                zoo.getAnimalList().get(position).makeNoise(MainActivity.this);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK){
            Animal createdAnimal = (Animal)data.getSerializableExtra(CreateAnimalActivity.ANIMAL_SERIALIZABLE_KEY);
            zoo.addAnimal(createdAnimal);
            mAdapter.notifyDataSetChanged();
        }
    }
}