import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by patrickcummins on 6/20/16.
 */
public class Main {
    public static void main (String[]args){
        Household HouseHold1 = new Household(10000, new Dog("Finnegan"));
        Household HouseHold2 = new Household(7500, new Cat("Mr. Whiskers"));
        Household[] allHouseHoldsList = new Household[2];
        allHouseHoldsList[0] = HouseHold1;
        allHouseHoldsList[1] = HouseHold2;

        Arrays.sort(allHouseHoldsList);

        for (int i = 0; i < allHouseHoldsList.length; i++) {
            System.out.println("Household " + i + ":");
            allHouseHoldsList[i].gainIncome();
            allHouseHoldsList[i].payTaxes();
            allHouseHoldsList[i].getmPet().feed();
            allHouseHoldsList[i].getmPet().groom();
            allHouseHoldsList[i].getmPet().playWith();

        }

    }
}
