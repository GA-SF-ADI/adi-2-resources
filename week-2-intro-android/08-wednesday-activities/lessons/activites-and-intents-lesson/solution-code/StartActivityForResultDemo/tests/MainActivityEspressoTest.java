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

public class MainActivityEspressoTest extends ActivityInstrumentationTestCase2<MainActivity> {
    private MainActivity mActivity;

    public MainActivityEspressoTest() {
        super(MainActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        mActivity = getActivity();
    }

    public void testNewListButtonClick(){
        //Click the new list button
        onView(withId(R.id.fab_new_list)).perform(click());
        //Type "Test list 1" into the text box
        onView(withId(R.id.title_text)).perform(typeText("Test list 1"));
        //Click Done
        onView(withId(android.R.id.button1)).perform(click());
        //Press the back button to return to the to-do lists screen
        pressBack();
        //Check that the to do lists contains a list with the title "Test List 1"
        onData(allOf(is(instanceOf(ToDoList.class)), hasToString(containsString("Test list 1")))).check(matches(withText("Test list 1")));

        //Repeat test with another list
        onView(withId(R.id.fab_new_list)).perform(click());
        onView(withId(R.id.title_text)).perform(typeText("Test list 2"));
        onView(withId(android.R.id.button1)).perform(click());
        pressBack();
        onData(allOf(is(instanceOf(ToDoList.class)), hasToString(containsString("Test list 2")))).check(matches(withText("Test list 2")));
    }

    public void testListIsSaved(){
        //Click the new list button
        onView(withId(R.id.fab_new_list)).perform(click());
        //Type "Test list 1" into the text box
        onView(withId(R.id.title_text)).perform(typeText("Test list 1"));
        //Click Done
        onView(withId(android.R.id.button1)).perform(click());

        //Add new item to the list
        onView(withId(R.id.fab_new_item)).perform(click());
        onView(withId(R.id.title_text)).perform(typeText("Test item 1"));
        onView(withId(android.R.id.button1)).perform(click());

        //Press the back button to return to the to-do lists screen
        pressBack();
        //return to list 1
        onData(allOf(is(instanceOf(ToDoList.class)), hasToString(containsString("Test list 1")))).perform(click());
        //Check that the to do lists contains an item with the title "Test item 1"
        onData(allOf(is(instanceOf(String.class)), hasToString(containsString("Test item 1")))).check(matches(withText("Test item 1")));
    }
}