package com.test.snug;

/**
 * Created by LangstonSmith on 7/15/16.
 */


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
public class SingleHatViewActivityTest {

    @Rule
    public ActivityTestRule<SingleHatViewActivity> singleHatViewActivityTestRule = new ActivityTestRule<SingleHatViewActivity>(SingleHatViewActivity.class);

    @Test
    public void testWhetherUIElementsAreVisible() throws Exception {
        // test that answer text view is visible

        onView(withId(R.id.textView_hat_name))
                .check(matches(isDisplayed()));
    }

}
