package com.test.relationshipslab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Employee emp1 = new Employee("John", "Smith", 1973, "NY", "123-04-5687");
        Employee emp2 = new Employee("David", "Smith", 1973, "NY", "123-04-5687");
        Employee emp3 = new Employee("Katerina", "Smith", 1973, "NY", "123-04-5687");
        Employee emp4 = new Employee("Donald", "Smith", 1973, "NY", "123-04-5687");
        Employee emp5 = new Employee("Gary", "Smith", 1973, "NY", "123-04-5687");
        Employee emp6 = new Employee("Anthony", "Smith", 1973, "NY", "123-04-5687");
        Employee emp7 = new Employee("William", "Smith", 1973, "NY", "123-04-5687");
        Employee emp8 = new Employee("Melony", "Smith", 1973, "NY", "123-04-5687");




    }
}
