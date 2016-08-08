package com.test.bookscanner2.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ListView;

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
    private int position;
    CustomBaseAdapterSelectClassroom customBaseAdapterSelectClassroom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_classroom);

        if (classroomKinderToSecondArrayList == null) {
            classroomKinderToSecondArrayList = new ArrayList<>();
        }

        final ListView listView = (ListView) findViewById(R.id.classroom_names_listView);
        customBaseAdapterSelectClassroom = new CustomBaseAdapterSelectClassroom(classroomKinderToSecondArrayList, this);
        listView.setAdapter(customBaseAdapterSelectClassroom);
        classroomNameEditText = (EditText) findViewById(R.id.name_classroom_edit_text);

        // create button to add new classroom to either Kinder, First, or Second
        //create a checkbox to tell if it is Kinder, First, or Second

    }
}
