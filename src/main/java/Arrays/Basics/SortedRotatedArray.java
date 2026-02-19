package Arrays.Basics;

// Check if Array Is Sorted and Rotated - Leetcode 1752

public class SortedRotatedArray {

    public static void main(String[] args) {
        int[] nums1 = {3,4,5,1,2};      //true
        int[] nums2 = {2,1,3,4};        //false
        int[] nums3 = {1, 2, 3};        //true
        System.out.println(check(nums1));
    }
    public static boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;
        for(int i = 0 ; i < n-1; i++){
            if(nums[i] > nums[i+1]){
                count++;
            }
        }
        if(nums[n-1] > nums[0]){
            count++;
        }
        return count <= 1;
    }

    //Optimised
    public boolean checkOptimised(int[] nums) {
        int count = 0;
        int n = nums.length;

        for(int i = 0 ; i < n; i++){
            if(nums[i] > nums[(i+1) % n] ){
                count++;
            }
            if(count > 1){
                return false;
            }
        }
        return true;
    }
}
