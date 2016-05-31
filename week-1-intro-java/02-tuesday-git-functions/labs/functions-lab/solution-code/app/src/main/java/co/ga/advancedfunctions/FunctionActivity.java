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

        outputText = (TextView) findViewById(R.id.outputText);
        inputText = (TextView) findViewById(R.id.inputText);

        Button gradeButton = (Button) findViewById(R.id.gradeButton);
        Button passFailButton = (Button) findViewById(R.id.passFailButton);
        Button fiveButton = (Button) findViewById(R.id.fiveButton);


        gradeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = inputText.getText().toString();

                if (isValidNumber(input)) {
                    String output = getLetterGrade(input);

                    outputText.setText(output);
                    setPassFailTextColor(input);
                } else {
                    Toast.makeText(FunctionActivity.this, "The number was not valid!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        passFailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String grade = inputText.getText().toString();

                if (isValidNumber(grade)) {
                    if (isPassing(grade)) {
                        outputText.setText("Pass");
                    } else {
                        outputText.setText("Fail");
                    }

                    setPassFailTextColor(grade);
                } else {
                    Toast.makeText(FunctionActivity.this, "The number was not valid!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        fiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String grade = inputText.getText().toString();

                if (isValidNumber(grade)){
                    String output = fiveGrades(grade);
                    outputText.setText(output);
                } else {
                    Toast.makeText(FunctionActivity.this, "The number was not valid!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    // Prints the given string times
    private String fiveGrades(String input) {
        String fiveGrades = "";

        for (int i = 0; i < 5; i++) {
            fiveGrades += input + " ";
        }

        return fiveGrades;
    }

    // returns the letter grade corresponding to the given number
    private String getLetterGrade(String numberGrade) {
        String letterGrade;

        int gradeInt = convertToInteger(numberGrade);

        if (gradeInt > 90){
            letterGrade = "A";
        } else if (gradeInt > 80){
            letterGrade = "B";
        } else if (gradeInt > 70){
            letterGrade = "C";
        } else if (gradeInt > 60){
            letterGrade = "D";
        } else {
            letterGrade = "F";
        }

        return letterGrade;
    }

    // Sets the color of the output text view to red or green, depending on if the grade is passing
    public void setPassFailTextColor(String grade) {
        if (isPassing(grade)){
            outputText.setTextColor(Color.GREEN);
        } else {
            outputText.setTextColor(Color.RED);
        }
    }

    // Returns true if the given grade is passing, i.e. at least 65
    private boolean isPassing(String grade) {
        int gradeInt = convertToInteger(grade);

        return gradeInt >= 65;
    }

    // Checks if the provided number is between 0 and 100, and if it is actually a number
    private boolean isValidNumber(String grade) {
        boolean valid = false;

        if (!TextUtils.isEmpty(grade)){
            int gradeInt = convertToInteger(grade);
            valid = gradeInt >= 0 && gradeInt <= 100;
        }

        return valid;
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
