package co.ga.madlibs;

import android.app.Instrumentation;
import android.os.Bundle;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.action.ViewActions;
import android.test.ActivityInstrumentationTestCase2;
import android.text.TextUtils;
import android.widget.EditText;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class MadLibsTest extends ActivityInstrumentationTestCase2<MainActivity> {

    MainActivity mActivity;
    Instrumentation.ActivityMonitor mActivityMonitor;

    public MadLibsTest() {
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        mActivity = getActivity();
        mActivityMonitor = getInstrumentation().addMonitor(ResultActivity.class.getName(), null, false);
    }

    public void test00_IfHasAllRequiredViews() throws Exception {
        onView(withId(R.id.input_edittext)).check(matches(isDisplayed()));
        onView(withId(R.id.submit_button)).check(matches(isDisplayed()));
    }

    public void test01_IfSuccessfullyStartsResultActivity() throws Exception {
        inputWordsSuccessfully();
        closeSoftKeyboard();
        onView(withId(R.id.submit_button)).perform(scrollTo(), click());

        waitForResultActivity();
    }

    public void test02_IfSendsAllDataToResultsActivity() throws Exception {
        inputWordsSuccessfully();
        closeSoftKeyboard();
        onView(withId(R.id.submit_button)).perform(scrollTo(),click());

        ResultActivity resultActivity = waitForResultActivity();

        String[] words = resultActivity.getIntent().getStringArrayExtra("WORDS");

        assertEquals(6, words.length);

        assertNotNull("Adjective 1 not sent to Results Activity", words[0]);
        assertNotNull("Adjective 2 not sent to Results Activity", words[1]);
        assertNotNull("Noun 1 not sent to Results Activity", words[2]);
        assertNotNull("Noun 2 not sent to Results Activity", words[3]);
        assertNotNull("Animal not sent to Results Activity", words[4]);
        assertNotNull("Game not sent to Results Activity", words[5]);
    }

    public void test02_IfShowingErrors() throws Exception {
        onView(withId(R.id.submit_button)).perform(scrollTo(), click());
        assertErrorIsShowing("EditText did not show an error", R.id.input_edittext);
    }

    public void test03_IfShowingErrors() throws Exception {
        setText(R.id.input_edittext, "blue,,,hill,horses,catch");
        closeSoftKeyboard();
        onView(withId(R.id.submit_button)).perform(scrollTo(), click());
        assertErrorIsShowing("EditText did not show an error", R.id.input_edittext);
    }

    // Helper Methods --------------

    private void inputWordsSuccessfully(){
        setText(R.id.input_edittext, "blue,happy,lake,hill,horses,catch");
    }

    private void setText(int id, String text){
        onView(withId(id)).perform(clearText(), typeText(text));
    }

    private void assertErrorIsShowing(String message, int id) {
        EditText editText = (EditText) mActivity.findViewById(id);
        String errorMessage = editText.getError().toString();

        assertFalse(message, TextUtils.isEmpty(errorMessage));
    }

    private ResultActivity waitForResultActivity(){
        ResultActivity resultActivity = (ResultActivity) getInstrumentation().waitForMonitorWithTimeout(mActivityMonitor, 5000);
        assertNotNull("The result activity did not start, or took too long to start.", resultActivity);
        return resultActivity;
    }
}