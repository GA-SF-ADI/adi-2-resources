/**
 * Created by patrickcummins on 6/20/16.
 */
public abstract class Pet {
    private String mPetName;
    private boolean fed;
    private boolean groomed;

    public void setmPetName(String mPetName) {
        this.mPetName = mPetName;
    }

    public void setFed(boolean fed) {
        this.fed = fed;
    }

    public void setGroomed(boolean groomed) {
        this.groomed = groomed;
    }

    public void setPlayedWith(boolean playedWith) {
        this.playedWith = playedWith;
    }

    public boolean isPlayedWith() {

        return playedWith;
    }

    public String getmPetName() {
        return mPetName;
    }

    public boolean isFed() {
        return fed;
    }

    public boolean isGroomed() {
        return groomed;
    }

    private boolean playedWith;

    public Pet(String mPetName) {
        this.mPetName = mPetName;
        fed = false;
        groomed = false;
        playedWith =false;

    }
    public void feed(){
        fed = true;
        System.out.println(mPetName+ " was fed!");
    }
    public void groom(){
        groomed=true;
        System.out.println(mPetName+ " was groomed!");
    }
    public void playWith(){
        playedWith=true;
        System.out.println(mPetName+ " was played with!");
    }

}
