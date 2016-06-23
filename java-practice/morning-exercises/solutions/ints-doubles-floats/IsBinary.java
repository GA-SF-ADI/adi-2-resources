public class IsBinary{
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
}