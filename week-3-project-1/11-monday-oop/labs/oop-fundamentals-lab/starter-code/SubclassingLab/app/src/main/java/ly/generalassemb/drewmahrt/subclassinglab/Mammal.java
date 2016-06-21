package ly.generalassemb.drewmahrt.subclassinglab;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by drewmahrt on 12/7/15.
 */
public class Mammal extends Animal {
    int mNumLegs;

    public Mammal(int numLegs, int topSpeed, boolean isEndangered, String name){
        super(topSpeed, isEndangered, name);
        this.mNumLegs = numLegs;
    }

    public int getNumLegs() {
        return mNumLegs;
    }

    public void setNumLegs(int numLegs) {
        this.mNumLegs = numLegs;
    }

    @Override
    public void makeNoise(Context context) {

        Toast.makeText(context,"mammal noise", Toast.LENGTH_SHORT).show();
    }
}
