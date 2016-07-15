package com.test.snug;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by LangstonSmith on 7/15/16.
 */

@RunWith(AndroidJUnit4.class)

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);



    @Test
    public void testWhetherUIElementsAreVisible() throws Exception {
        // test that answer text view is visible

        onView

    }



}