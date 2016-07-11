package ly.generalassemb.drewmahrt.oofundamentals;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * James Davis (General Assembly NYC)
 * Created on 4/26/16.
 */
public class CatTest {
    @Test
    public void testIfCorrectSound() throws Exception {
        Cat cat = new Cat();

        String expectedSound = "Purr";
        String actualSound = cat.makeNoise();

        assertEquals(expectedSound, actualSound);
    }

    @Test
    public void testCorrectTopSpeed() throws Exception {
       Cat cat = new Cat();

        int expectedTopSpeed = 15; // mph
        int actualTopSpeed = cat.getTopSpeed();

        assertEquals(expectedTopSpeed, actualTopSpeed);
    }
}
