/**
 * Created by patrickcummins on 6/20/16.
 */
public class Household implements Comparable<Household> {
    private double income;
    private double mTotalmoney;
    private Pet mPet;

    public Household(double income, Pet housePet) {
        this.income = income;
        this.mPet = housePet;
        this.mTotalmoney = 0;
    }

    public void gainIncome(){
        this.mTotalmoney += this.income;
        System.out.println("Gained $" + this.income );
    }
    public void payTaxes(){
        this.mTotalmoney -= (this.income*.2);
        System.out.println("Paid $" + this.income*.2 + " in Taxes");
    }

    public double getIncome() {
        return income;
    }

    public double getmTotalmoney() {
        return mTotalmoney;
    }

    public Pet getmPet() {
        return mPet;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public void setmTotalmoney(double mTotalmoney) {
        this.mTotalmoney = mTotalmoney;
    }

    public void setmPet(Pet mPet) {
        this.mPet = mPet;
    }

    @Override
    public int compareTo(Household o) {
        int result = 0;
        if(this.income < o.getIncome()) {
            result = -1;
        } else if(this.income > o.getIncome()) {
            result = 1;
        }
        return result;
    }
}
