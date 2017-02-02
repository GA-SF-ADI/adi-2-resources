package ly.generalassemb.drewmahrt.oofundamentals;

import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Created by patrickcummins on 7/11/16.
 */

public class ZooTest {
    @Test
    public void testZooAdd(){
        Zoo zoo = Zoo.getInstance();

        int expected = zoo.getAnimals().size()+1;

        zoo.addAnimal(new Lion(true));

        int actual = zoo.getAnimals().size();

        assertEquals(expected,actual);
    }

}
