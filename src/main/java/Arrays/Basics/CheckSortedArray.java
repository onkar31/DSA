package Arrays.Basics;

//Check if the array is sorted

public class CheckSortedArray {

    public static void main(String[] args) {

        int sorted[] = {1, 2,  3, 4, 5};
        int not_sorted[] = {1, 2,  3, 4, 5, 2};
        System.out.println(checkSortedArrayOptimised(sorted));
        System.out.println(checkSortedArrayOptimised(not_sorted));
    }

    // Brute Force  TC - O(n*n)   SC - O(1)
    public static boolean checkSortedArrayBruteForce(int[] arr) {
        int n =  arr.length;
        for (int i = 0; i<n-1; i++) {
            for (int j = i+1; j<n; j++) {
                if (arr[i] > arr[j])
                   return false;
            }
        }
        return true;
    }

    // Optimised  TC - O(n)   SC - O(1)
    public static boolean checkSortedArrayOptimised(int[] arr) {
        int n =  arr.length;
        for (int i = 1; i<n; i++) {
            if(arr[i] < arr[i-1]){
                return false;
            }
        }
        return true;
    }
}
