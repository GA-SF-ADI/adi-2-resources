package gg.patrickcummins.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class EditItemActivity extends AppCompatActivity {
    private EditText itemNameEditText;
    private EditText itemDescriptionEditText;
    private Button createItemButton;
    private RadioButton blue, red, green, orange;
    private int currentposition;
    public static final String ITEM_EDITED_SERIALIZABLE_KEY = "itemEditedKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        itemNameEditText = (EditText) findViewById(R.id.itemNameEditText);
        itemDescriptionEditText = (EditText) findViewById(R.id.itemDescriptionEditText);
        createItemButton = (Button) findViewById(R.id.createItemButton);
        final Intent mIntent = getIntent();
        final ListItem currentItem = (ListItem) mIntent.getSerializableExtra(ViewListOfItemsActivity.EDIT_ITEM_SERIALIZABLE_KEY);

        itemNameEditText.setText(currentItem.getmName());
        itemDescriptionEditText.setText(currentItem.getDescription());
        currentposition = mIntent.getIntExtra("position", -1);
        createItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemNameEditText.getText().toString().equals("") || itemDescriptionEditText.getText().toString().equals("")) {
                    if (itemNameEditText.getText().toString().equals("")) {
                        itemNameEditText.setError("!");
                    } else {
                        itemDescriptionEditText.setError("!");
                    }
                } else {
                    Intent result = new Intent();

                    currentItem.setmName(itemNameEditText.getText().toString());
                    currentItem.setDescription(itemDescriptionEditText.getText().toString());
                    setUpRadioButtons();
                    if (blue.isChecked()) {
                        currentItem.setColor("blue");
                    } else if (red.isChecked()) {
                        currentItem.setColor("red");
                    } else if (green.isChecked()) {
                        currentItem.setColor("green");
                    } else if (orange.isChecked()) {
                        currentItem.setColor("orange");
                    } else {
                        currentItem.setColor("white");
                    }
                    result.putExtra(ITEM_EDITED_SERIALIZABLE_KEY, currentItem);
                    result.putExtra("position", currentposition);
                    setResult(RESULT_OK, result);
                    finish();
                }
            }
        });




    }
    private void setUpRadioButtons() {
        blue = (RadioButton) findViewById(R.id.blueRadio);
        red = (RadioButton) findViewById(R.id.redRadio);
        green = (RadioButton) findViewById(R.id.greenRadio);
        orange = (RadioButton) findViewById(R.id.orangeRadio);
    }
}
