package ly.generalassemb.drewmahrt.classes_lab;

/**
 * Created by kitty on 6/17/16.
 */
public class Dog extends Mammal {
    private Boolean guard;
    private String size; //small, medium, large
    private Boolean lovesFetch;

    public Dog(int mSpeed, String mName, String mColor, Boolean guard, String size, Boolean lovesFetch) {
        super(mSpeed, false, mName, mColor, true);
        this.guard = guard;
        this.size = size;
        this.lovesFetch = lovesFetch;
    }

    public Boolean getGuard() {
        return guard;
    }

    public void setGuard(Boolean guard) {
        this.guard = guard;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Boolean getLovesFetch() {
        return lovesFetch;
    }

    public void setLovesFetch(Boolean lovesFetch) {
        this.lovesFetch = lovesFetch;
    }

    @Override
    public String toString() {
        return "Dog: " + this.getName();
    }
}
