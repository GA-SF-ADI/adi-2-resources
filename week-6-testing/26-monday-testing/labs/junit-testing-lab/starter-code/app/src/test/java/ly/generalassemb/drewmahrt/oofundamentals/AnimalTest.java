package ly.generalassemb.drewmahrt.oofundamentals;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Jon Kim on 7/11/16.
 */
public class AnimalTest {

    @Test
    public void testSound(){
        String expectedSound,actualSound;
        Lion myLion = new Lion(true);
        Snake mySnake = new Snake(true);

        expectedSound = "Roar!!!";
        actualSound = myLion.makeNoise();
        assertEquals(expectedSound,actualSound);

        expectedSound = "Hiss!!!";
        actualSound = mySnake.makeNoise();
        assertEquals(expectedSound,actualSound);
    }

    @Test
    public void testTopSpeed(){
        int expectedTopSpeed,actualTopSpeed;
        Lion myLion = new Lion(true);
        Snake mySnake = new Snake(true);

        expectedTopSpeed = 50;
        actualTopSpeed = myLion.getTopSpeed();
        assertEquals(expectedTopSpeed,actualTopSpeed);

        expectedTopSpeed = 5;
        actualTopSpeed = mySnake.getTopSpeed();
        assertEquals(expectedTopSpeed,actualTopSpeed);

    }

    @Test
    public void testZoo(){
        Lion myLion = new Lion(true);
        Lion myLion1 = new Lion(false);
        Lion myLion3 = new Lion(false);
        Zoo myZoo = Zoo.getInstance();
        ArrayList<Animal> actualList;

        myZoo.addAnimal(myLion);
        myZoo.addAnimal(myLion1);
        myZoo.addAnimal(myLion3);
        actualList = myZoo.getAnimals();

        //could use assertTrue instead of assertEquals. assertTrue() takes in one boolean equality,
        //perhaps either a size comparison or .contains
        assertTrue(actualList.contains(myLion));


        myZoo.removeAnimal(myLion);
        actualList = myZoo.getAnimals();

        assertTrue(actualList.size()==2);




    }

}
