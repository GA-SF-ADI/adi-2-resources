package com.test.snug;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by LangstonSmith on 7/15/16.
 */

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.swipeUp;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasFocus;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);


    @Test
    public void testWhetherUIElementsAreVisible() throws Exception {


        onView(withId(R.id.main_activity_toolbar))
                .check(matches(isDisplayed()));

        onView(withId(R.id.button_item_in_main_activity_toolbar_to_view_cart))
                .check(matches(isDisplayed()));

        onView(withId(R.id.app_logo_in_main_activity_toolbar))
                .check(matches(isDisplayed()));

        onView(withId(R.id.searchview_item_in_main_activity_menu))
                .check(matches(isDisplayed()));

        onView(withId(R.id.card_view))
                .check(matches(isDisplayed()));


    }

    @Test
    public void checkToSeeWhetherRecyclerViewerWorks() throws Exception {

        onView(withId(R.id.mainactivity_hat_recyclerview))
                .perform(swipeUp());


        onView(withId(R.id.mainactivity_hat_recyclerview))
                .check(matches(isDisplayed()));

    }


    @Test
    public void seeIfSearchViewOpens() throws Exception {

        onView(withId(R.id.searchview_item_in_main_activity_menu))
                .perform(click());

        onView(withId(R.id.searchview_item_in_main_activity_menu))
                .check(matches(hasFocus()));

    }


}