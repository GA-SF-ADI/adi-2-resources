public class SecondHighest{

    public int secondHighestCheatyWay(int[] arr){
        int[] sortedArray = Arrays.sort(arr);
        return sortedArray[sortedArray.length-2];
    }

    public int secondHighestCorrectWay(int[] arr){
        int largest;
        int secondLargest;
        if(arr.length==0){
            return -1; //just a default value I chose, no specific significance;
        }else if(arr.length==1){
            return arr[0];
        }else{
            if(arr[0]>arr[1]){
                largest = arr[0];
                secondLargest = arr[1];
            }else{
                largest = arr[1];
                secondLargest=  arr[0];
            }
            for(int i = 2; i<arr.length; i++){
                if(arr[i]>largest){
                    secondLargest= largest;
                    largest = arr[i];
                }else if(arr[i]> secondLargest){
                    secondLargest = arr[i];
                }
            }
        }
        return secondLargest;

    }
}