package ly.generalassemb.drewmahrt.oofundamentals;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by patrickcummins on 7/11/16.
 */

public class AnimalsTest {
    @Test
    public void testLionSound(){
        Lion lion = new Lion(true);
        String actual = lion.makeNoise();
        String expected = "Roar!!!";

        assertEquals(expected, actual);

    }
    @Test
    public void testLionSpeed(){
        Lion lion = new Lion(true);


        int expectedSpeed = 50;
        int actualSpeed = lion.getTopSpeed();



        assertEquals(expectedSpeed,actualSpeed);

    }
    @Test
    public void testSnakeSound(){
       Snake snake = new Snake(true);
        String actual = snake.makeNoise();
        String expected = "Hiss!!!";




        assertEquals(expected, actual);


    }
    @Test
    public void testSnakeSpeed(){
        Snake snake = new Snake(true);


        int expectedSpeed = 5;
        int actualSpeed = snake.getTopSpeed();



        assertEquals(expectedSpeed,actualSpeed);

    }

}
