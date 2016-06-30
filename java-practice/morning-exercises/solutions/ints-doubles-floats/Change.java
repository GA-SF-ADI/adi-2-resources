public class Change{


    public int[] change(int value) {
        int[] coinValues = {25, 10, 5, 1}; //first declare your array of values. Edit this for different denominations
        //feel free to pass coin values in as a parameter if you want to deal with custom coin vlaues
        int[] results = new int[coinValues.length];
        for (int i = 0; i < coinValues.length; i++){ //go through each coin value
            int curCoin=coinValues[i]; //get the current value
            results[i]=value/curCoin; //the result at the index of the current coin is the same as the number
            //of coins that go into making the current value
            value=value%curCoin; //value becomes what is left over after dividing by the coin value
        }
        return results;
    }
}

