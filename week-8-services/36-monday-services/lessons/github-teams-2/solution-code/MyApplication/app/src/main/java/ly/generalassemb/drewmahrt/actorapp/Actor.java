package ly.generalassemb.drewmahrt.actorapp;

/**
 * Created by drewmahrt on 2/29/16.
 */
public class Actor {
    private String mName;
    private String mDob;
    private int mNumOscars;

    public Actor(String name, String dob, int numOscars){
        mName = name;
        mDob = dob;
        mNumOscars = numOscars;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmDob() {
        return mDob;
    }

    public void setmDob(String mDob) {
        this.mDob = mDob;
    }

    public int getmNumOscars() {
        return mNumOscars;
    }

    public void setmNumOscars(int mNumOscars) {
        this.mNumOscars = mNumOscars;
    }
}
