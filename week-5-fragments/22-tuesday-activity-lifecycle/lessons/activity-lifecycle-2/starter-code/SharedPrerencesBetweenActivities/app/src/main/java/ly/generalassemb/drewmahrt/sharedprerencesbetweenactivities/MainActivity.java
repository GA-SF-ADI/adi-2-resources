package ly.generalassemb.drewmahrt.sharedprerencesbetweenactivities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.SharedPreferences.Editor;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.message_edit_text);
        Button submitButton = (Button)findViewById(R.id.submit_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Save the text from the EditText to the SharedPreferences
                SharedPreferences sterlingPreference = getPreferences(Context.MODE_PRIVATE);

                //Shared preferences "reads" the string
                String str = sterlingPreference.getString("myKey","DEFAULT");

                //to save my Sterling Preference I must retrieve an object called editor
                //to do this i have to remember to import api android:content.sharedpreferences.editor
                Editor editor = sterlingPreference.edit();
                editor.putString("myKey",str+" World!");
                editor.commit();
            }
        });
    }
}
