package co.ga.testingonetwothree;

import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;

/**
 * Created by michaeljeffress on 7/11/16.
 */
public class MainActivityTest {

    private String editText1;
    private String editText2;
    private String answer;

    @Rule
    public ActivityTestRule<MainActivity> mainTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Before
    public void setUp() throws Exception {
        ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);
            editText1 = "100";
            editText2 = "200";
            answer = "$300.00";

    }

    @Test
    public void testAddButton() throws Exception {
        onView(withId(R.id.editText1))
                .perform(clearText(), typeText(editText1), closeSoftKeyboard());

        onView(withId(R.id.editText2))
                .perform(clearText(), typeText(editText2), closeSoftKeyboard());

        onView(withId(R.id.addButton))
                .perform(click());

        onView(withId(R.id.answerTextView))
                .check(matches(withText(answer)));


    }


    @Test
    public void testAnswerText() throws Exception {
        editText1 = "123";
        editText2 = "456";
        answer = "789";



        onView(withId(R.id.editText1))
                .perform(clearText(), typeText(editText1), closeSoftKeyboard());

        onView(withId(R.id.editText2))
                .perform(clearText(), typeText(editText2), closeSoftKeyboard());

        onView(withId(R.id.addButton))
                .perform(click());

        onView(withId(R.id.answerTextView))
                .check(matches(withText(answer)));


    }

    @Test
    public void testEmptyEditText() throws Exception {
        // make sure edit text 1 is empty
        onView(withId(R.id.editText1))
                .perform(clearText());


        // press the button
        onView(withId(R.id.addButton))
                .perform(click());

        // verify that edit text 1 has error text "Missing value!"
        onView(withId(R.id.editText1))
                .check(matches(hasErrorText("Missing value!")));

    }

}
