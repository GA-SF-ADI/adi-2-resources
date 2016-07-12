package co.ga.testingonetwothree;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

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
 * James Davis (General Assembly NYC)
 * Created on 4/25/16.
 */

@RunWith(AndroidJUnit4.class)
public class EspressoExampleTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testSomething() throws Exception {
       // TODO: Write a test
    }





    @Test
    public void testAddButton() throws Exception {
        onView(withId(R.id.editText1))
                .perform(clearText(), typeText("5"), closeSoftKeyboard());

        onView(withId(R.id.editText2))
                .perform(clearText(), typeText("7"), closeSoftKeyboard());

        onView(withId(R.id.addButton))
                .perform(click());

        onView(withId(R.id.answerTextView))
                .check(matches(withText("$12.00")));

    }
}
