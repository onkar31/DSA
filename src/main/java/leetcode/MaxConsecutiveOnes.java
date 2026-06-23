package leetcode;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] arr = {1,1,0,1,1,1,1};
        int res = maxConsecutiveOnes(arr);
        System.out.println(res);
    }

    public static int maxConsecutiveOnes(int[] nums) {
        int max = 0;
        int current_number_of_ones = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                current_number_of_ones += 1;
                max = Math.max(max, current_number_of_ones);
            }else {
                current_number_of_ones = 0;
            }
        }
        return max;
    }
}
