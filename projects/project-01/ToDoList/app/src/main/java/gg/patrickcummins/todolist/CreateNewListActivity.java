package gg.patrickcummins.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateNewListActivity extends AppCompatActivity {
    private  EditText listNameEditText;
    private  Button createListButton;
    private int mRequestCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_list);

        listNameEditText = (EditText) findViewById(R.id.listNameEditText);
        createListButton = (Button) findViewById(R.id.createListButton);

        createListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listNameEditText.getText().toString().equals("")) {
                    listNameEditText.setError("!");
                }else{
                    Intent intent = new Intent();
                    intent.putExtra("newList", listNameEditText.getText().toString());
                    setResult(RESULT_OK, intent);
                    finish();

                }
            }
        });




    }
}
