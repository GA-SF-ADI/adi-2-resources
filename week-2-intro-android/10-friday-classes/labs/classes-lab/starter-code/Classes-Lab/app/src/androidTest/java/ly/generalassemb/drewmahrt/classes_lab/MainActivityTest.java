package ly.generalassemb.drewmahrt.classes_lab;

import android.graphics.Color;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.suitebuilder.annotation.MediumTest;
import android.widget.Button;
import android.widget.TextView;


import ly.generalassemb.drewmahrt.classes_lab.Animal;
import ly.generalassemb.drewmahrt.classes_lab.MainActivity;
import ly.generalassemb.drewmahrt.classes_lab.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    MainActivity mainActivity;


    TextView output;
    TextView changedOutput;


    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        mainActivity = getActivity();

        output  = (TextView) mainActivity.findViewById(R.id.output_text);
        changedOutput = (TextView) mainActivity.findViewById(R.id.changed_output_text);

    }

    //Tests proper initialization of screen
    @MediumTest
    public void testPreconditions() {

        assertNotNull("mainActivity", mainActivity);
        assertNotNull("output is null", output);
        assertNotNull("changedOutput is null", changedOutput);

    }

    @MediumTest
    public void testAnimalTextViews() {
        assertEquals(mainActivity.getString(R.string.elephant), output.getText());
        assertEquals(mainActivity.getString(R.string.elephant), output.getText());
    }

    @MediumTest
    public void testAnimalConstruction() {

        Animal animal = new Animal(4, 50, true, "Tiger");
        assertNotNull(animal);

    }

    @MediumTest
    public void testAnimalGetters() {

        Animal animal = new Animal(4, 50, true, "Tiger");
        assertNotNull(animal);

        int numLegs = animal.getNumLegs();
        assertEquals(4, numLegs);

        int topSpeed = animal.getTopSpeed();
        assertEquals(50, topSpeed);

        boolean endangered = animal.isEndangered();
        assertEquals(true, endangered);

        String name = animal.getName();
        assertEquals("Tiger", name);

    }

    @MediumTest
    public void testAnimalSetters() {

        Animal animal = new Animal(4, 50, true, "Tiger");
        assertNotNull(animal);

        animal.setNumLegs(5);
        assertEquals(5, animal.getNumLegs());

        animal.setTopSpeed(10);
        assertEquals(10, animal.getTopSpeed());

        animal.setIsEndangered(false);
        assertEquals(false, animal.isEndangered());

        animal.setName("Changed");
        assertEquals("Changed", animal.getName());

    }


//    @MediumTest
//    public void testInvalids() {
//
//        onView(withId(R.id.inputText)).perform(clearText())
//                .perform(typeText("901"), closeSoftKeyboard());
//        TouchUtils.clickView(this, gradeButton);
//
//        onView(withText(R.string.toast_string)).inRoot(withDecorView(not(is(getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
//
//    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

}
