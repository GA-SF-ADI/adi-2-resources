package ly.generalassemb.drewmahrt.oofundamentals;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    // testing Lion makeNoise()
    @Test
    public void testLionMakeNoise() {
        Animal simba = new Lion(true);

        String expected = "Roar!!!";
        String actual = simba.makeNoise();

        assertEquals(expected, actual);
    }
    // testing snake makeNoise()
    @Test
    public void testSnakeMakeNoise() {
        Animal snake = new Snake(true);

        String expected = "Hiss!!!";
        String actual = snake.makeNoise();

        assertEquals(expected, actual);
    }

    //testing lion getTopSpeed
    @Test
    public void testLionSpeed() {
        Animal simba = new Lion(true);
        simba.setTopSpeed(35);

        int expected = 35;
        int actual = simba.getTopSpeed();

        assertEquals(expected, actual);


    }

    //testing lion getTopSpeed
    @Test
    public void testSnakeSpeed() {
        Animal snake = new Snake(true);
        snake.setTopSpeed(10);

        int expected = 10;
        int actual = snake.getTopSpeed();

        assertEquals(expected, actual);


    }
    @Test
    public void testAddLion(){
        Animal mufasa = new Lion(true);
        Zoo.getInstance().addAnimal(mufasa);

        Boolean expected = true;
        Boolean actual = Zoo.getInstance().getAnimals().contains(mufasa);

        assertEquals(expected,actual);

    }
    @Test
    public void testAddSnake(){
        Animal mamba = new Snake(true);
        Zoo.getInstance().addAnimal(mamba);

        Boolean expected = true;
        Boolean actual = Zoo.getInstance().getAnimals().contains(mamba);

        assertEquals(expected,actual);

    }
    //added two animals and removed one to check if removeAnimal() works
    @Test
    public void testRemoveLion(){
        Animal lion = new Lion(true);
        Animal lion2 = new Lion(true);
        Zoo.getInstance().addAnimal(lion2);
        Zoo.getInstance().addAnimal(lion);
        int arraySize =Zoo.getInstance().getAnimals().size();
        Zoo.getInstance().getAnimals().remove(lion);
        int expected = arraySize-1;
        int actual = Zoo.getInstance().getAnimals().size();
        assertEquals(expected,actual);
    }
    @Test
    public void testRemoveSnake(){
        Animal snake = new Snake(true);
        Animal snake2 = new Snake(true);
        Zoo.getInstance().addAnimal(snake2);
        Zoo.getInstance().addAnimal(snake);
        int arraySize =Zoo.getInstance().getAnimals().size();
        Zoo.getInstance().getAnimals().remove(snake);
        int expected = arraySize-1;
        int actual = Zoo.getInstance().getAnimals().size();
        assertEquals(expected,actual);
    }
}