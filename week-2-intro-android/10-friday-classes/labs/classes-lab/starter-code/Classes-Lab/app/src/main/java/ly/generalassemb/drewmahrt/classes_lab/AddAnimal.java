package ly.generalassemb.drewmahrt.classes_lab;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.io.Serializable;

import static android.R.attr.name;
import static ly.generalassemb.drewmahrt.classes_lab.R.id.topSpeed;

public class AddAnimal extends AppCompatActivity {
    EditText legsEditText, nameEditText, topSpeedEditText, doggoEditText, turtleEditText;
    CheckBox isEndangeredCheckBox;
    int requestcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_animal);

        requestcode = getIntent().getIntExtra("RequestCode", -1);


        nameEditText = (EditText) findViewById(R.id.name);
        legsEditText = (EditText) findViewById(R.id.numberOfLegs);
        topSpeedEditText = (EditText) findViewById(topSpeed);
        isEndangeredCheckBox = (CheckBox) findViewById(R.id.isEndangered);
        Button submitButton = (Button) findViewById(R.id.submit);
        if(requestcode ==2){
            doggoEditText = (EditText) findViewById(R.id.doggo);
            doggoEditText.setVisibility(View.VISIBLE);
            legsEditText.setVisibility(View.GONE);
            topSpeedEditText.setVisibility(View.GONE);
            isEndangeredCheckBox.setVisibility(View.GONE);

        }else if(requestcode==3){
            turtleEditText = (EditText) findViewById(R.id.turtle);
            turtleEditText.setVisibility(View.VISIBLE);
            legsEditText.setVisibility(View.GONE);
            topSpeedEditText.setVisibility(View.GONE);
            isEndangeredCheckBox.setVisibility(View.GONE);
        }




        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isEndangered= false;
                String name = nameEditText.getText().toString();

                int legs=0;
                int topSpeed=0;

                if (requestcode==1) {
                    legs = Integer.parseInt(legsEditText.getText().toString());

                    topSpeed = Integer.parseInt(topSpeedEditText.getText().toString());
                    if (isEndangeredCheckBox.isChecked()) {
                        isEndangered = true;

                    } else {
                        isEndangered = false;
                    }
                }
                    Intent animalResult = new Intent();



                if(requestcode ==2){
                    String doggo = doggoEditText.getText().toString();
                    animalResult.putExtra("Doggo", doggo);
                    legs =4;
                    topSpeed= 45;
                    isEndangered=false;
                }else if(requestcode==3){
                    String turtle = turtleEditText.getText().toString();
                    animalResult.putExtra("Turtle", turtle);
                    topSpeed=6;
                    legs=4;
                    isEndangered=false;

                }
                animalResult.putExtra("AnimalName", name);
                animalResult.putExtra("AnimalLegs", legs);
                animalResult.putExtra("AnimalTopSpeed", topSpeed);
                animalResult.putExtra("AnimalIsEndangered", isEndangered);
                setResult(RESULT_OK, animalResult);

                finish();
            }
        });


    }
}
