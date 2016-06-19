/**
 * Created by audreyeso on 6/19/16.
 */
public class SodaMachineTester {

    public static void main (String [] args) {

        SodaMachine colaMachine = new SodaMachine(35, 0.50);
        colaMachine.getCost();
        System.out.println("You have deposited $" + colaMachine.getAmountDeposited() + " cents.");
        colaMachine.depositNickel();
        colaMachine.depositNickel();
        colaMachine.depositQuarter();
        System.out.println("You have deposited $"+ colaMachine.getRunningTotal() + " cents.");
        colaMachine.selectSoda();

        colaMachine.setToZero();

        //I tried to set all of the variables back to zero so that it wouldn't save previous "colaMachine"
        // does not work perfectly and not sure why!

        SodaMachine water = new SodaMachine(3, 0.50);
        water.getCost();
        System.out.println("You have deposited $" + water.getAmountDeposited() + " cents.");
        water.depositQuarter();
        water.depositQuarter();
        water.depositQuarter();
        water.depositQuarter();
        water.depositQuarter();
        water.depositQuarter();
        water.depositQuarter();
        System.out.println("You have deposited $"+ water.getRunningTotal() + " cents.");
        water.selectSoda();
    }
}
