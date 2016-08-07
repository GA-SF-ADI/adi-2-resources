package com.test.bookscanner2.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.test.bookscanner2.R;
import com.test.bookscanner2.modelsClassroom.Student;

public class CreateStudentActivity extends AppCompatActivity {
    public static final String STUDENT_SERIALIZABLE_KEY = "studentSerializableKey";
    private Button addNewStudentButton;
    private EditText studentNameEditText;
    private int mRequestCode;
    protected Student student;
    String studentName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_student);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRequestCode = getIntent().getIntExtra(CreateClassroomActivity.REQUEST_CODE,-1);
        studentNameEditText = (EditText) findViewById(R.id.student_name_edit_text);
        addNewStudentButton = (Button) findViewById(R.id.create_student_button);
        addNewStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                if(mRequestCode == CreateClassroomActivity.ADD_STUDENT){

                    student = new Student(studentNameEditText.getText().toString());
                    studentName = student.toString();
                    //String studentName = student.setName(studentNameEditText.getText().toString());
                    intent.putExtra(STUDENT_SERIALIZABLE_KEY, student);

                } else {
                    Toast.makeText(CreateStudentActivity.this, "Enter a new name",Toast.LENGTH_LONG).show();
                }
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        if(mRequestCode == CreateClassroomActivity.ADD_STUDENT) {
            //studentNameEditText.setText(studentNameEditText.getText().toString());
            studentNameEditText.setText(studentName);
        }

    }

}
