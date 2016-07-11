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
    public void testMultiply(){



        int expected = 20;
        int actual=MathUtils.multiply(5,4);
        assertEquals(expected,actual);

}
    @Test
    public void testDoubleMultiply(){
        double expected =4.00;
        double actual = MathUtils.multiply(2.00,2.00);
        assertEquals(expected,actual,.01);
    }
    @Test
    public void testAdd(){
        int expected = 20;
        int actual = MathUtils.add(10,10);
        assertEquals(expected,actual);
    }
}