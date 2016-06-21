package gg.patrickcummins.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddItemActivity extends AppCompatActivity {
    private EditText itemNameEditText;
    private EditText itemDescriptionEditText;
    private Button createItemButton;

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
                    setResult(RESULT_OK, result);
                    finish();
                }
            }
        });

    }
}
