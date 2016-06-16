package co.ga.brokenapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Declaring all of the member variables that we expect to reference in this activity. They are
    // initialized in the onCreate() method.
    TextView mAnswerTextView;
    EditText mNumberOneEditText;
    EditText mNumberTwoEditText;
    Button mAddButton;
    Button mSubtractButton;
    Button mMultiplicationButton;
    Button mDivisionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing all of the member variables.
        mAnswerTextView = (TextView) findViewById(R.id.answerTextView);
        mNumberOneEditText = (EditText) findViewById(R.id.number1EditText);
        mNumberTwoEditText = (EditText) findViewById(R.id.number2EditText);
        mAddButton = (Button) findViewById(R.id.addButton);
        mSubtractButton = (Button) findViewById(R.id.subtractButton);
        mMultiplicationButton = (Button) findViewById(R.id.multiplicatonButton);
        mDivisionButton = (Button) findViewById(R.id.divisionButton);

        // creating click listeners for each action
        View.OnClickListener addButtonListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTwoNumbers();
            }
        };

        View.OnClickListener subtractButtonListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subtractTwoNumbers();
            }
        };

        View.OnClickListener multiplyButtonListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                multiplyTwoNumbers();
            }
        };

        View.OnClickListener divideButtonListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                divideTwoNumbers();
            }
        };

        mAddButton.setOnClickListener(addButtonListener);
        mSubtractButton.setOnClickListener(subtractButtonListener);
        mMultiplicationButton.setOnClickListener(multiplyButtonListener);
        mDivisionButton.setOnClickListener(divideButtonListener);

    }

    public void addTwoNumbers(){
        int number1 = Integer.parseInt(mNumberOneEditText.getText().toString());
        int number2 = Integer.parseInt(mNumberTwoEditText.getText().toString());
        Log.w("add", "multiplcation not working");
        Toast.makeText(MainActivity.this, "add.", Toast.LENGTH_LONG).show();

        int answer = number1 + number2;

        mAnswerTextView.setText("Answer: " + answer);
    }

    public void subtractTwoNumbers(){
        int number1 = Integer.parseInt(mNumberOneEditText.getText().toString());
        int number2 = Integer.parseInt(mNumberTwoEditText.getText().toString());
        Log.w("subtract", "multiplcation not working");
        Toast.makeText(MainActivity.this, "subtract.", Toast.LENGTH_LONG).show();
        int answer = number1 - number2;

        mAnswerTextView.setText("Answer: " + answer);
    }

    public void multiplyTwoNumbers(){
        int number1 = Integer.parseInt(mNumberOneEditText.getText().toString());
        int number2 = Integer.parseInt(mNumberTwoEditText.getText().toString());
        Log.w("multiply", "multiplcation not working");
        Toast.makeText(MainActivity.this, "multiply.", Toast.LENGTH_LONG).show();

        int answer =  number1 * number2;

        mAnswerTextView.setText("Answer: " + answer);

    }

    public void divideTwoNumbers(){
        int number1 = Integer.parseInt(mNumberOneEditText.getText().toString());
        int number2 = Integer.parseInt(mNumberTwoEditText.getText().toString());
        Log.w("divide", "divide not working");
        Toast.makeText(MainActivity.this, "divide,", Toast.LENGTH_LONG).show();

        float answer = ((float) number1) / number2;

        mAnswerTextView.setText("Answer: " + answer);
    }
}
