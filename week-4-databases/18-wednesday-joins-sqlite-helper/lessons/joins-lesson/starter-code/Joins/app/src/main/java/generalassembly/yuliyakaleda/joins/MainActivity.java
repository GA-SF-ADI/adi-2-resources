package generalassembly.yuliyakaleda.joins;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
  private TextView text;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    text = (TextView) findViewById(R.id.text);

    new AsyncTask<Employee, Void, String>() {
      @Override
      protected String doInBackground(Employee... params) {
        Employee employee = new Employee("John", 32, "NY", 30);
        Employee employee1 = new Employee("Harry", 31, "VA", 60);
        Employee employee2 = new Employee("Mike", 30, "NY", 100);

        Department department = new Department("IT Building", 7);
        Department department1 = new Department("Engineering", 2);
        Department department2 = new Department("Sales", 8);

        Helper helper = Helper.getInstance(MainActivity.this);
        helper.insertRow(employee);
        helper.insertRow(employee1);
        helper.insertRow(employee2);

        helper.insertRowDepartment(department);
        helper.insertRowDepartment(department1);
        helper.insertRowDepartment(department2);

        String name = helper.getNameJoins();

        //TODO: uncomment this line to test your solution for independent practice, change the
        // value of the return line to "return fullInfo"
        String fullInfo = helper.getFullInformation();
        return fullInfo;
      }

      @Override
      protected void onPostExecute(String name) {
        super.onPostExecute(name);
        text.setText(name);
      }
    }.execute();
  }
}
