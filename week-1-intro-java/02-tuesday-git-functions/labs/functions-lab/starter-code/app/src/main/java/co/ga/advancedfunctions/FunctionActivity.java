package co.ga.advancedfunctions;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FunctionActivity extends AppCompatActivity {
    TextView outputText;
    TextView inputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function);
    }

    /**
     * Converts a string into an integer
     * @return An integer version of the string, or 0 if the string is not a number.
     */
    private int convertToInteger(String numberString){
        int value = 0;

        if (!TextUtils.isEmpty(numberString)){
            try {
                value = Integer.parseInt(numberString);
            } catch (NumberFormatException ex){ }
        }

        return value;
    }
}
