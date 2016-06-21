package ly.generalassemb.drewmahrt.subclassinglab;

/**
 * Created by drewmahrt on 1/26/16.
 */
public class Snake extends Reptile{
    private boolean mIsPoisonous;

    public Snake(boolean isPoisonous){
        super(false,5,false,"Snake");
        mIsPoisonous = isPoisonous;
    }
    @Override
    public String makeNoise() { return "hiss";}

    @Override
    public String toString() {
        return "Snake" + (mIsPoisonous? " (Poisonous)" : "");
    }
}
