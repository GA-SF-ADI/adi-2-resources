import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by jeanweatherwax on 6/1/16.
 */
public class DataCollectionsHWSoln {

    public static void main(String args[]) {

        /** Part 3 */

        ArrayList<ArrayList<String>> groceries = new ArrayList<ArrayList<String>>();
        ArrayList<String> fruit = new ArrayList<>();
        ArrayList<String> veggies = new ArrayList<>();
        ArrayList<String> dairy = new ArrayList<>();
        ArrayList<String> meats = new ArrayList<>();
        ArrayList<String> candy = new ArrayList<>();
        fruit.add("banana");
        fruit.add("apple");
        veggies.add("cucumber");
        veggies.add("tomato");
        meats.add("bacon");
        meats.add("chicken");
        meats.add("buffalo burger");
        candy.add("Skittles");
        candy.add("jelly beans");
        dairy.add("yogurt");
        groceries.add(fruit);
        groceries.add(veggies);
        groceries.add(meats);
        groceries.add(candy);
        groceries.add(dairy);

        //Print our inventory
        for(int i = 0; i < groceries.size(); i++) {
            System.out.println(groceries.get(i));
        }

        /** Bonus! */

        HashMap<String, ArrayList<String>> groceriesMap = new HashMap<>();
        groceriesMap.put("fruit", fruit);
        groceriesMap.put("veggies", veggies);
        groceriesMap.put("meats", meats);
        groceriesMap.put("candy", candy);
        groceriesMap.put("dairy", dairy);

        for(String s : groceriesMap.keySet()) {
            System.out.println(s + " : " + groceriesMap.get(s));
        }

        /** Part 2 */

        int[] nums = new int[10];
        for(int i = 0; i < 10; i++) {
            nums[i] = (i+1)*17;
            System.out.println(nums[i]);
        }

        ArrayList<Integer> multsOfThree = new ArrayList<>();
        for(int i : nums) {
            if(i%3 == 0) {
                multsOfThree.add(i);
            }
        }

        System.out.println(multsOfThree);

        long[] nums2 = new long[3];
        for(int i = 0; i < 3; i++) {
            int j = multsOfThree.get(i);
            long k = (long) j;
            nums2[i] = k;

        }


        /** Part 1 */

        ArrayList animals = new ArrayList();
        animals.add("gorilla");
        animals.add("chimp");
        animals.add("llama");
        animals.add("alpaca");
        animals.add("aardvark");

        System.out.println(animals);
        Collections.sort(animals, String.CASE_INSENSITIVE_ORDER);
        System.out.println(animals);


    }
}
