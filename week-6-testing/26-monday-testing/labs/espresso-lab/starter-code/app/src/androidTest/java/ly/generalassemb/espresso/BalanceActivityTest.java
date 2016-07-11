package ly.generalassemb.espresso;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by patrickcummins on 7/11/16.
 */
@RunWith(AndroidJUnit4.class)
public class BalanceActivityTest {


    @Rule
    public ActivityTestRule<BalanceActivity> balanceActivityActivityTestRule = new ActivityTestRule<BalanceActivity>(BalanceActivity.class);

    @Test
    public void testCanViewCurrentBalance() throws Exception {
        onView(withId(R.id.balanceTextView)).check(matches(isDisplayed()));
        
    }

    @Test
    public void deposit() throws Exception {
        onView(withId(R.id.newTransactionButton)).perform(click());
        onView(withId(R.id.descriptionEditText)).perform(typeText("DepositingMoney"));
        onView(withId(R.id.amountEditText)).perform(typeText("100"));
        onView(withId(R.id.depositButton)).perform(click());
        onView(withId(R.id.balanceTextView)).check(matches(withText("$100.00")));

    }
    @Test
    public void withdraw() throws Exception {
        onView(withId(R.id.newTransactionButton)).perform(click());
        onView(withId(R.id.descriptionEditText)).perform(typeText("WithdrawingMoney"));
        onView(withId(R.id.amountEditText)).perform(typeText("50"));
        onView(withId(R.id.withdrawButton)).perform(click());
        onView(withId(R.id.balanceTextView)).check(matches(withText("-$50.00")));

    }
    @Test
    public void multipleDepositsAndWithdraws() throws Exception {
        onView(withId(R.id.newTransactionButton)).perform(click());
        onView(withId(R.id.descriptionEditText)).perform(typeText("DepositingMoney"));
        onView(withId(R.id.amountEditText)).perform(typeText("100"));
        onView(withId(R.id.depositButton)).perform(click());
        onView(withId(R.id.newTransactionButton)).perform(click());
        onView(withId(R.id.descriptionEditText)).perform(typeText("WithdrawingMoney"));
        onView(withId(R.id.amountEditText)).perform(typeText("50"));
        onView(withId(R.id.withdrawButton)).perform(click());
        onView(withId(R.id.newTransactionButton)).perform(click());
        onView(withId(R.id.descriptionEditText)).perform(typeText("DepositingMoney"));
        onView(withId(R.id.amountEditText)).perform(typeText("100"));
        onView(withId(R.id.depositButton)).perform(click());
        onView(withId(R.id.newTransactionButton)).perform(click());
        onView(withId(R.id.descriptionEditText)).perform(typeText("WithdrawingMoney"));
        onView(withId(R.id.amountEditText)).perform(typeText("50"));
        onView(withId(R.id.withdrawButton)).perform(click());


    }

}
