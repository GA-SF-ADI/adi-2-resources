package ly.generalassemb.espresso;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import static android.support.test.espresso.Espresso.onView;

/**
 * Created by Jon Kim on 7/11/16.
 */
@RunWith(AndroidJUnit4.class)
public class BalanceScreenTest {

    @Rule
    public ActivityTestRule<BalanceActivity> mBalanceActivityRule = new ActivityTestRule<BalanceActivity>(BalanceActivity.class);

    @Before
    public void setUp() throws Exception {
        Float myNum;
        onView(withId(R.id.amountEditText))

    }
}
