package com.test.relationshipslab;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    DataBaseHelper db;
    ListView listView;
    TextView highestSalaryText;
    Button addDataButton, sameCompanyButton, bostonButton, highestButton, fab;
    Employee emp1,emp2,emp3,emp4,emp5,emp6,emp7,emp8;
    Job job1,job2,job3,job4,job5,job6,job7,job8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DataBaseHelper db = new DataBaseHelper(MainActivity.this);
        setViews();
        setDb();

        addDataButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                db.addEmployee(emp1);
                db.addEmployee(emp2);
                db.addEmployee(emp3);
                db.addEmployee(emp4);
                db.addEmployee(emp5);
                db.addEmployee(emp6);
                db.addEmployee(emp7);
                db.addEmployee(emp8);

                db.addJob(job1);
                db.addJob(job2);
                db.addJob(job3);
                db.addJob(job4);
                db.addJob(job5);
                db.addJob(job6);
                db.addJob(job7);
                db.addJob(job8);

            }
        });



        sameCompanyButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String same = db.getSameJob();

            }
        });



        bostonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String boston = db.getBostonJob();

            }
        });


        highestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String highest = db.getRichJob();
                highestSalaryText.setText(highest);
            }
        });












    }
    private void setViews(){
        addDataButton=(Button)findViewById(R.id.add_data_button);
        sameCompanyButton=(Button)findViewById(R.id.same_company_button);
        bostonButton=(Button)findViewById(R.id.boston_button);
        highestButton=(Button)findViewById(R.id.high_salary_button);
        listView=(ListView)findViewById(R.id.list_view);
        fab=(Button)findViewById(R.id.fab);
        highestSalaryText=(TextView)findViewById(R.id.high_text);

    }
    public void setDb(){
        emp1 = new Employee("John", "Smith", 1973, "NY", "123-04-5678");
        emp2 = new Employee("David", "McWill", 1982, "Seattle", "123-04-5679");
        emp3 = new Employee("Katerina", "Wise", 1973, "Boston", "123-04-5680");
        emp4 = new Employee("Donald", "Lee", 1992, "London", "123-04-5681");
        emp5 = new Employee("Gary", "Henwood", 1987, "Las Vegas", "123-04-5682");
        emp6 = new Employee("Anthony", "Bright", 1963, "Seattle", "123-04-5683");
        emp7 = new Employee("William", "Newey", 1995, "Boston", "123-04-5684");
        emp8 = new Employee("Melony", "Smith", 1970, "Chicago", "123-04-5685");

        job1 = new Job("Fuzz", 60, 1, "123-04-5678");
        job2 = new Job("GA", 70, 2, "123-04-5679");
        job3 = new Job("Little Place", 120, 5, "123-04-5680");
        job4 = new Job("Macy's", 78, 3, "123-04-5681");
        job5 = new Job("New Life", 65, 1, "123-04-5682");
        job6 = new Job("Believe", 158, 6, "123-04-5683");
        job7 = new Job("Macy's", 200, 8, "123-04-5684");
        job8 = new Job("Stop", 299, 12, "123-04-5685");
    }

}

//    Employee emp1 = new Employee("John", "Smith", 1973, "NY", "123-04-5678");
//    Employee emp2 = new Employee("David", "McWill", 1982, "Seattle", "123-04-5679");
//    Employee emp3 = new Employee("Katerina", "Wise", 1973, "Boston", "123-04-5680");
//    Employee emp4 = new Employee("Donald", "Lee", 1992, "London", "123-04-5681");
//    Employee emp5 = new Employee("Gary", "Henwood", 1987, "Las Vegas", "123-04-5682");
//    Employee emp6 = new Employee("Anthony", "Bright", 1963, "Seattle", "123-04-5683");
//    Employee emp7 = new Employee("William", "Newey", 1995, "Boston", "123-04-5684");
//    Employee emp8 = new Employee("Melony", "Smith", 1970, "Chicago", "123-04-5685");
//
//    Job job1 = new Job("Fuzz", 60, 1, "123-04-5678");
//    Job job2 = new Job("GA", 70, 2, "123-04-5679");
//    Job job3 = new Job("Little Place", 120, 5, "123-04-5680");
//    Job job4 = new Job("Macy's", 78, 3, "123-04-5681");
//    Job job5 = new Job("New Life", 65, 1, "123-04-5682");
//    Job job6 = new Job("Believe", 158, 6, "123-04-5683");
//    Job job7 = new Job("Macy's", 200, 8, "123-04-5684");
//    Job job8 = new Job("Stop", 299, 12, "123-04-5685");
