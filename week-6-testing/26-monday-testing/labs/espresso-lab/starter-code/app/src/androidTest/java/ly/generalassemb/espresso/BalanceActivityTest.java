package ly.generalassemb.espresso;
import android.app.Activity;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

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
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


/**
 * Created by nolbertoarroyo on 7/11/16.
 */
@RunWith(AndroidJUnit4.class)
public class BalanceActivityTest {
    String balanceText;
    String ansBalance;

    @Rule
    public ActivityTestRule<BalanceActivity> mActivityRule = new ActivityTestRule<>(BalanceActivity.class);
    /*Use the following user stories for each test. "As a user":

    I can view my current balance.
    I can withdraw money from my account.
    I can deposit money into my account.
    I can perform multiple back-to-back withdrawals and deposits without fail.
*/
    @Before
    public void setUp() throws Exception{
        balanceText = "$500.00";


    }

    @Test
    public void testCurrentBalanceView() throws Exception {

        onView(withId(R.id.balanceTextView))
                .check(matches(isDisplayed()));

    }

    @Test
    public void testWithdraw() throws Exception {
         ansBalance ="-$500.00";

        onView(withId(R.id.amountEditText))
                .perform(clearText(),typeText(balanceText),closeSoftKeyboard());
        onView(withId(R.id.withdrawButton))
                .perform(click());
        onView(withId(R.id.balanceTextView))
                .check(matches(withText(ansBalance)));
    }
    @Test
    public void testDeposit() throws Exception {
        balanceText= "$500.00";


        onView(withId(R.id.amountEditText))
                .perform(clearText(),typeText(balanceText),closeSoftKeyboard());
        onView(withId(R.id.depositButton))
                .perform(click());
        onView(withId(R.id.balanceTextView))
                .check(matches(withText(balanceText)));
    }
    @Test
    public void testWithdrawals() throws Exception {
        String startingBal="1000";
        String withdraw = "100";
        String endBal = "$800.00";


        //adding starting balance
        onView(withId(R.id.amountEditText))
                .perform(clearText(),typeText(startingBal),closeSoftKeyboard());
        onView(withId(R.id.depositButton))
                .perform(click());

        //First withdraw
        onView(withId(R.id.amountEditText))
                .perform(clearText(),typeText(withdraw),closeSoftKeyboard());
        onView(withId(R.id.withdrawButton))
                .perform(click());

        //second withdraw
        onView(withId(R.id.amountEditText))
                .perform(clearText(),typeText(withdraw),closeSoftKeyboard());
        onView(withId(R.id.withdrawButton))
                .perform(click());
        onView(withId(R.id.balanceTextView))
                .check(matches(withText(endBal)));




    }


}
