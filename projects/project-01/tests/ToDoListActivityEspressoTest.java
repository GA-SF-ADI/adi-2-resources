package drewmahrt.generalassemb.ly.project_01;

import android.app.Application;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ApplicationTestCase;
import android.support.test.InstrumentationRegistry;

import org.hamcrest.FeatureMatcher;
import org.junit.Before;

import java.util.Map;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

/**
 * Created by Drew on 11/24/15.
 */
public class ToDoListActivityEspressoTest extends ActivityInstrumentationTestCase2<ToDoListActivity>{
    private ToDoListActivity mActivity;

    public ToDoListActivityEspressoTest() {
        super(ToDoListActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        mActivity = getActivity();
    }

    public void testNewItemButtonClick(){
        //Click the new item button
        onView(withId(R.id.fab_new_item)).perform(click());
        //Type "Test item 1" into the text box
        onView(withId(R.id.title_text)).perform(typeText("Test item 1"));
        //Click Done
        onView(withId(android.R.id.button1)).perform(click());
        //Check that the to do lists contains a list with the title "Test List 1"
        onData(allOf(is(instanceOf(String.class)), hasToString(containsString("Test item 1")))).check(matches(withText("Test item 1")));

        //Repeat test with another item
        onView(withId(R.id.fab_new_item)).perform(click());
        onView(withId(R.id.title_text)).perform(typeText("Test item 2"));
        onView(withId(android.R.id.button1)).perform(click());
        onData(allOf(is(instanceOf(String.class)), hasToString(containsString("Test item 2")))).check(matches(withText("Test item 2")));
    }
}
