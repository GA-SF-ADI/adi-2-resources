package ly.generalassemb.firebaserealtimedatabaseexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Iterator;

import ly.generalassemb.firebaserealtimedatabaseexample.model.Classroom;
import ly.generalassemb.firebaserealtimedatabaseexample.model.Student;

public class MainActivity extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();
    private FirebaseDatabase firebaseDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get instance of database singleton
        firebaseDatabase = FirebaseDatabase.getInstance();

        // Demo: Simple string
        addMessage();

        // Demo: Add custom objects
        addUsers();

        // Demo: Custom objects with ArrayList of objects inside
        addClass();

    }


    /**
     * Add simpel String
     */
    private void addMessage(){
        DatabaseReference msgRef = firebaseDatabase.getReference("message");

        // Write to the database's category of "message"
        msgRef.setValue("Hello world!");

        msgRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // DataSnapshot.getValue() is cast to String class and returned to us with updated value
                String updatedMessage = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Updated message is: " + updatedMessage);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    /**
     * Adding Custom object "Student"
     */
    private void addUsers(){
        // Look for category "student", if it doesn't exist it will be created when we add something to it
        DatabaseReference chatRef = firebaseDatabase.getReference("student");

        // Student is a custom class that holds an array of Strings representing messages in the student
        Student student = new Student("Ellen", "Johnson");


        // Write to the database's category of "student"
        chatRef.setValue(student);

        chatRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // DataSnapshot.getValue() will be cast to Student class! Since that is our data
                Student updatedStudent = dataSnapshot.getValue(Student.class);

                Log.d(TAG, "Updated student info");
                Log.d(TAG, "\tname: " + updatedStudent.getName());
                Log.d(TAG, "\tlast name: " + updatedStudent.getLastName());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    /**
     * Example of Adding custom object that holds children
     */
    private void addClass(){
        DatabaseReference classRef = firebaseDatabase.getReference("classroom");

        // Create Classroom, Students and add them to the classroom
        Classroom classroom = new Classroom();
        classroom.addStudent(new Student("John", "Doe"));
        classroom.addStudent(new Student("Ellen", "Smith"));
        classroom.addStudent(new Student("Christina", "Johnson"));

        // Write classroom to DB. We start with an empty classroom
        classRef.setValue(classroom);

        /**
         * Child event listener for "classroom" category will Listen for when the
         * ArrayList<Student> students changes!
         *
         * That means the whole list is returned, not an individual item.
         */
        classRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Log.i(TAG, "onChildAdded: ");

                // Grab the children from Snapshot. Because children is ArrayList<Student> we have to use an iterator
                Iterator<DataSnapshot> it = dataSnapshot.getChildren().iterator();
                printStudents(it, "\tAdded Students");
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Log.i(TAG, "onChildChanged: ");

                Iterator<DataSnapshot> it = dataSnapshot.getChildren().iterator();
                printStudents(it, "Updated Students");
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Log.i(TAG, "onChildRemoved: ");

                Iterator<DataSnapshot> it = dataSnapshot.getChildren().iterator();
                printStudents(it, "Removed Students");
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                Log.i(TAG, "onChildMoved: ");

                Iterator<DataSnapshot> it = dataSnapshot.getChildren().iterator();
                printStudents(it, "Moved Students");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.i(TAG, "onCancelled: " + databaseError.toException());
            }
        });

        /**
         * classRef.child("students") gives us category "students" inside the "classroom" category,
         * which means that when a change is made we get each updated student individually.
         *
         * "students" is the ArrayList<Student> students which is why we do child("students").
         */
        classRef.child("students").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Log.i(TAG, "Single Student - onChildAdded");

                Student newStudent = dataSnapshot.getValue(Student.class);
                printStudent("\tAdded student", newStudent);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Log.i(TAG, "Single Student - onChildChanged");

                Student changedStudent = dataSnapshot.getValue(Student.class);
                printStudent("\tUpdated student", changedStudent);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Log.i(TAG, "Single Student - onChildRemoved");

                Student removedStudent = dataSnapshot.getValue(Student.class);
                printStudent("\tRemoved student", removedStudent);
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                Log.i(TAG, "Single Student - onChildMoved");

                Student movedStudent = dataSnapshot.getValue(Student.class);
                printStudent("\tMoved student", movedStudent);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.i(TAG, "onCancelled: " + databaseError.toException());
            }
        });
    }

    /**
     * Prints all students in the iterator
     * @param it
     * @param title
     */
    private void printStudents(Iterator<DataSnapshot> it, String title){
        while (it.hasNext()){
            DataSnapshot snapshot = it.next();
            Student newStudent = snapshot.getValue(Student.class);
            printStudent(title, newStudent);
        }
    }

    /**
     * Prints a single Student
     * @param updateType
     * @param student
     */
    private void printStudent(String updateType, Student student){
        Log.i(TAG, updateType);
        Log.i(TAG, "\t\tname: " + student.getName());
        Log.i(TAG, "\t\tlast name: " + student.getLastName());
    }
}
