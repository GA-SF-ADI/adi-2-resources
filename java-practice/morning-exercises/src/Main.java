import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int[] dupArr = {1, 2, 3, 2, 2, 3, 2};
        Integer[] removedArr = (Integer[]) removeDuplicatesFromArray(dupArr);
        for (int i = 0; i < removedArr.length; i++) {
            System.out.println(removedArr[i]);
        }

        int[] a1 = {17, 7, 9, 0, 0, 0};
        int[] a2 = {1, 5, 11};
        mergeSortedArrays(a1, a2);

    }

    //assume we are given an amount in cents
    public int[] change(int value) {
        int[] coinValues = {25, 10, 5, 1}; //first declare your array of values. Edit this for different denominations
        //feel free to pass coin values in as a parameter if you want to deal with custom coin vlaues
        int[] results = new int[coinValues.length];
        for (int i = 0; i < coinValues.length; i++) { //go through each coin value
            int curCoin = coinValues[i]; //get the current value
            results[i] = value / curCoin; //the result at the index of the current coin is the same as the number
            //of coins that go into making the current value
            value = value % curCoin; //value becomes what is left over after dividing by the coin value
        }
        return results;
    }

    public boolean checkBinary(int value) {
        int onesPlace;
        while (value > 0) { //do this until you get value ==0;
            onesPlace = value % 10; //get the current digit at the ones place
            if (!(onesPlace == 1 || onesPlace == 0)) { //checks if the current digit at the onesplace is 0 or 1
                return false; //if it isn't, we know the number isn't in binary
            }
            value = value / 10;//divide by 10, essentially removing the old digit at the ones place
        }
        return true;
    }

    public String reverseString(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i++) {
            result += str.charAt(i);
        }
        return result;
    }

    public String reverseStringInPlace(String str){
        char[] strAsArray = str.toCharArray();
        char cur;
        for(int i = 0; i<strAsArray.length; i++){
            cur = strAsArray[i];
            strAsArray[i] = strAsArray[strAsArray.length-1-i];
            strAsArray[strAsArray.length-1-i] =  cur;
        }
        return new String(strAsArray);
    }

    public boolean isUnique(String str) {
//        Set<Character> characterSet = new HashSet<>(); Using a set, sets don't hold duplicate values
//        for(int i = 0; i<str.length(); i++){
//            characterSet.add(str.charAt(i));
//        }
//        return characterSet.size() == str.length();
        for (int i = 0; i < str.length() - 1; i++) {
            char curChar = str.charAt(i);
            for (int j = i + 1; j < str.length(); j++) {
                if (curChar == str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public boolean containsPalindrome(String str) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char curChar = str.charAt(i);
            if (charMap.containsKey(curChar)) {
                charMap.put(curChar, charMap.get(curChar) + 1);
            } else {
                charMap.put(curChar, 1);
            }
        }
        int numOdds = 0;
        for (Character ourChar : charMap.keySet()) {
            if (charMap.get(ourChar) % 2 != 0) {
                numOdds++;
            }
        }
        if (numOdds > 1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) { //they can't be anagrams if they are not the same size
            return false;
        }
        HashMap<Character, Integer> charMap = new HashMap<>(); //put the string into a hash map
        for (int i = 0; i < str1.length(); i++) {
            char curChar = str1.charAt(i);
            if (charMap.containsKey(curChar)) {
                charMap.put(curChar, charMap.get(curChar) + 1);
            } else {
                charMap.put(curChar, 1);
            }
        }
        for (int i = 0; i < str2.length(); i++) {//loop through the second string and
            char curChar = str2.charAt(i);
            if (charMap.containsKey(curChar)) {   //if the character is in the hashmap
                if (charMap.get(curChar) == 0) { //if there are none left, we know there were more in str2 than str1
                    return false;
                }
                charMap.put(curChar, charMap.get(curChar) - 1); //decriment the character count in the hashmap
            } else {
                return false; //if the character isn't in the hashmap, return false
            }
        }
        return true; //if we go through the hashmap and don't get an error, everything is good
    }

    public String compressString(String str) {
        String result = "";
        char curChar = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (curChar == str.charAt(i)) {
                count++;
            } else {
                result += "" + curChar + count;
                curChar = str.charAt(i);
                count = 1;
            }
        }
        result += "" + curChar + count;
        return result;
    }

    public static Object[] removeDuplicatesFromArray(int[] array) {
        Arrays.sort(array);
        ArrayList myArrayList = new ArrayList();
        for (int i = 0; i < array.length; i++) {
            if (i != array.length - 1) {
                if (array[i] != array[i + 1]) {
                    myArrayList.add(array[i]);

                }
            } else {
                if (array[i] != array[i - 1]) {
                    myArrayList.add(array[i]);
                }
            }

        }
        Integer[] newArray = new Integer[myArrayList.size()];
        myArrayList.toArray(newArray);
        return newArray;

    }


    public static int[] mergeSortedArrays(int[] array1, int[] array2){
        for(int i=(array1.length-array2.length);i<array1.length;i++){
            array1[i]=array1[i]+array2[i-array1.length+array2.length];
        }
        System.out.println("Unsorted array:");
        for(int i=0;i<array1.length;i++) {
            System.out.println(array1[i]);
        }

        int small;
        int large;
        for(int j=0;j<array1.length;j++){
            for(int i=0;i<array1.length-1;i++){
                if(array1[i+1]<array1[i]){
                    small=array1[i+1];
                    large=array1[i];
                    array1[i+1]=large;
                    array1[i]=small;
                }
            }
        }
        System.out.println("sorted array:");
        for(int i=0;i<array1.length;i++) {
            System.out.println(array1[i]);
        }
        return null;
    }
}


