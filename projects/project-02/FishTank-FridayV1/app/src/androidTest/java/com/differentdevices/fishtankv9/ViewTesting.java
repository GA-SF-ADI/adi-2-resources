package com.differentdevices.fishtankv9;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;



@RunWith(AndroidJUnit4.class)
public class ViewTesting {




        @Rule
        public ActivityTestRule<MainActivity> mainActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void testStuff() throws Exception {
        // test that select category view is visible
        onView(withId(R.id.TextView01))
                .check(matches(isDisplayed()));

        // test that list view of categories is visible
        onView(withId(R.id.list_options))
                .check(matches(isDisplayed()));


        // test that shopping cart button is visible
        onView(withId(R.id.shopping_button))
                .check(matches(isDisplayed()));
    }
}
