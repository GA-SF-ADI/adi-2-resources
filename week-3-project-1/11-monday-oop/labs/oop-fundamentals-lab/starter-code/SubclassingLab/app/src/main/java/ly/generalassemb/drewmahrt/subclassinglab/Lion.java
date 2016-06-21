package ly.generalassemb.drewmahrt.subclassinglab;

import android.content.Context;
import android.widget.Toast;

import java.io.Serializable;

/**
 * Created by drewmahrt on 1/26/16.
 */
public class Lion extends Mammal {
    private boolean mIsAlpha;

    public Lion(boolean isAlpha) {
        super(4, 50, false, "Lion");
        mIsAlpha = isAlpha;
    }

    public boolean isAlpha() {
        return mIsAlpha;
    }

    public void setIsAlpha(boolean mIsAlpha) {
        this.mIsAlpha = mIsAlpha;
    }

    @Override
    public String toString() {
        return "Lion" + (mIsAlpha ? " (Alpha)" : "");
    }


    @Override
    public void makeNoise(Context context) {

        Toast.makeText(context, "ROAR", Toast.LENGTH_SHORT).show();
    }
}


