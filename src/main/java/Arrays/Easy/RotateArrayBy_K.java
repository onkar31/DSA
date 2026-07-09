package Arrays.Easy;

//Given an array of integers, rotating array of elements by k elements either left or right.

public class RotateArrayBy_K {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k= 6;
        int[] result = rotateRight(arr, k);
        for(int num : result){
            System.out.print(num + " ");
        }
    }

    // Rotate the array to the right by k positions
    public static int[] rotateRight(int[] nums, int k) {
        int n = nums.length;
        if(n==0) return nums;

        k = k % n;
        reverse(nums, 0, nums.length -1);
        reverse(nums, 0, k -1);
        reverse(nums, k, nums.length -1);
        return nums;
    }

    public static int[] reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
        return nums;
    }
}
