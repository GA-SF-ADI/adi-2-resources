package ly.generalassemb.drewmahrt.subclassinglab;

import android.content.Context;
import android.widget.Toast;

import java.io.Serializable;

/**
 * Created by drewmahrt on 1/26/16.
 */
public class Snake extends Reptile {
    private boolean mIsPoisonous;

    public Snake(boolean isPoisonous) {
        super(false, 5, false, "Snake");
        mIsPoisonous = isPoisonous;
    }

    @Override
    public String toString() {
        return "Snake" + (mIsPoisonous ? " (Poisonous)" : "");
    }

    @Override
    public void makeNoise(Context context) {

        Toast.makeText(context, "HISS", Toast.LENGTH_SHORT).show();
    }
}