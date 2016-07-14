package com.test.project2navigationdrawer;

/**
 * Created by audreyeso on 7/13/16.
 */

import android.app.Activity;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;



class HomeButtonTest extends ActivityInstrumentationTestCase2<SecondActivity>{

    public HomeButtonTest(Class<SecondActivity> activityClass, ActivityTestRule<SecondActivity> homeButtonTestActivityTestRule) {
        super(activityClass);
        this.homeButtonTestActivityTestRule = homeButtonTestActivityTestRule;
    }

    protected void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    @Rule
    public ActivityTestRule<SecondActivity> homeButtonTestActivityTestRule = new ActivityTestRule<SecondActivity>(SecondActivity.class);

    @Test
    public void testIfHomeButtonWorks() {

        onView(withId(R.id.home_button)).perform(click());
        onView(withId(R.id.main_text)).check(matches(withText("hi")));
    }




}
