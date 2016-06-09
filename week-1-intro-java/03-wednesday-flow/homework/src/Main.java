import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by patrickcummins on 6/8/16.
 */
public class Main {
    public static void main(String[]args){

       /* ArrayList<String> zooAnimals = new ArrayList<String>();
        zooAnimals.add("Tiger");
        zooAnimals.add("Lion");
        zooAnimals.add("Elephant");
        zooAnimals.add("Warthog");
        printSortAndPrint(zooAnimals);*/

        int[] nums = new int[10];
        ArrayList<Integer>  multsOfThree= new ArrayList<Integer>();
        ArrayList<Double>  multsOfThreeDoubles= new ArrayList<Double>();
        multsOfThree = populateMultsOfThree(nums);
        multsOfThreeDoubles = populateMultsOfThreeWithDoubles(nums);


    }
    public static void printSortAndPrint(ArrayList<String> zooAnimals){
        for (int i = 0; i < zooAnimals.size(); i++) {
            System.out.println(zooAnimals.get(i));

        }
        Collections.sort(zooAnimals, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareToIgnoreCase(s2);
            }
        });
        for (int i = 0; i < zooAnimals.size(); i++) {
            System.out.println(zooAnimals.get(i));

        }

    }
    public static int[] populateWithMultiplesof17(int[] myArray){
        for (int i = 0; i < myArray.length ; i++) {
            myArray[i] = (i+1)*17;
        }
        return myArray;
    }
    public static ArrayList<Integer> populateMultsOfThree(int[] multsOf17){
        ArrayList<Integer> myArrayList = new ArrayList<Integer>();
        for (int i = 0; i <multsOf17.length ; i++) {
            if(multsOf17[i]%3 == 0){
                myArrayList.add(multsOf17[i]);
            }

        }
        return myArrayList;

    }
    public static ArrayList<Double> populateMultsOfThreeWithDoubles(int[] multsOf17){
        ArrayList<Double> myArrayList = new ArrayList<Double>();
        for (int i = 0; i <multsOf17.length ; i++) {

                myArrayList.add((double)multsOf17[i]/3);


        }
        return myArrayList;

    }
    public static ArrayList<ArrayList> createGroceryList(){
        ArrayList<String> dairy = new ArrayList<String>();
        ArrayList<String> fruit = new ArrayList<String>();
        ArrayList<String> drinks = new ArrayList<String>();
        ArrayList<String> treats = new ArrayList<String>();
        ArrayList<String> vegetables = new ArrayList<String>();
        ArrayList<ArrayList> groceries = new ArrayList<ArrayList>();
        dairy.add("milk" );
        dairy.add("cheese");
        dairy.add("butter");
        fruit.add("cherries");
        fruit.add("blueberries");
        fruit.add("strawberries");
        drinks.add("beer");
        drinks.add("whiskey");
        drinks.add("gatorade");
        treats.add("ice cream");
        treats.add("cookies");
        treats.add("candy");
        vegetables.add("broccoli");
        vegetables.add("brussel sprouts");
        vegetables.add("bell peppers");
        groceries.add(dairy);
        groceries.add(fruit);
        groceries.add(drinks);
        groceries.add(treats);
        groceries.add(vegetables);

        return groceries;
    }

}
