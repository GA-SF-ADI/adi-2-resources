package ly.generalassemb.espresso;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.typeText;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Jon Kim on 7/11/16.
 */
@RunWith(AndroidJUnit4.class)
public class BalanceScreenTest {
    String myNum1, myNum2;
    String balance, description, balance1;

    @Rule
    public ActivityTestRule<BalanceActivity> mBalanceActivityRule = new ActivityTestRule<BalanceActivity>(BalanceActivity.class);

    @Before
    public void setUp() throws Exception {
        myNum1 = "300";
        myNum2 = "200";
        balance = "$100.00";
        balance1 = "$300.00";
        description = "Party";
    }

    //viewing current deposit
    @Test
    public void testViewDeposit() throws Exception {
        onView(withId(R.id.balanceTextView))
                .check(matches(isDisplayed()));
    }
    //checking if able to deposit money correctly
    @Test
    public void testDeposit() throws Exception {
        onView(withId(R.id.newTransactionButton))
                .perform(click());

        onView(withId(R.id.descriptionEditText))
                .perform(clearText(),typeText(description));

        onView(withId(R.id.amountEditText))
                .perform(clearText(),typeText(myNum1));

        onView(withId(R.id.depositButton))
                .perform(click());

        onView(withId(R.id.balanceTextView))
                .check(matches(withText(balance1)));

    }
    //checking if withdrawing money and doing multiple transactions work correctly
    @Test
    public void testBalance() throws Exception {
        onView(withId(R.id.newTransactionButton))
                .perform(click());

        onView(withId(R.id.descriptionEditText))
                .perform(clearText(),typeText(description));

        onView(withId(R.id.amountEditText))
                .perform(clearText(),typeText(myNum1));

        onView(withId(R.id.depositButton))
                .perform(click());



        onView(withId(R.id.newTransactionButton))
                .perform(click());

        onView(withId(R.id.descriptionEditText))
                .perform(clearText(),typeText(description));

        onView(withId(R.id.amountEditText))
                .perform(clearText(),typeText(myNum2));

        onView(withId(R.id.withdrawButton))
                .perform(click());

        onView(withId(R.id.balanceTextView))
                .check(matches(withText(balance)));

    }
}
