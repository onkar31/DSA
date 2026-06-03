package Arrays.Easy;

//Given an array of integers, rotating array of elements by k elements either left or right.

import java.util.Arrays;

public class RotateArrayBy_K {

    public static void main(String[] args) {

    }

    // Rotate the array to the right by k positions
    public static void rotateRight(int[] arr, int k) {
        int n = arr.length;
        if(n==0) return;

        k = k % n;
        //store last k elements
        int[] temp = Arrays.copyOfRange(arr, n-k, n);

        // Shift the remaining elements to the right

    }
}
