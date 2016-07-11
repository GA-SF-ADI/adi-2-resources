package ly.generalassemb.drewmahrt.classes_lab;

/**
 * Created by kitty on 6/17/16.
 */
public class Mammal extends Animal {

    private String coatColor;
    private boolean isCuddly;

    public Mammal(int mSpeed, boolean endangered, String mName, String mColor, boolean mCuddle){
        super(4, mSpeed, endangered, mName);
        this.coatColor = mColor;
        this.isCuddly = mCuddle;
    }

    public String getCoatColor() {
        return coatColor;
    }

    public void setCoatColor(String coatColor) {
        this.coatColor = coatColor;
    }

    public boolean isCuddly() {
        return isCuddly;
    }

    public void setCuddly(boolean cuddly) {
        isCuddly = cuddly;
    }
}
