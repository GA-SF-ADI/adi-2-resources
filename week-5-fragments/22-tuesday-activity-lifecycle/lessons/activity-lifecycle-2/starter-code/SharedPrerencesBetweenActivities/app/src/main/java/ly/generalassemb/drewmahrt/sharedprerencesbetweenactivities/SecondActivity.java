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

        //"com.example.app.MY_MESSAGE" must be exactly the same in both activities...

        SharedPreferences sharedPreferences = getSharedPreferences("com.example.app.MY_MESSAGE",Context.MODE_PRIVATE);
        //text must be the exact same key for both activities
        String message = sharedPreferences.getString("text","my Message");

        textView.setText("Message from MainActivity: "+ message);

    }
}
