package ly.generalassemb.drewmahrt.classes_lab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

/**
 * Created by michaeljeffress on 6/20/16.
 */
public class CreateAnimalActivity extends AppCompatActivity {
    public static final String ANIMAL_SERIALIZABLE_KEY = "animalSerializableKey";

    private CheckBox mCheckBox;
    private Button mCreateAnimalButton;
    private int mRequestCode;

    @Override
    protected void onCreate() {
        super();

        mCheckBox = (CheckBox)findViewById(ly.generalassemb.drewmahrt.subclassinglab.R.id.checkbox);

        mCreateAnimalButton = (Button)findViewById(ly.generalassemb.drewmahrt.subclassinglab.R.id.create_animal_button);
        mCreateAnimalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();

                if(mRequestCode == MainActivity.ADD_LION){
                    //create new Lion object to pass back
                    Lion lion = new Lion(mCheckBox.isChecked());
                    intent.putExtra(, lion);
                }else{
                    //create new Snake object to pass back
                    Snake snake = new Snake(mCheckBox.isChecked());
                    intent.putExtra(, snake);
                }

            }
        });

}