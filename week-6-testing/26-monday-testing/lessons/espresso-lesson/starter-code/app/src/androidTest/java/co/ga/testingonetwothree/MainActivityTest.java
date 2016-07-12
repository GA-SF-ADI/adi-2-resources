package co.ga.testingonetwothree;

import android.app.Activity;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by nolbertoarroyo on 7/11/16.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    private String editText1;
    private String editText2;
    private String answer;


    @Rule
    public ActivityTestRule<MainActivity> mainTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() throws Exception{
        editText1= "100";
        editText2= "200";
        answer = "$300.00";



    }

    @Test
    public void testAddButton()throws Exception{
        //place text into editText1
        onView(withId(R.id.editText1))
                .perform(clearText(), typeText(editText1),closeSoftKeyboard());

        //place text into editText2
        onView(withId(R.id.editText2))
                .perform(clearText(), typeText(editText2),closeSoftKeyboard());

        //press the button
        onView(withId(R.id.addButton))
                .perform(click());

        //verify that answer textview holds $300
        onView(withId(R.id.answerTextView))
                .check(matches(withText(answer)));

    }//As a user, when I add the numbers 123 and 456, then the answer text view should read 789.
    @Test
    public void testAddText()throws Exception{
        editText1 = "123";
        editText2 ="456";
        answer = "789";

        onView(withId(R.id.editText1))
                .perform(clearText(),typeText(editText1),closeSoftKeyboard());

        onView(withId(R.id.editText2))
                .perform(clearText(),typeText(editText2),closeSoftKeyboard());

        onView(withId(R.id.addButton))
                .perform(click());

        onView(withId(R.id.answerTextView))
                .check(matches(withText(answer)));

    }








}
