package com.example.jeanweatherwax.studentnames;

/**
 * Created by jeanweatherwax on 7/5/16.
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class StudentTest {
    @Test
    public void testIfFullNameIsCorrect() {
        Student student = new Student("Leslie", "Knope", 93);

        String expected = "Leslie Knope";
        String actual = student.getFullName();

        assertEquals(expected, actual);
    }

    @Test
    public void testIfLetterGradeIsCorrect() {
        Student student = new Student("Charlie", "Brown", 76);

        String expected = "C";
        String actual = student.getLetterGrade();

        assertEquals(expected, actual);
    }
}

