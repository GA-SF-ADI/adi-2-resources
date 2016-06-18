package ly.generalassemb.drewmahrt.classes_lab;

/**
 * Created by kitty on 6/17/16.
 */
public class Cat extends Mammal {
    private int numOfLives;

    public Cat(int mSpeed, String mName, String mColor, int numOfLives) {
        super(mSpeed, false, mName, mColor, true);
        this.numOfLives = numOfLives;
    }

    public int getNumOfLives() {
        return numOfLives;
    }

    public void setNumOfLives(int numOfLives) {
        this.numOfLives = numOfLives;
    }
}
