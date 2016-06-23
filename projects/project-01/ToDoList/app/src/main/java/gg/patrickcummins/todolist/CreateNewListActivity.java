package gg.patrickcummins.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class CreateNewListActivity extends AppCompatActivity {
    private EditText listNameEditText;
    private Button createListButton;
    private int mRequestCode;
    private RadioButton blue, red, green, orange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_list);
        getSupportActionBar().setTitle("New List");
        setUpVariables();
        setUpRadioButtons();
        setOnClickListeners();
    }

    private void setOnClickListeners() {
        createListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listNameEditText.getText().toString().equals("")) {
                    listNameEditText.setError("!");
                } else {
                    Intent result = new Intent();
                    result.putExtra("newList", listNameEditText.getText().toString());
                    if (blue.isChecked()) {
                        result.putExtra("color", "blue");
                    } else if (red.isChecked()) {
                        result.putExtra("color", "red");
                    } else if (green.isChecked()) {
                        result.putExtra("color", "green");
                    } else if (orange.isChecked()) {
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

    private void setUpVariables() {
        listNameEditText = (EditText) findViewById(R.id.listNameEditText);
        createListButton = (Button) findViewById(R.id.createListButton);
    }

    private void setUpRadioButtons() {
        blue = (RadioButton) findViewById(R.id.blueRadio);
        red = (RadioButton) findViewById(R.id.redRadio);
        green = (RadioButton) findViewById(R.id.greenRadio);
        orange = (RadioButton) findViewById(R.id.orangeRadio);
    }
}
