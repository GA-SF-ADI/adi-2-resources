package ly.generalassemb.drewmahrt.sharedprerencesbetweenactivities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.SharedPreferences.Editor;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    public static String MY_MESSAGE = "my message";
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.message_edit_text);
        Button submitButton = (Button) findViewById(R.id.submit_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get the text from the editText
                String str = editText.getText().toString();

                //get shared preferences and USE THAT KEY FOR SECOND ACTIVITY
                sharedPreferences = MainActivity.this.getSharedPreferences("com.example.app.MY_MESSAGE", Context.MODE_PRIVATE);
                //TODO: Save the text from the EditText to the SharedPreferences

                //First, make the editor
                Editor editor = sharedPreferences.edit();

                //put it into our string
                editor.putString("text", editText.getText().toString());
                //or you could write this instead
                //editor.putString("text", editText.getText().toString());

                //commit it
                editor.commit();

                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);
            }
        });
    }
}
