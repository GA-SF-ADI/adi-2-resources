package ly.generalassemb.espresso;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.BaseAdapter;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by kitty on 7/11/16.
 */
@RunWith(AndroidJUnit4.class)

public class ATMTest {

    @Rule
    public ActivityTestRule<BalanceActivity> mainTestRule = new ActivityTestRule<>(BalanceActivity.class);

    @Before
    public void setUp() throws Exception {
        // withdraw
        onView(withId(R.id.newTransactionButton))
                .perform(click());
        onView(withId(R.id.descriptionEditText))
                .perform(clearText(), typeText("Shopping"), closeSoftKeyboard());
        onView(withId(R.id.amountEditText))
                .perform(clearText(), typeText("200"), closeSoftKeyboard());
        onView(withId(R.id.withdrawButton))
                .perform(click());

        //deposit
        onView(withId(R.id.newTransactionButton))
                .perform(click());
        onView(withId(R.id.descriptionEditText))
                .perform(clearText(), typeText("Paycheck"), closeSoftKeyboard());
        onView(withId(R.id.amountEditText))
                .perform(clearText(), typeText("2500"), closeSoftKeyboard());
        onView(withId(R.id.depositButton))
                .perform(click());

    }

    @Test
    public void testBalance() throws Exception {
        onView(withId(R.id.balanceTextView))
                .check(matches(withText("$2,300.00")));
    }

    @Test
    public void testDeposit() throws Exception {
        onView(withId(R.id.newTransactionButton))
                .perform(click());
        onView(withId(R.id.descriptionEditText))
                .perform(clearText(), typeText("Allowance"), closeSoftKeyboard());
        onView(withId(R.id.amountEditText))
                .perform(clearText(), typeText("20"), closeSoftKeyboard());
        onView(withId(R.id.depositButton))
                .perform(click());
        onView(withId(R.id.balanceTextView))
                .check(matches(withText("$2,320.00")));
    }

    @Test
    public void testWithdrawal() throws Exception {
        onView(withId(R.id.newTransactionButton))
                .perform(click());
        onView(withId(R.id.descriptionEditText))
                .perform(clearText(), typeText("tax"), closeSoftKeyboard());
        onView(withId(R.id.amountEditText))
                .perform(clearText(), typeText("500"), closeSoftKeyboard());
        onView(withId(R.id.withdrawButton))
                .perform(click());
        onView(withId(R.id.balanceTextView))
                .check(matches(withText("$1,800.00")));
    }

    @Test
    public void testMulTransaction() throws Exception {
        onView(withId(R.id.newTransactionButton))
                .perform(click());
        onView(withId(R.id.descriptionEditText))
                .perform(clearText(), typeText("dinner"), closeSoftKeyboard());
        onView(withId(R.id.amountEditText))
                .perform(clearText(), typeText("100"), closeSoftKeyboard());
        onView(withId(R.id.withdrawButton))
                .perform(click());
        onView(withId(R.id.newTransactionButton))
                .perform(click());
        onView(withId(R.id.descriptionEditText))
                .perform(clearText(), typeText("loan"), closeSoftKeyboard());
        onView(withId(R.id.amountEditText))
                .perform(clearText(), typeText("200"), closeSoftKeyboard());
        onView(withId(R.id.withdrawButton))
                .perform(click());
        onView(withId(R.id.newTransactionButton))
                .perform(click());
        onView(withId(R.id.descriptionEditText))
                .perform(clearText(), typeText("gift"), closeSoftKeyboard());
        onView(withId(R.id.amountEditText))
                .perform(clearText(), typeText("50"), closeSoftKeyboard());
        onView(withId(R.id.depositButton))
                .perform(click());
        onView(withId(R.id.newTransactionButton))
                .perform(click());
        onView(withId(R.id.descriptionEditText))
                .perform(clearText(), typeText("more gift"), closeSoftKeyboard());
        onView(withId(R.id.amountEditText))
                .perform(clearText(), typeText("150"), closeSoftKeyboard());
        onView(withId(R.id.depositButton))
                .perform(click());
        onView(withId(R.id.balanceTextView))
                .check(matches(withText("$2,200.00")));
    }
}
