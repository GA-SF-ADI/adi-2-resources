package gg.patrickcummins.myapplication;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.MediumTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
/**
 * Created by patrickcummins on 7/14/16.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTests {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void goFromMainToJersey() throws Exception {
        onView(withId(R.id.warriorsImageView)).perform(click());
        onView(withId(R.id.playersListView)).perform(click());


    }
    @Test
    public void addJerseyToCart() throws Exception {
        onView(withId(R.id.warriorsImageView)).perform(click());
        onView(withId(R.id.playersListView)).perform(click());
        onView(withId(R.id.extraLargeTextView)).perform(click());
        onView(withId(R.id.quantityEditText)).perform(typeText("1"));
        onView(withId(R.id.quantityEditText)).perform(closeSoftKeyboard());
        onView(withId(R.id.addToCartButton)).perform(click());
    }
    @Test
    public void viewCart() throws Exception{
        onView(withId(R.id.cartFab)).perform(click());
    }
    @Test
    public void checkoutCart() throws Exception{
        addJerseyToCart();
        onView(withId(R.id.cartFab)).perform(click());
        onView(withId(R.id.checkoutButton)).perform(click());
    }
    
}
