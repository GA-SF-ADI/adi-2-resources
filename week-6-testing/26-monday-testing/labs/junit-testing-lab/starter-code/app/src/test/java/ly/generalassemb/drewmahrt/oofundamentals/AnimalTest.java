package ly.generalassemb.drewmahrt.oofundamentals;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kitty on 7/11/16.
 */
public class AnimalTest {

    @Test
    public void testNoise() {
        String actual, expected;

        // Lion
        actual = new Lion(true).makeNoise();
        expected = "Roar!!!";
        assertEquals("makeNoise() | makeNoise did not work as expected", actual, expected);

        // Snake
        actual = new Snake(true).makeNoise();
        expected = "Hiss!!!";
        assertEquals("makeNoise() | makeNoise did not work as expected", actual, expected);
    }

    @Test
    public void testTopSpeed() {
        int actual, expected;

        // Lion
        actual = new Lion(true).getTopSpeed();
        expected = 50;
        assertEquals("getTopSpeed() | top speed did not work as expected", actual, expected);

        // Snake
        actual = new Snake(true).getTopSpeed();
        expected = 5;
        assertEquals("getTopSpeed() | top speed did not work as expected", actual, expected);
    }

    @Test
    public void testZooAddRemoveAnimal() {
        int actual, expected;
        Zoo mZoo = Zoo.getInstance();
        Animal toRemove = new Snake(true);

        mZoo.addAnimal(new Lion(true));
        mZoo.addAnimal(new Lion(false));
        mZoo.addAnimal(new Snake(false));
        mZoo.addAnimal(toRemove);
        mZoo.removeAnimal(toRemove);

        actual = mZoo.getAnimals().size();
        expected = 3;

        assertEquals("addAnimal/removeAnimal() | add/remove animal did not work as expected", actual, expected);
    }
}
