package ly.generalassemb.espresso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewTransactionActivity extends AppCompatActivity {

    EditText mDescriptionEditText;
    EditText mAmountEditText;
    Button mWithdrawbutton;
    Button mDepositButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_transaction);

        mDepositButton = (Button) findViewById(R.id.depositButton);
        mWithdrawbutton = (Button) findViewById(R.id.withdrawButton);
        mAmountEditText = (EditText) findViewById(R.id.amountEditText);
        mDescriptionEditText = (EditText) findViewById(R.id.descriptionEditText);

        mDepositButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitTransaction(false);
            }
        });

        mWithdrawbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitTransaction(true);
            }
        });
    }

    private void submitTransaction(boolean withdraw){
        String description = null;
        float amount = 0;

        boolean valid = true;

        description = mDescriptionEditText.getText().toString();

        try {
            amount = Float.parseFloat(mAmountEditText.getText().toString());
        } catch (Throwable thr){}

        if (TextUtils.isEmpty(description)){
            valid = false;

            mDescriptionEditText.setError("Missing description");
        }

        if (amount <= 0){
            valid = false;

            mAmountEditText.setError("Must be a positive number");
        }

        if (valid){
            if (withdraw){
                amount *= -1;
            }

            Transaction transaction = new Transaction(description, amount);
            Intent intent = new Intent();
            intent.putExtra(Transaction.class.getName(), transaction);

            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
