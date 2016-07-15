package ly.generalassemb.espresso;

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
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)

public class MainActivityTesting {

    private String editText1;
    private String editText2;

    private String answer;

    @Rule
    public ActivityTestRule<MainActivity> mainTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Before
    public void setUp() throws Exception {
        editText1 = "100";
        editText2 = "200";
        answer = "$300.00";
    }

    @Test
    public void testAddButton() throws Exception {
        //place text into editText1
        onView(withId(R.id.editText1))
                .perform(clearText(), typeText(editText1), closeSoftKeyboard());
        //place text into editText2
        onView(withId(R.id.editText2))
                .perform(clearText(), typeText(editText2), closeSoftKeyboard());
        //press the button
        onView(withId(R.id.addButton))
                .perform(click());
        //verify that answer textview holds $300.00
        onView(withId(R.id.answerTextView))
                .check(matches(withText(answer)));
    }

    @Test
    public void testAddButtonFail() throws Exception {
        editText1 = "123";
        editText2 = "456";
        answer = "$789.00";

        //place text into editText1
        onView(withId(R.id.editText1))
                .perform(clearText(), typeText(editText1), closeSoftKeyboard());
        //place text into editText2
        onView(withId(R.id.editText2))
                .perform(clearText(), typeText(editText2), closeSoftKeyboard());
        //press the button
        onView(withId(R.id.addButton))
                .perform(click());
        //verify that answer textview holds $789.00
        onView(withId(R.id.answerTextView))
                .check(matches(withText(answer)));
    }

    @Test
    public void testErrorMsg() throws Exception {
        onView(withId(R.id.editText1))
                .perform(clearText());
        onView(withId(R.id.editText2))
                .perform(clearText());
        onView(withId(R.id.addButton))
                .perform(click());
        onView(withId(R.id.editText1))
                .check(matches(hasErrorText("Missing value!")));
    }
}