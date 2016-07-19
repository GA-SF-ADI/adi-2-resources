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
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * James Davis (Impactable)
 * Created on 3/28/16.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    /**
     * As a user, I can see the answer text view,
     * two edit texts, and an Add button
     *
     * @throws Exception
     */
    @Test
    public void testUIElementsVisible() throws Exception {
        // test that answer text view is visible
        onView(withId(R.id.answerTextView))
                .check(matches(isDisplayed()));

        // test that edit text 1 is visible
        onView(withId(R.id.editText1))
                .check(matches(isDisplayed()));

        // test that edit text 2 is visible
        onView(withId(R.id.editText2))
                .check(matches(isDisplayed()));

        // test that add button is visible
        onView(withId(R.id.addButton))
                .check(matches(isDisplayed()));
    }


    /**
     * As a user, when I add the numbers 5.23 and 12.01
     * the total should be $17.24
     *
     * @throws Exception
     */
    @Test
    public void testIfAddWorks() throws Exception {
        String value1 = "5.23";
        String value2 = "12.01";

        String expectedAnswer = "$17.24";

        onView(withId(R.id.editText1)).perform(clearText(), typeText(value1), closeSoftKeyboard());
        onView(withId(R.id.editText2)).perform(clearText(), typeText(value2), closeSoftKeyboard());

        onView(withId(R.id.addButton)).perform(click());

        onView(withId(R.id.answerTextView)).check(matches(withText(expectedAnswer)));
    }
}
