/**
 * Created by patrickcummins on 6/7/16.
 */
public class Car {
    public static int mTopSpeed;
    public static int mNumberOfDoors;
    public static void assignValues(){
        mTopSpeed = (int)Math.random();
        mNumberOfDoors = (int)Math.random();

    }
    public static void printSpeedandDoors(){
        System.out.printf("Your car has the top speed of " + mTopSpeed + " mph, and for some reason has " + mNumberOfDoors + " doors.");
    }
}
