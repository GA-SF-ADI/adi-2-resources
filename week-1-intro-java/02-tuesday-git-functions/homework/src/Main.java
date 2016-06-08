/**
 * Created by sterlinggerritz on 6/7/16.
 */
public class Main {

    public static void main(String[] args) {
        echoFunc();
        System.out.println(msToDays(98976767));
        System.out.println(hasL("character in question is not here"));
    }

    public static void echoFunc() {
        String stringShouted = "asdf";
        String lastTwo = stringShouted.substring(stringShouted.length() - 2);
        System.out.println(stringShouted + lastTwo + lastTwo + lastTwo);
    }
//echo function that repeats last two characters three times

    public static float msToDays(float milliseconds) {
        float seconds = milliseconds / 1000;
        float minutes = seconds / 60;
        float hours = minutes / 60;
        float days = hours / 24;
        return days;
    }
//converts milliseconds to days

    public static boolean hasL(String inputL) {
        //returns true if it contains either upper or lowercase
        if (inputL.contains("l") || inputL.contains("L")) {
            return true;
        } else {
            return false;
        }
    }
}

