package ly.generalassemb.drewmahrt.classes_lab;

/**
 * Created by michaeljeffress on 6/19/16.
 */
public class Snake extends Reptile{
    private boolean mIsPoisonous;

    public Snake(boolean isPoisonous){
        super(false,5,false,"Snake");
        mIsPoisonous = isPoisonous;
    }

    @Override
    public String toString() {
        return "Snake" + (mIsPoisonous? " (Poisonous)" : "");
    }
}