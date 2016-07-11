package ly.generalassemb.drewmahrt.oofundamentals;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class CreateAnimalActivity extends AppCompatActivity {
    public static final String ANIMAL_SERIALIZABLE_KEY = "animalSerializableKey";

    private CheckBox mCheckBox;
    private Button mCreateAnimalButton;
    private int mRequestCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_animal);

        mRequestCode = getIntent().getIntExtra(MainActivity.REQUEST_CODE,-1);

        mCheckBox = (CheckBox)findViewById(R.id.checkbox);

        mCreateAnimalButton = (Button)findViewById(R.id.create_animal_button);
        mCreateAnimalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();

                if(mRequestCode == MainActivity.ADD_LION){
                    //create new Lion object to pass back
                    Lion lion = new Lion(mCheckBox.isChecked());
                    intent.putExtra(ANIMAL_SERIALIZABLE_KEY, lion);
                }else{
                    //create new Snake object to pass back
                    Snake snake = new Snake(mCheckBox.isChecked());
                    intent.putExtra(ANIMAL_SERIALIZABLE_KEY, snake);
                }

                setResult(RESULT_OK, intent);
                finish();

            }
        });

        if (mRequestCode == MainActivity.ADD_LION){
            mCheckBox.setText("is Alpha");
        } else if (mRequestCode == MainActivity.ADD_SNAKE){
            mCheckBox.setText("is Poisonous");
        } else {
            mCheckBox.setVisibility(View.INVISIBLE);
        }
    }
}
