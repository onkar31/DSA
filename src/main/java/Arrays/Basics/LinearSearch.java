package Arrays.Basics;

//Given an array, and an element num the task is to find if num is present in the given array or not.
// If present print the index of the element or print -1.

public class LinearSearch {
    public static void main(String[] args) {
            int[] arr = {0, 4, 3, 2, 1, 5};
            int k = 5;
            int ele = searchElemment(arr, k);
            System.out.println(ele);
    }

    //TC - O(N)     SC - O(1)
    public static int searchElemment(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == k) {
                return i;
            }
        }
        return -1;
    }
}
