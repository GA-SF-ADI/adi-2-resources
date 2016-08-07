package com.test.bookscanner2.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.test.bookscanner2.R;
import com.test.bookscanner2.modelsClassroom.Classroom;
import com.test.bookscanner2.modelsClassroom.Student;

public class CreateClassroomActivity extends AppCompatActivity {
    public static final int ADD_STUDENT = 10;

    public static final String REQUEST_CODE = "requestCode";

    ArrayAdapter<Student> mAdapter;
    Button addStudentButton;
    ListView studentListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_classroom);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        addStudentButton = (Button) findViewById(R.id.add_student_button);
        mAdapter = new ArrayAdapter<Student>(CreateClassroomActivity.this, android.R.layout.simple_list_item_1, Classroom.getInstance().getStudents());
        studentListView.setAdapter(mAdapter);

        addStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateClassroomActivity.this, CreateStudentActivity.class);
                intent.putExtra(REQUEST_CODE, ADD_STUDENT);
                startActivityForResult(intent, ADD_STUDENT);
            }

        });

        studentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(CreateClassroomActivity.this, Classroom.getInstance().getStudents().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });

        //IF YOU WANT TO REMOVE ITEM
//        mAnimalListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                Zoo.getInstance().getAnimals().remove(position);
//                mAdapter.notifyDataSetChanged();
//                return false;
//            }
//        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            Student createdNewStudent = (Student) data.getSerializableExtra(CreateStudentActivity.STUDENT_SERIALIZABLE_KEY);
            Classroom.getInstance().addStudent(createdNewStudent);
            mAdapter.notifyDataSetChanged();
        }
    }
}

