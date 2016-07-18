package com.test.snug;

/**
 * Created by LangstonSmith on 7/15/16.
 */


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class SingleHatViewActivityTest {

    @Rule
    public ActivityTestRule<SingleHatViewActivity> singleHatViewActivityTestRule = new ActivityTestRule<SingleHatViewActivity>(SingleHatViewActivity.class);

    @Test
    public void testWhetherUIElementsAreVisible() throws Exception {

        onView(withId(R.id.app_logo_in_single_hat_view_activity_toolbar))
                .check(matches(isDisplayed()));

        onView(withId(R.id.button_item_in_single_hat_view_activity_toolbar_to_view_cart))
                .check(matches(isDisplayed()));

        onView(withId(R.id.app_logo_in_single_hat_view_activity_toolbar))
                .check(matches(isDisplayed()));

        onView(withId(R.id.imageview_single_hat))
                .check(matches(isDisplayed()));

        onView(withId(R.id.textView_single_hat_price))
                .check(matches(isDisplayed()));

        onView(withId(R.id.textView_single_hat_title))
                .check(matches(isDisplayed()));

        onView(withId(R.id.textview_single_hat_static_description_with_colon))
                .check(matches(isDisplayed()));

        onView(withId(R.id.textview_single_hat_static_back))
                .check(matches(isDisplayed()));

        onView(withId(R.id.textview_single_hat_static_material_with_colon))
                .check(matches(isDisplayed()));


        onView(withId(R.id.fab_to_add_hat_to_cart))
                .check(matches(isDisplayed()));


    }


}