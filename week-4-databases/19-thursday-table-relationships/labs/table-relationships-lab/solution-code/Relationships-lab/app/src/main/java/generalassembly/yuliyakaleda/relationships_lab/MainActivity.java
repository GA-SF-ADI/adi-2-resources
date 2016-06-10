package generalassembly.yuliyakaleda.relationships_lab;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
  private ListView result;
  private SameWorkPlaceAsync sameWorkPlaceAsync;
  private BostonLocationAsync bostonLocationAsync;
  private CompanyWithHighestSalaryAsync companyWithHighestSalaryAsync;
  private TextView singleNameText;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    singleNameText = (TextView) findViewById(R.id.result_text);
    result = (ListView) findViewById(R.id.result_list);

    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    Button sameWorkplace = (Button) findViewById(R.id.same_workplace);
    Button bostonLocation = (Button) findViewById(R.id.boston_location);
    Button bestPaidCity = (Button) findViewById(R.id.best_paid_company);
    Button addData = (Button) findViewById(R.id.add_data);

    fab.setOnClickListener(this);
    sameWorkplace.setOnClickListener(this);
    bostonLocation.setOnClickListener(this);
    bestPaidCity.setOnClickListener(this);
    addData.setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {

    switch (v.getId()) {
      case R.id.fab:
        Intent intent = new Intent(this, DialogActivity.class);
        startActivity(intent);
        break;

      case R.id.add_data:
        addDataToDb();
        break;

      case R.id.same_workplace:
        if (bostonLocationAsync != null) {
          bostonLocationAsync.cancel(true);
        }

        if (companyWithHighestSalaryAsync != null) {
          companyWithHighestSalaryAsync.cancel(true);
        }

        sameWorkPlaceAsync = new SameWorkPlaceAsync();
        sameWorkPlaceAsync.execute();
        break;

      case R.id.boston_location:
        if (sameWorkPlaceAsync != null) {
          sameWorkPlaceAsync.cancel(true);
        }

        if (companyWithHighestSalaryAsync != null) {
          companyWithHighestSalaryAsync.cancel(true);
        }

        bostonLocationAsync = new BostonLocationAsync();
        bostonLocationAsync.execute();
        break;

      case R.id.best_paid_company:
        if (bostonLocationAsync != null) {
          bostonLocationAsync.cancel(true);
        }

        if (sameWorkPlaceAsync != null) {
          sameWorkPlaceAsync.cancel(true);
        }

        companyWithHighestSalaryAsync = new CompanyWithHighestSalaryAsync();
        companyWithHighestSalaryAsync.execute();
        break;
    }
  }

  private void addDataToDb() {
    new AsyncTask<Void, Void, Void>() {
      @Override
      protected Void doInBackground(Void... params) {
        Helper helper = Helper.getInstance(MainActivity.this);
        Employee employee1 = new Employee("123-04-5678", "John", "Smith", 1973, "NY");
        Employee employee2 = new Employee("123-04-5679", "David", "McWill", 1982, "Seattle");
        Employee employee3 = new Employee("123-04-5680", "Katerina", "Wise", 1973, "Boston");
        Employee employee4 = new Employee("123-04-5681", "Donald", "Lee", 1992, "London");
        Employee employee5 = new Employee("123-04-5682", "Gary", "Henwood", 1987, "Las Vegas");
        Employee employee6 = new Employee("123-04-5683", "Anthony", "Bright", 1963, "Seattle");
        Employee employee7 = new Employee("123-04-5684", "William", "Newey", 1995, "Boston");
        Employee employee8 = new Employee("123-04-5685", "Melony", "Smith", 1970, "Chicago");

        helper.insertRow(employee1);
        helper.insertRow(employee2);
        helper.insertRow(employee3);
        helper.insertRow(employee4);
        helper.insertRow(employee5);
        helper.insertRow(employee6);
        helper.insertRow(employee7);
        helper.insertRow(employee8);

        Job job1 = new Job("123-04-5678", "Fuzz",60, 1);
        Job job2 = new Job("123-04-5679", "GA", 70, 2);
        Job job3 = new Job("123-04-5680", "Little Place", 120, 5);
        Job job4 = new Job("123-04-5681", "Macys", 78, 3);
        Job job5 = new Job("123-04-5682", "New Life", 65, 1);
        Job job6 = new Job("123-04-5683", "Believe", 158, 6);
        Job job7 = new Job("123-04-5684", "Macys", 200, 8);
        Job job8 = new Job("123-04-5685", "Stop", 299, 12);

        helper.insertRowJob(job1);
        helper.insertRowJob(job2);
        helper.insertRowJob(job3);
        helper.insertRowJob(job4);
        helper.insertRowJob(job5);
        helper.insertRowJob(job6);
        helper.insertRowJob(job7);
        helper.insertRowJob(job8);
        return null;
      }
    }.execute();
  }

  private class SameWorkPlaceAsync extends AsyncTask<Void, Void, List<String>> {

    @Override
    protected List<String> doInBackground(Void... params) {
      Helper helper = Helper.getInstance(MainActivity.this);
      List<String> employees = helper.getEmployeesWorkingAtTheSameCompany();
      return employees;
    }

    @Override
    protected void onPostExecute(List<String> employees) {
      super.onPostExecute(employees);
      ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
          android.R.layout.simple_list_item_1, employees);
      result.setAdapter(adapter);
    }
  }

  private class BostonLocationAsync extends AsyncTask<Void, Void, List<String>> {

    @Override
    protected List<String> doInBackground(Void... params) {
      Helper helper = Helper.getInstance(MainActivity.this);
      List<String> companies = helper.getCompaniesLocatedInBoston();
      return companies;
    }

    @Override
    protected void onPostExecute(List<String> companies) {
      super.onPostExecute(companies);
      ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,
          android.R.layout.simple_list_item_1, companies);
      result.setAdapter(adapter);
    }
  }

  private class CompanyWithHighestSalaryAsync extends AsyncTask<Void, Void, String> {

    @Override
    protected String doInBackground(Void... params) {
      Helper helper = Helper.getInstance(MainActivity.this);
      String city = helper.getCompanyWithHighestSalary();
      return city;
    }

    @Override
    protected void onPostExecute(String city) {
      super.onPostExecute(city);
      singleNameText.setText(city);
    }
  }
}
