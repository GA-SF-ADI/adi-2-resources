package com.test.snug;

/**
 * Created by LangstonSmith on 7/17/16.
 */

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

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


public class ShoppingCartTest {


    @Rule
    public ActivityTestRule<ShoppingCartActivity> shoppingCartActivityTestRule = new ActivityTestRule<ShoppingCartActivity>(ShoppingCartActivity.class);


    @Test
    public void testWhetherUIElementsAreVisible() throws Exception {

        onView(withId(R.id.shopping_activity_toolbar))
                .check(matches(isDisplayed()));

        onView(withId(R.id.textView_in_cart_saying_your_cart))
                .check(matches(isDisplayed()));

        onView(withId(R.id.fab_make_final_payment))
                .check(matches(isDisplayed()));

        onView(withId(R.id.listview_of_cart_items))
                .check(matches(isDisplayed()));
    }

    @Test
    public void checkToSeeIfListViewIsSwipable() throws Exception {

        onView(withId(R.id.listview_of_cart_items))
                .check(matches(isDisplayed()));

        onView(withId(R.id.listview_of_cart_items))
                .perform(swipeUp());

        onView(withId(R.id.mainactivity_hat_recyclerview))
                .check(matches(isDisplayed()));

    }


}
