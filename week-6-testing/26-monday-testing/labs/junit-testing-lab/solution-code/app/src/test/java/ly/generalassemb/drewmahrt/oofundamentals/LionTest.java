package ly.generalassemb.drewmahrt.oofundamentals;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * James Davis (General Assembly NYC)
 * Created on 4/26/16.
 */
public class LionTest {
    @Test
    public void testIfCorrectSound() throws Exception {
        Lion lion = new Lion(true);

        String expectedSound = "Roar!!!";
        String actualSound = lion.makeNoise();

        assertEquals(expectedSound, actualSound);
    }

    @Test
    public void testCorrectTopSpeed() throws Exception {
        Lion lion = new Lion(false);

        int expectedTopSpeed = 50; // mph
        int actualTopSpeed = lion.getTopSpeed();

        assertEquals(expectedTopSpeed, actualTopSpeed);
    }
}
