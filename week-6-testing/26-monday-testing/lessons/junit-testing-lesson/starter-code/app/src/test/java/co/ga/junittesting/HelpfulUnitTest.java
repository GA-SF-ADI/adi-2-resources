package co.ga.junittesting;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class HelpfulUnitTest {
    @Test
    public void usefulMethods() throws Exception {
        assertEquals(4, 2 + 2);
        assertTrue(true);
        assertFalse(false);
        assertNull(null);
        assertNotNull("Not null");
    }

    @Test
    public void testIfMultiplyIsCorrect(){
        int actual = MathUtils.multiply(2,3,5);
        int expected = 30;

        assertEquals(expected,actual);
    }

//    @Test
//    public void testIfMultiplyIsCorrect(){
//        double actual = MathUtils.multiply(2,5,.5);
//        double expected = 10;
//
//        assertEquals(expected,actual);
//    }
    @Test
    public void testIfAddIsCorrect(){
        int actual = MathUtils.add(2,4,8,10);
        int expected = 24;

        assertEquals(expected,actual);
    }


}