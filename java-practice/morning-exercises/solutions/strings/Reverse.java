public class Reverse{
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
}