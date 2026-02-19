package Arrays.Basics;

//Given an integer array nums, rotate the array to the left by one.

public class LeftRotateArray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        //int[] temp = rotateLeftBruteForce(nums);
        int[] temp = rotateLeftOptimal(nums);
        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i] + " ");
        }
    }

    // TC - O(N)    SC - O(N)
    public static int[] rotateLeftBruteForce(int[] arr) {
       int n = arr.length;
       int[] temp = new int[n];
       for (int i = 1; i < n; i++) {
           temp[i-1] = arr[i];
       }
       temp[n-1] = arr[0];
       return temp;
    }

    //Optimal Approach
    public static int[] rotateLeftOptimal(int[] nums) {
        int n = nums.length;
        int temp = nums[0];
        for (int i = 1; i < n; i++) {
            nums[i - 1] = nums[i];
        }
        nums[n-1] = temp;
        return nums;
    }
}
