package ly.generalassemb.drewmahrt.sharedprerencesbetweenactivities;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView textView = (TextView)findViewById(R.id.message_text_view);

        //TODO: Retrieve the text from SharedPreferences and set it to the String variable "message"

        SharedPreferences sterlingPreference = getPreferences("myKey", Context.MODE_PRIVATE);
        String message = sterlingPreference.getString("editKey", "default");
                textView.set("message from main activity: i am using shared preferences!  look!")
    }
}
