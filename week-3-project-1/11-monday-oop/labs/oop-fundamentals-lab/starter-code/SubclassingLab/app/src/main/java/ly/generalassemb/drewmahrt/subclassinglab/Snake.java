package ly.generalassemb.drewmahrt.subclassinglab;

import android.widget.Toast;

import java.io.Serializable;

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
    public String makeNoise(){
        return "Hisssss";

    }

    @Override
    public String toString() {
        return "Snake" + (mIsPoisonous? " (Poisonous)" : "");
    }
}
