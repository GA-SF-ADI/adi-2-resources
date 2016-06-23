public class Compress{
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

}