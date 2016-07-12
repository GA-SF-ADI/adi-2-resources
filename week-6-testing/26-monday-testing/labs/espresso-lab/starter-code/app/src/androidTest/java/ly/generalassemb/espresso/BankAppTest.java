package ly.generalassemb.espresso;

/**
 * Created by michaeljeffress on 7/11/16.
 */

import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;

public class BankAppTest {

    private String editText1;
    private String editText2;
    private String editText3;
    private String editText4;
    private String editText5;
    private String editText6;
    private String balance;
    private String balance2;
    private String balance3;
    private String balance4;

    @Rule
    public ActivityTestRule<BalanceActivity> balanceActivityActivityTestRule = new ActivityTestRule<BalanceActivity>(BalanceActivity.class);
    //public ActivityTestRule<MainActivity> mainTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Before
    public void setUp() throws Exception {
        ActivityTestRule<BalanceActivity> balanceActivityActivityTestRule = new ActivityTestRule<BalanceActivity>(BalanceActivity.class);
        //ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);
        editText1 = "Books";
        editText2 = "100";
        editText3 = "Food";
        editText4 = "20";
        editText5 = "Computer";
        editText6 = "200";
        balance = "$100.00";
        balance2 = "$80.00";
        balance3 = "$200.00";
        balance4 = "$160.00";

    }

//    @Test
//    public void testBalance() throws Exception {
//
//        onView(withId(R.id.newTransactionButton))
//                .perform(click());
//
//        onView(withId(R.id.descriptionEditText))
//                .perform(clearText(), typeText(editText1), closeSoftKeyboard());
//
//        onView(withId(R.id.amountEditText))
//                .perform(clearText(), typeText(editText2), closeSoftKeyboard());
//
//        onView(withId(R.id.depositButton))
//                .perform(click());
//
//        onView(withId(R.id.balanceTextView))
//                .check(matches(withText(balance)));
//
//
//    }

//    @Test
//    public void testWithdraw() throws Exception {
//
//        onView(withId(R.id.newTransactionButton))
//                .perform(click());
//
//        onView(withId(R.id.descriptionEditText))
//                .perform(clearText(), typeText(editText1), closeSoftKeyboard());
//
//        onView(withId(R.id.amountEditText))
//                .perform(clearText(), typeText(editText2), closeSoftKeyboard());
//
//        onView(withId(R.id.depositButton))
//                .perform(click());
//
//        onView(withId(R.id.newTransactionButton))
//                .perform(click());
//
//        onView(withId(R.id.descriptionEditText))
//                .perform(clearText(), typeText(editText3), closeSoftKeyboard());
//
//        onView(withId(R.id.amountEditText))
//                .perform(clearText(), typeText(editText4), closeSoftKeyboard());
//
//        onView(withId(R.id.withdrawButton))
//                .perform(click());
//
//        onView(withId(R.id.balanceTextView))
//                .check(matches(withText(balance2)));
//
//
//    }

//    @Test
//    public void testDeposit() throws Exception {
//
//        onView(withId(R.id.newTransactionButton))
//                .perform(click());
//
//        onView(withId(R.id.descriptionEditText))
//                .perform(clearText(), typeText(editText1), closeSoftKeyboard());
//
//        onView(withId(R.id.amountEditText))
//                .perform(clearText(), typeText(editText2), closeSoftKeyboard());
//
//        onView(withId(R.id.depositButton))
//                .perform(click());
//
//        onView(withId(R.id.balanceTextView))
//                .check(matches(withText(balance)));
//
//
//    }

//    @Test
//    public void testDoubleDeposit() throws Exception {
//
//        onView(withId(R.id.newTransactionButton))
//                .perform(click());
//
//        onView(withId(R.id.descriptionEditText))
//                .perform(clearText(), typeText(editText1), closeSoftKeyboard());
//
//        onView(withId(R.id.amountEditText))
//                .perform(clearText(), typeText(editText2), closeSoftKeyboard());
//
//        onView(withId(R.id.depositButton))
//                .perform(click());
//
//        onView(withId(R.id.newTransactionButton))
//                .perform(click());
//
//        onView(withId(R.id.descriptionEditText))
//                .perform(clearText(), typeText(editText1), closeSoftKeyboard());
//
//        onView(withId(R.id.amountEditText))
//                .perform(clearText(), typeText(editText2), closeSoftKeyboard());
//
//        onView(withId(R.id.depositButton))
//                .perform(click());
//
//        onView(withId(R.id.balanceTextView))
//                .check(matches(withText(balance3)));
//
//
//    }

    @Test
    public void testDoubleWithdraw() throws Exception {

        onView(withId(R.id.newTransactionButton))
                .perform(click());

        onView(withId(R.id.descriptionEditText))
                .perform(clearText(), typeText(editText5), closeSoftKeyboard());

        onView(withId(R.id.amountEditText))
                .perform(clearText(), typeText(editText6), closeSoftKeyboard());

        onView(withId(R.id.depositButton))
                .perform(click());

        onView(withId(R.id.newTransactionButton))
                .perform(click());

        onView(withId(R.id.descriptionEditText))
                .perform(clearText(), typeText(editText3), closeSoftKeyboard());

        onView(withId(R.id.amountEditText))
                .perform(clearText(), typeText(editText4), closeSoftKeyboard());

        onView(withId(R.id.withdrawButton))
                .perform(click());

        onView(withId(R.id.newTransactionButton))
                .perform(click());

        onView(withId(R.id.descriptionEditText))
                .perform(clearText(), typeText(editText3), closeSoftKeyboard());

        onView(withId(R.id.amountEditText))
                .perform(clearText(), typeText(editText4), closeSoftKeyboard());

        onView(withId(R.id.withdrawButton))
                .perform(click());

        onView(withId(R.id.balanceTextView))
                .check(matches(withText(balance4)));


    }

}
