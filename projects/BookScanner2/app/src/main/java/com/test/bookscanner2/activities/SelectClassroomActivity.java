package com.test.bookscanner2.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.test.bookscanner2.R;
import com.test.bookscanner2.adapters.CustomBaseAdapterSelectClassroom;
import com.test.bookscanner2.modelsClassroom.ClassroomKinderToSecond;

import java.util.ArrayList;

public class SelectClassroomActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 100;

    //    private ArrayList<ClassroomKinder> classroomKinderArrayList;
//    private ArrayList<ClassroomFirst> classroomFirstArrayList;
//    private ArrayList<ClassroomSecond> classroomSecondArrayList;
    private ArrayList<ClassroomKinderToSecond> classroomKinderToSecondArrayList;
    private EditText classroomNameEditText;
    ListView classroomNameListView;
    private Button addClassButton;
    private String userInputString;
    private CheckBox checkBoxK, checkBox1st, checkBox2nd;
    CustomBaseAdapterSelectClassroom customBaseAdapterSelectClassroom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_classroom);

        classroomNameEditText = (EditText) findViewById(R.id.name_classroom_edit_text);
        addClassButton = (Button) findViewById(R.id.add_class_button);
        checkBoxK = (CheckBox) findViewById(R.id.check_box_kinder);
        checkBox1st = (CheckBox) findViewById(R.id.check_box_first);
        checkBox2nd = (CheckBox) findViewById(R.id.check_box_second);
        classroomNameListView = (ListView) findViewById(R.id.classroom_names_listView);

        if (classroomKinderToSecondArrayList == null) {
            classroomKinderToSecondArrayList = new ArrayList<>();
        }

        customBaseAdapterSelectClassroom = new CustomBaseAdapterSelectClassroom(this, classroomKinderToSecondArrayList);
       classroomNameListView.setAdapter(customBaseAdapterSelectClassroom);
        classroomNameEditText = (EditText) findViewById(R.id.name_classroom_edit_text);


        addClassButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                checkBoxK.getText();
//                checkBox1st.getText();
//                checkBox2nd.getText();
                userInputString = classroomNameEditText.getText().toString();
                ClassroomKinderToSecond classroom = new ClassroomKinderToSecond(userInputString,"K");
                classroomKinderToSecondArrayList.add(classroom);
                customBaseAdapterSelectClassroom.notifyDataSetChanged();

                if (checkBoxK.isChecked() && userInputString != null) {
                    userInputString = classroomNameEditText.getText().toString();
                    ClassroomKinderToSecond classroomKinderToSecond = new ClassroomKinderToSecond(userInputString, "K");
                    classroomKinderToSecond.setClassroomName(userInputString);
                    classroomKinderToSecondArrayList.add(classroomKinderToSecond);
                    //customBaseAdapterSelectClassroom.notifyDataSetChanged();
                } else if (checkBox1st.isChecked() && userInputString != null) {
                    userInputString = classroomNameEditText.getText().toString();
                    ClassroomKinderToSecond classroomKinderToSecond = new ClassroomKinderToSecond(userInputString, "1");
                    classroomKinderToSecond.setClassroomName(userInputString);
                    classroomKinderToSecondArrayList.add(classroomKinderToSecond);
                    //customBaseAdapterSelectClassroom.notifyDataSetChanged();
                } else if (checkBox2nd.isChecked() && userInputString != null) {
                    userInputString = classroomNameEditText.getText().toString();
                    ClassroomKinderToSecond classroomKinderToSecond = new ClassroomKinderToSecond(userInputString, "2");
                    classroomKinderToSecond.setClassroomName(userInputString);
                    classroomKinderToSecondArrayList.add(classroomKinderToSecond);
                    //customBaseAdapterSelectClassroom.notifyDataSetChanged();
                } else {
                    Toast.makeText(SelectClassroomActivity.this, "Check only 1 box and give your class a name ", Toast.LENGTH_SHORT).show();
                }
                customBaseAdapterSelectClassroom.notifyDataSetChanged();
            }
        });

        classroomNameListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SelectClassroomActivity.this, CreateStudentActivity.class);
                ClassroomKinderToSecond classroomKinderToSecond = classroomKinderToSecondArrayList.get(position);
                intent.putExtra("position", position);
                intent.putExtra("classroom", classroomKinderToSecond);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        classroomNameListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                classroomKinderToSecondArrayList.remove(position);
                customBaseAdapterSelectClassroom.notifyDataSetChanged();
                return false;
            }
        });
    }

    @Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if (requestCode == REQUEST_CODE) {
        if (resultCode == RESULT_OK) {


            ClassroomKinderToSecond createList = (ClassroomKinderToSecond) data.getSerializableExtra("classroom");


            int pos = data.getIntExtra("position", 0);

            Toast.makeText(SelectClassroomActivity.this, "Welcome Back :) ", Toast.LENGTH_SHORT).show();


            classroomKinderToSecondArrayList.set(pos, createList);
            customBaseAdapterSelectClassroom.notifyDataSetChanged();
        }

    }


}
}




