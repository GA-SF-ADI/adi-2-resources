/**
 * Created by audreyeso on 6/19/16.
 */
public class SodaMachine {

    double cost;
    int numOfSodas;
    double amountDeposited;
    double runningTotal;
    double runningTotalNickels;
    double runningTotalDimes;
    double runningTotalQuarters;
    double change;
    double x;

    public SodaMachine(int numOfSodas, double cost) {

        this.numOfSodas = numOfSodas;
        this.cost = cost;
    }

    public double getCost() {
        cost = numOfSodas * cost;
        System.out.println("Your soda will cost " + cost);
        return cost;
    }

    public double getAmountDeposited() {
        return amountDeposited;
    }

    public void depositNickel() {
        runningTotalNickels += 0.05;
    }

    public void depositDime() {
        runningTotalDimes += 0.10;
    }

    public void depositQuarter() {
        runningTotalQuarters += 0.25;
    }

    public double getRunningTotal() {
        double x = runningTotalNickels + runningTotalDimes + runningTotalQuarters;
        return x;
    }

    public void selectSoda() {

        x = runningTotalNickels + runningTotalDimes + runningTotalQuarters;

        change = (numOfSodas * cost) - x;

        if (x > cost) {
            System.out.println("Your change is " + change + " cents.");
        } else if (x == cost) {
            System.out.println("You paid exactly enough money.");
        } else {
            System.out.println("You did not pay enough.");
        }
    }

    public void setToZero() {
        x = 0;
        change = 0;
        numOfSodas = 0;
        cost = 0;
        amountDeposited = 0;
        runningTotalQuarters = 0;
        runningTotalDimes = 0;
        runningTotalNickels = 0;
        runningTotal = 0;
        System.out.println ("You are back to zero. Select a new soda machine.");
    }
}


