package Arrays.Basics;
//  Find Second Smallest and Second Largest Element in an array
/*  Problem Statement: Given an array, find the second smallest and second largest element in the array.
    Print ‘-1’ in the event that either of them doesn’t exist.  */


import java.util.Arrays;

public class SecondLargestNum {
    public static void main(String[] args) {
        int[] arr1 = {2, 3, 4, 5, 1};
        int[] arr2 = {3, 1};
        int[] arr3 = {2};
        int[] arr4 = {7, 1, 7, 2, 7, 7, 7};         //worst case
        int[] arr5 = {3, 1, 2, 1, 3, 4, 4, 5};

        //secondNumUniqueArrayBruteForce(arr1);
        secondNumEdgeCase(arr5);
    }

    // Brute Force   TC - O(N log N)   SC- O(1)
    public static void secondNumUniqueArrayBruteForce(int[] arr) {
        int n = arr.length;
        //if array size is 0, 1
        if (n == 0 || n == 1) {
            System.out.println(-1 + " " + -1);
            return;
        }

        //This will work only when all array numbers are unique
        Arrays.sort(arr);
        int secondSmallest = arr[1];
        int secondLargest = arr[n-2];
        System.out.println("Second smallest is " + secondSmallest);
        System.out.println("Second largest is " + secondLargest);
    }

    public static void secondNumEdgeCase(int[] arr) {
        int n = arr.length;
        if (n == 0 || n == 1) {
            System.out.println(-1 + " " + -1);
            return;
        }

        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            //For smallest & Second smallest
            if (arr[i] < smallest) {
                secondSmallest = smallest;
                smallest = arr[i];
            }else if (arr[i] > smallest && arr[i] < secondSmallest) {
                secondSmallest = arr[i];
            }

            // For largest and second largest
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            }
            else if (arr[i] < largest && arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }
        if (secondSmallest == Integer.MAX_VALUE || secondLargest == Integer.MIN_VALUE) {
            System.out.println("Second element not found");
        } else {
            System.out.println("Second Smallest: " + secondSmallest);
            System.out.println("Second Largest: " + secondLargest);
        }
    }

}
