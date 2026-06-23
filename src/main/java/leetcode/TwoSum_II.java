package leetcode;

// Input Array is sorted
public class TwoSum_II {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15, 17};
        int target = 28;
        int[] res = twoSum(nums, target);
        System.out.println(res[0]+ ", " + res[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right){
            int sum = nums[left] + nums[right];
            if(sum > target){
                right--;
            }else if(sum < target){
                left++;
            }else {
                return new int[]{left + 1, right + 1};
            }
        }
        return new int[] {left + 1, right + 1};
    }
}
