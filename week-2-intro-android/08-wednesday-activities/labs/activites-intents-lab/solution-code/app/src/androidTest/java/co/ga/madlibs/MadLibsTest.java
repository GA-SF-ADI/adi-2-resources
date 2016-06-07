package co.ga.madlibs;

import android.app.Instrumentation;
import android.os.Bundle;
import android.support.test.InstrumentationRegistry;
import android.test.ActivityInstrumentationTestCase2;
import android.text.TextUtils;
import android.widget.EditText;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
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
        onView(withId(R.id.adjective1_edittext)).check(matches(isDisplayed()));
        onView(withId(R.id.adjective2_edittext)).check(matches(isDisplayed()));
        onView(withId(R.id.noun1_edittext)).check(matches(isDisplayed()));
        onView(withId(R.id.noun2_edittext)).check(matches(isDisplayed()));
        onView(withId(R.id.animals_edittext)).check(matches(isDisplayed()));
        onView(withId(R.id.game_edittext)).check(matches(isDisplayed()));
    }

    public void test01_IfSuccessfullyStartsResultActivity() throws Exception {
        inputWordsSuccessfully();
        onView(withId(R.id.submit_button)).perform(click());

        waitForResultActivity();
    }

    public void test02_IfSendsAllDataToResultsActivity() throws Exception {
        inputWordsSuccessfully();
        onView(withId(R.id.submit_button)).perform(click());

        ResultActivity resultActivity = waitForResultActivity();

        Bundle bundle = resultActivity.getIntent().getExtras();

        assertNotNull("Bundle was not sent to Results Activity", bundle);

        assertNotNull("Adjective 1 not sent to Results Activity", bundle.getString(ResultActivity.ADJECTIVE1));
        assertNotNull("Adjective 2 not sent to Results Activity", bundle.getString(ResultActivity.ADJECTIVE2));
        assertNotNull("Noun 1 not sent to Results Activity", bundle.getString(ResultActivity.NOUN1));
        assertNotNull("Noun 2 not sent to Results Activity", bundle.getString(ResultActivity.NOUN2));
        assertNotNull("Animal not sent to Results Activity", bundle.getString(ResultActivity.ANIMALS));
        assertNotNull("Game not sent to Results Activity", bundle.getString(ResultActivity.GAME));
    }

    public void test02_IfShowingErrors() throws Exception {
        onView(withId(R.id.submit_button)).perform(click());

        assertErrorIsShowing("Adjective 1 editText did not show an error", R.id.adjective1_edittext);
        assertErrorIsShowing("Adjective 2 editText did not show an error", R.id.adjective2_edittext);
        assertErrorIsShowing("Noun 1 editText did not show an error", R.id.noun1_edittext);
        assertErrorIsShowing("Noun 2 editText did not show an error", R.id.noun2_edittext);
        assertErrorIsShowing("Animals editText did not show an error", R.id.animals_edittext);
        assertErrorIsShowing("Game editText did not show an error", R.id.game_edittext);
    }

    // Helper Methods --------------

    private void inputWordsSuccessfully(){
        setText(R.id.adjective1_edittext, "fat");
        setText(R.id.adjective2_edittext, "smelly");
        setText(R.id.noun1_edittext, "building");
        setText(R.id.noun2_edittext, "steak");
        setText(R.id.animals_edittext, "eagles");
        setText(R.id.game_edittext, "Chess");
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