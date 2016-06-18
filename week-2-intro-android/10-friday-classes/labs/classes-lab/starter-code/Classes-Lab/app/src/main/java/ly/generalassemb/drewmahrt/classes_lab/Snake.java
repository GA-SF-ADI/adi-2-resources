package ly.generalassemb.drewmahrt.classes_lab;

/**
 * Created by LangstonSmith on 6/17/16.
 */
public class Snake extends Reptile {
    private Boolean tongueFlick;

    private Boolean rattler;

    public Snake(int numLegs, int topSpeed, boolean isEndangered, String name, Boolean scales, int eggs, Boolean tongueFlick, Boolean rattler) {
        super(numLegs, topSpeed, isEndangered, name, scales, eggs);
        this.tongueFlick = tongueFlick;
        this.rattler = rattler;
    }

    public Boolean getTongueFlick() {
        return tongueFlick;
    }

    public void setTongueFlick(Boolean tongueFlick) {
        this.tongueFlick = tongueFlick;
    }

    public Boolean getRattler() {
        return rattler;
    }

    public void setRattler(Boolean rattler) {
        this.rattler = rattler;
    }
}