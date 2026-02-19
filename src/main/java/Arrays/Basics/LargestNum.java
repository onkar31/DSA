package Arrays.Basics;

/*
    Given an array, find the largest element in the array.
* */

public class LargestNum {

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 1};
        System.out.println("Largest Number from Array is: "+isLargestOptimised(arr));
    }

    // Brute Force  TC - O(n*n)   SC - O(1)
    public static int isLargest(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            boolean isLarger = true;
            for (int j = 0; j < n; j++) {
                if (arr[j] > arr[i]) {
                    isLarger = false;
                    break;
                }
            }
            if (isLarger) {
                return arr[i];
            }
        }

        return -1;
    }

    // Optimised TC - O(n)   SC - O(1)
    public static int isLargestOptimised(int[] arr) {
        int max = arr[0];
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}


