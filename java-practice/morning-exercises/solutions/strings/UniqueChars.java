public class UniqueChara{
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
}