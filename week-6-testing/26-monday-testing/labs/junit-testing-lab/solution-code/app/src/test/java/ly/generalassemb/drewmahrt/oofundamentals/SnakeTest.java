package ly.generalassemb.drewmahrt.oofundamentals;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * James Davis (General Assembly NYC)
 * Created on 4/26/16.
 */
public class SnakeTest {
    @Test
    public void testIfCorrectSound() throws Exception {
        Snake snake = new Snake(true);

        String expectedSound = "Hiss!!!";
        String actualSound = snake.makeNoise();

        assertEquals(expectedSound, actualSound);
    }

    @Test
    public void testCorrectTopSpeed() throws Exception {
        Snake snake = new Snake(false);

        int expectedTopSpeed = 5; // mph
        int actualTopSpeed = snake.getTopSpeed();

        assertEquals(expectedTopSpeed, actualTopSpeed);
    }
}
