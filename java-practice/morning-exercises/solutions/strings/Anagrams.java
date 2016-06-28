public class Anagrams{
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

}