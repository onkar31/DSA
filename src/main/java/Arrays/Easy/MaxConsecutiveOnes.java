package Arrays.Easy;

// Max Consecutive Ones

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 1, 0, 1, 1, 1};
       // System.out.println(findMaxConsecutiveOnes(arr));
        System.out.println(getMaxConesecutiveOnes(arr));
    }

    public static int getMaxConesecutiveOnes(int[] nums) {
        int count = 0, max = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                count++;
            }else  {
                count = 0;
            }
            if (count > max) {
                max = count;
            }
        }
        return max;
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int max =0;
        int count =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                count++;
                max =Math.max(max, count);
            }
            else{
                count = 0;
            }
        }
        return max;
    }
}
