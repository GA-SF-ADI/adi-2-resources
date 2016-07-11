package co.ga.junittesting;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kitty on 7/11/16.
 */
public class SomeTest {
    @Test
    public void testMultInt(){
        int actual = MathUtils.multiply(3, 5, 4, 100);
        int expected = 3*5*4*100;

        assertEquals(expected, actual);
    }

    @Test
    public void testMultDecimal(){
        double actual = MathUtils.multiply(0.5, 0.25, 10);
        double expected = 0.5*0.25*10;

        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testAddInt(){
        int actual = MathUtils.add(47, 23, 1357);
        int expected = 47+23+1357;

        assertEquals(expected, actual);
    }

    @Test
    public void testAddDecimal(){
        double actual = MathUtils.add(4.3, 0.3, 1.23);
        double expected = 4.3+0.3+1.23;

        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testSqInt() {
        int actual = MathUtils.square(7);
        int expected = 7^2;

        assertEquals(expected, actual);
    }

    @Test
    public void testSqDecimal() {
        double actual = MathUtils.square(2.5);
        double expected = 2.5*2.5;

        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testPythagoreanInt() {
        int actual = MathUtils.pythagorean(3, 4);
        int expected = 5;

        assertEquals(expected, actual);
    }

    @Test
    public void testPythagoreanDecimal() throws Exception {
        double actual = MathUtils.pythagorean(0.3, 0.4);
        double expected = 0.5;

        assertEquals(expected, actual, 0.01);
    }

}
