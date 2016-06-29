package ly.generalassemb.drewmahrt.shoppinglistwithdetailview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddItemActivity extends AppCompatActivity {
    private EditText name, description, price, type;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        setUpViews();

        final ShoppingSQLiteOpenHelper helper = ShoppingSQLiteOpenHelper.getInstance(AddItemActivity.this);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.addItem(name.getText().toString(), description.getText().toString(), price.getText().toString(), type.getText().toString());
                finish();
            }
        });


    }

    private void setUpViews() {
        name = (EditText) findViewById(R.id.nameEditText);
        description = (EditText) findViewById(R.id.descriptionEditText);
        price = (EditText) findViewById(R.id.priceEditText);
        type = (EditText) findViewById(R.id.typeEditText);

        submit = (Button) findViewById(R.id.submitButton);
    }
}
