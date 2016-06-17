package ly.generalassemb.drewmahrt.classes_lab;

/**
 * Created by nolbertoarroyo on 6/17/16.
 */
public class Bear extends Mammal {
    private boolean hibernates;
    private String region;


    public Bear(int numLegs, int topSpeed, boolean isEndangered, String name, boolean fur, boolean hibernates, String region) {
        super(numLegs, topSpeed, isEndangered, name, fur);
    }

    public boolean isHibernates() {
        return hibernates;
    }

    public void setHibernates(boolean hibernates) {
        this.hibernates = hibernates;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
