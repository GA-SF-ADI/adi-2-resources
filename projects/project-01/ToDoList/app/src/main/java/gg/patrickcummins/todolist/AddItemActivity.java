package gg.patrickcummins.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class AddItemActivity extends AppCompatActivity {
    private EditText itemNameEditText;
    private EditText itemDescriptionEditText;
    private Button createItemButton;
    private RadioButton blue, red, green, orange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        itemNameEditText = (EditText) findViewById(R.id.itemNameEditText);
        itemDescriptionEditText = (EditText) findViewById(R.id.itemDescriptionEditText);
        createItemButton = (Button) findViewById(R.id.createItemButton);

        createItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemNameEditText.getText().toString().equals("")|| itemDescriptionEditText.getText().toString().equals("")){
                    if (itemNameEditText.getText().toString().equals("")){
                        itemNameEditText.setError("!");
                    }else {
                        itemDescriptionEditText.setError("!");
                    }
                }else {
                    Intent result = new Intent();
                    result.putExtra("NameString", itemNameEditText.getText().toString());
                    result.putExtra("DescriptionString", itemDescriptionEditText.getText().toString());
                    setUpRadioButtons();
                    if (blue.isChecked()){
                        result.putExtra("color", "blue");
                    }else if (red.isChecked()){
                        result.putExtra("color", "red");
                    }else if (green.isChecked()){
                        result.putExtra("color", "green");
                    }else if (orange.isChecked()){
                        result.putExtra("color", "orange");
                    } else {
                        result.putExtra("color", "white");
                    }
                    setResult(RESULT_OK, result);
                    finish();
                }
            }
        });

    }
    private void setUpRadioButtons(){
        blue = (RadioButton) findViewById(R.id.blueRadio);
        red = (RadioButton) findViewById(R.id.redRadio);
        green = (RadioButton) findViewById(R.id.greenRadio);
        orange = (RadioButton) findViewById(R.id.orangeRadio);
    }
}
