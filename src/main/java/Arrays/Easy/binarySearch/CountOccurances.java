package Arrays.Easy.binarySearch;

import static Arrays.Easy.binarySearch.FirstOccurance.firstOccurance;
import static Arrays.Easy.binarySearch.LastOccurance.lastOccurance;

public class CountOccurances {

    public static void main(String[] args) {
        int[] arr = {1,2,2,2,3,4,5};
        int target = 2;
        int count = countOccurance(arr, target);
        System.out.println("Total Occurance: " + count);
    }

    public static int countOccurance(int[] arr, int target) {
        int first = firstOccurance(arr, target);
        int  last = lastOccurance(arr, target);
        int count = 0;
        if(first == -1){
            return -1;
        }else {
            count = last - first + 1;
        }
        return count;
    }
}
