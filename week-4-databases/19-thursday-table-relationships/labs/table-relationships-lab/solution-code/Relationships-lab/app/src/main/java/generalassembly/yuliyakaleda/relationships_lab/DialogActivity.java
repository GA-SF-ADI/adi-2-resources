package generalassembly.yuliyakaleda.relationships_lab;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class DialogActivity extends AppCompatActivity implements View.OnClickListener{
  private EditText ssnInput;
  private EditText firstNameInput;
  private EditText lastNameInput;
  private EditText yearInput;
  private EditText cityInput;
  private Button addData;
  private Button cancel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.dialog_layout);

    ssnInput = (EditText) findViewById(R.id.ssn_input);
    firstNameInput = (EditText) findViewById(R.id.fist_name_input);
    lastNameInput = (EditText) findViewById(R.id.last_name_input);
    yearInput = (EditText) findViewById(R.id.year_input);
    cityInput = (EditText) findViewById(R.id.city_input);
    addData = (Button) findViewById(R.id.add_button);
    cancel = (Button) findViewById(R.id.cancel_button);
    addData.setOnClickListener(this);
    cancel.setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.add_button:
        addDataToDb();
        finish();
        break;
      case R.id.cancel_button:
        finish();
        break;
    }

  }

  private void addDataToDb() {
    String ssn = ssnInput.getText().toString();
    String fistName = firstNameInput.getText().toString();
    String lastName = lastNameInput.getText().toString();
    int year = Integer.parseInt(yearInput.getText().toString());
    String city = cityInput.getText().toString();

    final Employee employee = new Employee(ssn, fistName, lastName, year, city);
    new AsyncTask<Employee, Void, Void>() {
      @Override
      protected Void doInBackground(Employee... params) {
        Helper helper = Helper.getInstance(DialogActivity.this);
        helper.insertRow(employee);
        return null;
      }

      @Override
      protected void onPostExecute(Void voids) {
        super.onPostExecute(voids);
        Toast.makeText(DialogActivity.this, R.string.data_added_to_db, Toast.LENGTH_LONG).show();
      }
    }.execute();
  }
}

