package co.ga.testingonetwothree;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * James Davis (General Assembly NYC)
 * Created on 4/25/16.
 */

@RunWith(AndroidJUnit4.class)
public class EspressoExampleTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testSomething() throws Exception {
       // TODO: Write a test
    }
}
