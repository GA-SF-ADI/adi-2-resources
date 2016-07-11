package ly.generalassemb.espresso;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * James Davis (General Assembly NYC)
 * Created on 4/25/16.
 */

@RunWith(AndroidJUnit4.class)
public class BalanceActivityTest {
    @Rule
    public ActivityTestRule<BalanceActivity> mActivityRule = new ActivityTestRule<BalanceActivity>(BalanceActivity.class);

    @Test
    public void testIfBalanceIsVisible() throws Exception {
        onView(withId(R.id.balanceTextView))
                .check(matches(isDisplayed()));
    }

    /**
     *  At the end of this test, check if the the balance textview reflects the changes
     */
    @Test
    public void testWithdraw() throws Exception {
        String expectedBalance = "-$592.36";

        withdrawAmount(592.36f);

        // back on the balance activity
        onView(withId(R.id.balanceTextView))
                .check(matches(withText(expectedBalance)));
    }

    /**
     *  At the end of this test, check if the the balance textview reflects the changes
     */
    @Test
    public void testMultipleWithdrawals() throws Exception {
        String expectedBalance = "-$592.36";

        withdrawAmount(592.36f);

        // back on the balance activity
        onView(withId(R.id.balanceTextView))
                .check(matches(withText(expectedBalance)));

        expectedBalance = "-$622.36";
        withdrawAmount(30f);

        // back on the balance activity
        onView(withId(R.id.balanceTextView))
                .check(matches(withText(expectedBalance)));

        expectedBalance = "-$854.91";
        withdrawAmount(232.55f);

        // back on the balance activity
        onView(withId(R.id.balanceTextView))
                .check(matches(withText(expectedBalance)));
    }

    /**
     *  At the end of this test, check if the the balance textview reflects the changes
     */
    @Test
    public void testDeposit() throws Exception {
        String expectedBalance = "$399.21";

        depositAmount(399.21f);

        // back on the balance activity
        onView(withId(R.id.balanceTextView))
                .check(matches(withText(expectedBalance)));
    }

    /**
     *  At the end of this test, check if the the balance textview reflects the changes
     */
    @Test
    public void testMultipleDeposits() throws Exception {
        String expectedBalance = "$399.21";

        depositAmount(399.21f);

        // back on the balance activity
        onView(withId(R.id.balanceTextView))
                .check(matches(withText(expectedBalance)));

        expectedBalance = "$400.21";
        depositAmount(1f);

        // back on the balance activity
        onView(withId(R.id.balanceTextView))
                .check(matches(withText(expectedBalance)));

        expectedBalance = "$486.50";
        depositAmount(86.29f);

        // back on the balance activity
        onView(withId(R.id.balanceTextView))
                .check(matches(withText(expectedBalance)));
    }

    // ======================================================== METHODS TO HELP WITHDRAW AND DEPOSIT

    private void withdrawAmount(float floatAmount){
        String amount = String.valueOf(floatAmount);

        onView(withId(R.id.newTransactionButton)).perform(click());

        // on the New Transaction screen
        onView(withId(R.id.descriptionEditText))
                .perform(typeText("This is a test if the withdrawal feature works"));

        onView(withId(R.id.amountEditText))
                .perform(typeText(amount));

        onView(withId(R.id.withdrawButton))
                .perform(click());
    }

    private void depositAmount(float floatAmount){
        String amount = String.valueOf(floatAmount);

        onView(withId(R.id.newTransactionButton)).perform(click());

        // on the New Transaction screen
        onView(withId(R.id.descriptionEditText))
                .perform(typeText("This is a test if the withdrawal feature works"));

        onView(withId(R.id.amountEditText))
                .perform(typeText(amount));

        onView(withId(R.id.depositButton))
                .perform(click());
    }
}
