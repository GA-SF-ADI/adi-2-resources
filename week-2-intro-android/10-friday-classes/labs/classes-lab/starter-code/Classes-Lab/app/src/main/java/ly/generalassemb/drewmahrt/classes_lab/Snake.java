package ly.generalassemb.drewmahrt.classes_lab;

/**
 * Created by kitty on 6/17/16.
 */
public class Snake extends Reptile {
    Boolean killWithVenom; //true = venom, false = squeeze

    public Snake(int mSpeed, boolean endangered, String mName, Boolean isUgly, Boolean isVenomous, Boolean killWithVenom) {
        super(0, mSpeed, endangered, mName, isUgly, isVenomous);
        this.killWithVenom = killWithVenom;
    }

    public Boolean getKillWithVenom() {
        return killWithVenom;
    }

    public void setKillWithVenom(Boolean killWithVenom) {
        this.killWithVenom = killWithVenom;
    }

    @Override
    public String toString() {
        return "Snake: " + this.getName();
    }
}
